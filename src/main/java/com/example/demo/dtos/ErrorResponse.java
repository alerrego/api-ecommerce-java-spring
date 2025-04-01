package com.example.demo.dtos;

import java.time.Instant;

public record ErrorResponse(
    String message, 
    String errorType,
    int status, 
    Instant timestamp
) {
    public ErrorResponse(String message, String errorType, int status) {
        this(message, errorType,status, Instant.now());
    }
}
