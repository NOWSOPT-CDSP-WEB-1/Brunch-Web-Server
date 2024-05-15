package com.brunch.server.book.service.dto;

import java.util.List;

public record RecentLikedResponse (
        List<RecentBookResponse> recentBooks,
        List<LikedBookResponse> likeBooks
){
}
