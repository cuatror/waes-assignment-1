package com.waes.assigment.domain.enums;

/**
 * Created by mateus on 15/06/19.
 */
public enum DiffResultEnum {
    EQUALS("Left and Right are equals"),
    NOT_EQUALS("Left and Right are differents"),

    DIFFERENT_LENGTH("Values are of different length"),
    SAME_LENGTH("Left and Right have the same size"),

    INVALID_DATA("Invalid data");


    private final String message;

    DiffResultEnum(final String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
