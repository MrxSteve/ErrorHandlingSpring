package com.stevedev.manejoerrores.errors;

public class BusinessException extends RuntimeException {
    public BusinessException(String message) {
        super(message);
    }
}
