package com.qf.common.base.result;

import lombok.Getter;

@Getter
public enum ResultCode {
    CABINET_NO_EXISTS(41000,"不存在"),
    CABINET_EXISTS(41100,"已存在"),
    /**
     * 成功
     */
    SUCCESS(200, "success"),
    /**
     *
     */
    SYS_ERROR(40000, "error"),
    /**
     *
     */
    USER_PASSWORD_ERROR(40100, "账号密码错误"),
    /**
     *
     */
    USER_EXIST(40101,"账号已存在");

    final int code;
    final String msg;

    ResultCode(int code, String msg) {
        this.code = code;
        this.msg = msg;
    }
}
