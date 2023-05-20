package com.qf.common.base.exception;

import com.qf.common.base.result.ResultCode;
import lombok.Getter;

@Getter
public class BaseException extends RuntimeException {
    private ResultCode resultCode;

    public BaseException(ResultCode resultCode) {
        this.resultCode = resultCode;
    }
}
