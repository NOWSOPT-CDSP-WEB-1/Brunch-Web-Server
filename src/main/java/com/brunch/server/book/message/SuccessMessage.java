package com.brunch.server.book.message;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum SuccessMessage {

    SUCCESS_GET_VIEWED_BOOKS("최근 읽었던 책 목록 조회 성공"),
    SUCCESS_GET_DETAILED_BOOKS("책 상세 조회 성공"),
    SUCCESS_GET_BANNER("배너 리스트 조회 성공"),
    SUCCESS_POST_LIKE("좋아요 반영 성공"),
    ;

    private final String message;
}
