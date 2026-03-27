package com.junin.financetrackerapi.exception;

import java.time.LocalDateTime;
import java.util.List;

public record ErrorResponse(
        int status,
        String error,
        String message,
        LocalDateTime timestamp,
        List<FieldError> errors
) {
    public record FieldError(String field, String message) {}

    public static ErrorResponse of(int status, String error, String message) {
        return new ErrorResponse(status, error, message, LocalDateTime.now(), null);
    }

    public static ErrorResponse ofValidation(int status, String error, String message, List<FieldError> errors) {
        return new ErrorResponse(status, error, message, LocalDateTime.now(), errors);
    }
}