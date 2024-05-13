package com.brunch.server.common.handler;

import com.brunch.server.book.exception.BookException;
import com.brunch.server.common.dto.BaseResponse;
import com.brunch.server.posting.exception.PostingException;
import lombok.extern.slf4j.Slf4j;
import lombok.val;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import static com.brunch.server.common.dto.ErrorResponse.of;

@Slf4j
@RestControllerAdvice
public class ErrorHandler {

    @ExceptionHandler(PostingException.class)
    public ResponseEntity<BaseResponse> postingException(PostingException exception) {
        log.error(exception.getMessage());
        val errorMessage = exception.getErrorMessage();
        return ResponseEntity.status(errorMessage.getHttpStatus()).body(of(errorMessage.getMessage()));
    }

    @ExceptionHandler(BookException.class)
    public ResponseEntity<BaseResponse> bookException(BookException exception) {
        log.error(exception.getMessage());
        val errorMessage = exception.getErrorMessage();
        return ResponseEntity.status(errorMessage.getHttpStatus()).body(of(errorMessage.getMessage()));
    }
}
