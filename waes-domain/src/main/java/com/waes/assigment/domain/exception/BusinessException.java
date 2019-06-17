package com.waes.assigment.domain.exception;


import com.waes.assigment.domain.enums.MessageCodeEnum;

public class BusinessException extends RuntimeException {

    private MessageCodeEnum messageCodeEnum;
    private String[] parameters;

    public BusinessException(MessageCodeEnum messageCodeEnum, String... parameters) {
        this(null, messageCodeEnum, parameters);
    }

    public BusinessException(Throwable cause, MessageCodeEnum messageCodeEnum, String... parameters) {
        super(messageCodeEnum.name(), cause);
        this.messageCodeEnum = messageCodeEnum;
        this.parameters = parameters;
    }

}