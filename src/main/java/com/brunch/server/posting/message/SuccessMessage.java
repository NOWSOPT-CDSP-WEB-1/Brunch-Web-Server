package com.brunch.server.posting.message;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum SuccessMessage {

    SUCCESS_GET_VIEWED_POSTINGS("최근 읽었던 글 조회 성공"),
    ;

    private final String message;
}
