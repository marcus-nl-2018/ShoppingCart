package com.shopping.exception;


public class DemandServiceException extends RuntimeException {

    public DemandServiceException(String message, Throwable cause) {
        super(message, cause);
    }

    public DemandServiceException(String message) {
        super(message);
    }
}