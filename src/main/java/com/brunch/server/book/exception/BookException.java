package com.brunch.server.book.exception;

import com.brunch.server.book.message.ErrorMessage;
import lombok.Getter;

@Getter
public class BookException extends RuntimeException {

    private final ErrorMessage errorMessage;

    public BookException(ErrorMessage errorMessage) {
        super("[BookException] : " + errorMessage.getMessage());
        this.errorMessage = errorMessage;
    }
}
