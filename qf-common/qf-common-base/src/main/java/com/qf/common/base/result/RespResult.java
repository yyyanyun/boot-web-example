package com.qf.common.base.result;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

//用户名存在  40000
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class RespResult<T> {
    /**
     * 错误信息  产品经理
     */
    private String msg;
    /**
     * 状态码
     */
    private int code;
    /**
     * 数据
     */
    private T data;

    /**
     * 定好规范
     *
     * @param data
     * @param <T>
     * @return
     */
    public static <T> RespResult<T> success(ResultCode resultCode, T data) {
        return common(resultCode, data);
    }

    public static <T> RespResult<T> success(T data) {
        return success(ResultCode.SUCCESS, data);
    }

    public static <T> RespResult<T> error(ResultCode resultCode) {
        return common(resultCode, null);
    }

    public static <T> RespResult<T> error() {
        return error(ResultCode.SYS_ERROR);
    }
    public static RespResult<String> error(String message) {
        return common(ResultCode.SYS_ERROR,message);
    }


    private static <T> RespResult<T> common(ResultCode resultCode, T data) {
        RespResult<T> result = new RespResult<>();
        result.setCode(resultCode.getCode());
        result.setMsg(resultCode.getMsg());
        result.setData(data);
        return result;
    }
}
