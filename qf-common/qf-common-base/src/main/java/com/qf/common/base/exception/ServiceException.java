package com.qf.common.base.exception;


import com.qf.common.base.result.ResultCode;

public class ServiceException extends BaseException {

    public ServiceException(ResultCode resultCode) {
        super(resultCode);
    }
}
