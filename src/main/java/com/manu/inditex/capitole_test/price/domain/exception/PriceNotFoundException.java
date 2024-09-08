package com.manu.inditex.capitole_test.price.domain.exception;

public class PriceNotFoundException extends RuntimeException {
    public PriceNotFoundException(String msg){
        super(msg);
    }
}
