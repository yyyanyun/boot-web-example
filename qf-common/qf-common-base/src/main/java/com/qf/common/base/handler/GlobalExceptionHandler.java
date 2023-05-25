package com.qf.common.base.handler;


import com.qf.common.base.exception.BaseException;
import com.qf.common.base.result.RespResult;
import com.qf.common.base.vo.ArgsErrorVO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.validation.BindException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.validation.ConstraintViolationException;
import java.util.List;
import java.util.stream.Collectors;

/**
 * 异常如何处理
 * 自定义异常  扩展异常(让异常有意义,方便开发排查)  控制层异常  业务层异常 数据层异常
 * 原则
 * 能抛出异常抛出异常
 */
//Rest 前后端分离

/**
 * 错误通知
 */

@Component
@RestControllerAdvice
@Slf4j
public class GlobalExceptionHandler {

    @ExceptionHandler(Exception.class)
    public RespResult<Object> handlerException(Exception ex) {
        log.error(ex.getMessage());
        return RespResult.error();
    }

    @ExceptionHandler(BaseException.class)
    public RespResult<Object> handlerBaseException(BaseException ex) {
        log.error(ex.getMessage());
        return RespResult.error(ex.getResultCode());
    }

    /**
     * 获取数据行+ 错误信息
     * BindException ： 对象校验异常
     *
     * @param ex
     * @return
     */
    @ExceptionHandler(BindException.class)
    public RespResult<Object> handlerException(BindException ex) {
        //普通模式获取所有的参数校验错误信息
        List<ArgsErrorVO> errors = ex.getBindingResult()
                .getAllErrors()
                .stream()
                .map(
                        error ->
                                ArgsErrorVO.builder()
                                        .errorMsg(error.getDefaultMessage())
                                        .fieldName(error.getObjectName())
                                        .build()
                ).collect(Collectors.toList());
        return RespResult.builder().msg("校验失败").code(400000).data(errors).build();
    }

    /**
     * ConstraintViolationException ： 单个参数异常
     *
     * @param ex
     * @return
     */
    @ExceptionHandler(ConstraintViolationException.class)
    public RespResult<Object> handlerException(ConstraintViolationException ex) {
        return RespResult.builder().msg("系统异常").code(404).build();
    }

    /**
     * MethodArgumentNotValidException ：@Valid @RequestBody 异常
     *
     * @param ex
     * @return
     */
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public RespResult<Object> handlerException(MethodArgumentNotValidException ex) {
        //ex 标识被捕获的MethodArgumentNotValidException 类型的异常信息
        /**
         * BindingResult 类: 用于保存校验的结果，包含了所有校验失败的信息
         * .getAllErrors()方法：返回校验失败的字段列表
         */
        List<ArgsErrorVO> errors =
                //获取所有校验失败的信息
                ex.getBindingResult()
                        // 获取校验失败的字段信息
                        .getAllErrors()
                        // 转为stream 流
                        .stream()
                        // map转换类型
                        .map(
                                // FiledError对象
                                error ->
                                        ArgsErrorVO.builder()
                                                //.getDefaultMessage()
                                                .errorMsg(error.getDefaultMessage())
                                                // .getObjectName()： 获取当前校验对象的名称
                                                .fieldName(error.getObjectName())
                                                .build()
                        ).collect(Collectors.toList());
        return RespResult.builder().msg("校验失败").code(400000).data(errors).build();
    }
}
