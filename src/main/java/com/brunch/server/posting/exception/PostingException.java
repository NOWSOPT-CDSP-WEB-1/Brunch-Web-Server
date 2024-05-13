package com.brunch.server.posting.exception;

import com.brunch.server.posting.message.ErrorMessage;
import lombok.Getter;

@Getter
public class PostingException extends RuntimeException {

    private final ErrorMessage errorMessage;

    public PostingException(ErrorMessage errorMessage) {
        super("[PostingException] : " + errorMessage.getMessage());
        this.errorMessage = errorMessage;
    }
}
