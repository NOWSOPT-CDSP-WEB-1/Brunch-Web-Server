package com.brunch.server.posting.message;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.http.HttpStatus;

import static org.springframework.http.HttpStatus.*;

@Getter
@AllArgsConstructor
public enum ErrorMessage {

    /* 404 NOT_FOUND : 자원을 찾을 수 없음 */
    INVALID_POSTING(NOT_FOUND, "유효하지 않은 게시글입니다."),
    ;

    private final HttpStatus httpStatus;
    private final String message;
}
