package com.brunch.server.book.service;

import com.brunch.server.book.service.dto.BannerResponse;
import com.brunch.server.book.service.dto.BookDetailResponse;
import com.brunch.server.book.service.dto.RecentLikedResponse;

import java.util.List;

public interface BookService {
    RecentLikedResponse getRecentAndLikedBooks();
    BookDetailResponse getBookDetail(long bookId);
    List<BannerResponse> getBanner();
}
