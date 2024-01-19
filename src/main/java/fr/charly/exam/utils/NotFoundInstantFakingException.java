package fr.charly.exam.utils;

import lombok.Getter;

@Getter
public class NotFoundInstantFakingException extends RuntimeException{

    private final String type;

    private final String field;

    private final Object value;

    public NotFoundInstantFakingException(String type, String field, Object value) {
        super();
        this.type = type;
        this.field = field;
        this.value = value;
    }

}
