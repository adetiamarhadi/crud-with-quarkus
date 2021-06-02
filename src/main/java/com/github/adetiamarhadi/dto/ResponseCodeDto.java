package com.github.adetiamarhadi.dto;

public class ResponseCodeDto {

    private int status;
    private String message;

    public ResponseCodeDto(int status, String message) {
        this.status = status;
        this.message = message;
    }

    public int getStatus() {
        return status;
    }

    public String getMessage() {
        return message;
    }
}
