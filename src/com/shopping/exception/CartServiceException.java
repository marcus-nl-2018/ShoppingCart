package com.shopping.exception;


public class CartServiceException extends RuntimeException {

    public CartServiceException(String message, Throwable cause) {
        super(message, cause);
    }

    public CartServiceException(String message) {
        super(message);
    }
}