package com.brunch.server.book.controller;

import com.brunch.server.book.message.SuccessMessage;
import com.brunch.server.book.service.BookService;
import com.brunch.server.book.service.dto.BookOverviewResponse;
import com.brunch.server.book.service.dto.RecentLikedResponse;
import com.brunch.server.common.dto.SuccessResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("api/v1")
public class BookController {

    private final BookService bookService;

    // 최근 읽었던 책 목록 조회
    @GetMapping("/books")
    public SuccessResponse<RecentLikedResponse> getRecentAndLikedBooks(){
        RecentLikedResponse recentLikedResponse = bookService.getRecentAndLikedBooks();
        return SuccessResponse.success(SuccessMessage.SUCCESS_GET_VIEWED_BOOKS.getMessage(), recentLikedResponse);
    }

}
