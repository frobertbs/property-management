package com.frobertbs.propertymanagement.exception;

import java.util.List;

public class BusinessException extends Exception{
    private List<ErrorModel> errors;

    public BusinessException(List<ErrorModel> errors) {
        this.errors = errors;
    }
}
