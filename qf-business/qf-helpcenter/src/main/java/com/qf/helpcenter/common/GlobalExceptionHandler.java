package com.qf.helpcenter.common;

import com.qf.common.base.result.RespResult;
import org.springframework.validation.BindException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.validation.ConstraintViolationException;
import java.util.List;
import java.util.stream.Collectors;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(Exception.class)
    public RespResult<Object> handlerException(Exception ex) {
        return RespResult.builder().msg("系统异常").code(404).build();
    }

    /**
     * 获取数据行+ 错误信息
     *
     * @param ex
     * @return
     */
    @ExceptionHandler(BindException.class)
    public RespResult<Object> handlerException(BindException ex) {
        //普通模式获取所有的参数校验错误信息
        List<ArgsErrorVO> errors = ex.getBindingResult().getAllErrors().stream().map(error ->
                ArgsErrorVO.builder().errorMsg(error.getDefaultMessage()).fieldName(error.getObjectName()).build()
        ).collect(Collectors.toList());
        return RespResult.builder().msg("校验失败").code(400000).data(errors).build();
    }

    @ExceptionHandler(ConstraintViolationException.class)
    public RespResult<Object> handlerException(ConstraintViolationException ex) {
        return RespResult.builder().msg("系统异常").code(404).build();
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public RespResult<Object> handlerException(MethodArgumentNotValidException ex) {
        List<ArgsErrorVO> errors = ex.getBindingResult().getAllErrors().stream().map(error ->
                ArgsErrorVO.builder().errorMsg(error.getDefaultMessage()).fieldName(error.getObjectName()).build()
        ).collect(Collectors.toList());
        return RespResult.builder().msg("校验失败").code(400000).data(errors).build();
    }
}
