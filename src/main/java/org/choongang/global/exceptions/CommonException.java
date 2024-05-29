package org.choongang.global.exceptions;

import lombok.Getter;

@Getter
public class CommonException extends RuntimeException {
    private int code; // 에러 코드

    public CommonException(String message, int code) {
        super(message);
        this.code = code;
    }
}