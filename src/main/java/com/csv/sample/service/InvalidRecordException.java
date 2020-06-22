package com.csv.sample.service;

public class InvalidRecordException extends RuntimeException {

    private final String message;

    public InvalidRecordException(String message) {
        this.message = message;
    }

    @Override
    public String getMessage() {
        return message;
    }

}