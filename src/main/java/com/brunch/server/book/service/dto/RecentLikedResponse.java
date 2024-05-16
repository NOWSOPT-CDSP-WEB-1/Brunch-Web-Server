package com.brunch.server.book.service.dto;

import lombok.Builder;

import java.util.List;

@Builder
public record RecentLikedResponse (
        List<RecentBookResponse> recentBooks,
        List<LikedBookResponse> likedBooks
){
}