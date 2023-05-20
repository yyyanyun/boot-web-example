package com.qf.common.base.exception;


import com.qf.common.base.result.ResultCode;

public class DaoException extends BaseException {

    public DaoException(ResultCode resultCode) {
        super(resultCode);
    }
}
