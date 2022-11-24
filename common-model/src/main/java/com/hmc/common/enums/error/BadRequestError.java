package com.hmc.common.enums.error;

import com.hmc.common.exception.ResponseError;

public enum BadRequestError implements ResponseError {
    ;

    @Override
    public String getName() {
        return null;
    }

    @Override
    public String getMessage() {
        return null;
    }

    @Override
    public int getStatus() {
        return 0;
    }

    @Override
    public Integer getCode() {
        return ResponseError.super.getCode();
    }
}
