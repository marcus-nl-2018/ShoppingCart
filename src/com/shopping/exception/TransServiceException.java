package com.shopping.exception;


public class TransServiceException extends RuntimeException {

    public TransServiceException(String message, Throwable cause) {
        super(message, cause);
    }

    public TransServiceException(String message) {
        super(message);
    }
}