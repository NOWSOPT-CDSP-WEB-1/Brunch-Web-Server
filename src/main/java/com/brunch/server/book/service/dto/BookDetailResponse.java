package com.brunch.server.book.service.dto;

import lombok.Builder;
import java.util.List;

@Builder
public record BookDetailResponse (
        List<BookOverviewResponse> bookOverview,
        List<BookChapterResponse> bookChapter
){
}
