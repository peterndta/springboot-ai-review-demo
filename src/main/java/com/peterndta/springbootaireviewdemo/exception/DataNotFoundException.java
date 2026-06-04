package com.peterndta.springbootaireviewdemo.exception;

public class DataNotFoundException  extends RuntimeException {
    public DataNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }


}
