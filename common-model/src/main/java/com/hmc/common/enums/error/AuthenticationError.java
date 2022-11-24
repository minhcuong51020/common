package com.hmc.common.enums.error;

import com.hmc.common.exception.ResponseError;

public enum AuthenticationError implements ResponseError {

    AUTHENTICATION_ERROR(40101001, "Yêu cầu đăng nhập vào hệ thống"),
    ;

    private final Integer code;

    private final String message;

    AuthenticationError(Integer code, String message) {
        this.code = code;
        this.message = message;
    }

    @Override
    public String getName() {
        return name();
    }

    @Override
    public String getMessage() {
        return message;
    }

    @Override
    public int getStatus() {
        return 401;
    }

    @Override
    public Integer getCode() {
        return code;
    }
}
