package com.hmc.advice;

import com.hmc.common.dto.response.ErrorResponse;
import com.hmc.common.exception.ResponseError;
import com.hmc.common.exception.ResponseException;
import com.hmc.i18n.LocaleStringService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.servlet.http.HttpServletRequest;

@ControllerAdvice
@Slf4j
public class ExceptionHandleAdvice {

    private final LocaleStringService localeStringService;

    @Autowired
    public ExceptionHandleAdvice(LocaleStringService localeStringService) {
        this.localeStringService = localeStringService;
    }

    @ExceptionHandler(ResponseException.class)
    public ResponseEntity<ErrorResponse<Object>> handleResponseException(ResponseException e, HttpServletRequest request) {
        log.warn("Failed to handle request {}: {}", request.getRequestURI(), e.getError().getMessage(), e);
        ResponseError error = e.getError();
        String message = localeStringService.getMessage(error.getName(), e.getError().getMessage(), e.getParams());
        ErrorResponse response = ErrorResponse.builder()
                .code(error.getCode())
                .message(error.getMessage())
                .error(error.getName())
                .build();
        return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
    }

}
