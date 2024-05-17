package com.brunch.server.author.exeception;

import com.brunch.server.author.message.ErrorMessage;
import lombok.Getter;

@Getter
public class AuthorException extends RuntimeException {

    private final ErrorMessage errorMessage;

    public AuthorException(ErrorMessage errorMessage) {
        super("[AuthorException] : " + errorMessage.getMessage());
        this.errorMessage = errorMessage;
    }
}
