package com.qf.common.base.exception;


import com.qf.common.base.result.ResultCode;

public class ControllerException extends BaseException {

    public ControllerException(ResultCode resultCode) {
        super(resultCode);
    }
}
