package com.brunch.server.book.controller;

import com.brunch.server.book.message.SuccessMessage;
import com.brunch.server.book.service.BookService;
import com.brunch.server.book.service.dto.*;
import com.brunch.server.common.dto.SuccessResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("api/v1")
public class BookController {

    private final BookService bookService;

    // 최근 읽었던 책 목록 조회
    @GetMapping("/books")
    public SuccessResponse<RecentLikedResponse> getRecentAndLikedBooks() {
        RecentLikedResponse recentLikedResponse = bookService.getRecentAndLikedBooks();
        return SuccessResponse.success(SuccessMessage.SUCCESS_GET_VIEWED_BOOKS.getMessage(), recentLikedResponse);
    }

    // 책 상세 조회
    @GetMapping("/books/{bookId}")
    public SuccessResponse<BookDetailResponse> getBookDetail(@PathVariable long bookId) {
        BookDetailResponse bookDetailResponse = bookService.getBookDetail(bookId);
        return SuccessResponse.success(SuccessMessage.SUCCESS_GET_DETAILED_BOOKS.getMessage(), bookDetailResponse);
    }

    // 배너 리스트 조회
    @GetMapping("/books/banner")
    public SuccessResponse<List<BannerResponse>> getBanner() {
        List<BannerResponse> bannerResponse = bookService.getBanner();
        return SuccessResponse.success(SuccessMessage.SUCCESS_GET_BANNER.getMessage(), bannerResponse);
    }

    // 좋아요
    @PostMapping("/books/{bookId}/likes")
    public SuccessResponse<BookLikeResponse> likedBook(@PathVariable long bookId) {
        BookLikeResponse bookLikeResponse = bookService.likeBook(bookId);
        return SuccessResponse.success(SuccessMessage.SUCCESS_POST_LIKE.getMessage(), bookLikeResponse);
    }

}
