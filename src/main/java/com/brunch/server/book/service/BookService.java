package com.brunch.server.book.service;

import com.brunch.server.author.entity.Author;
import com.brunch.server.author.exeception.AuthorException;
import com.brunch.server.author.message.ErrorMessage;
import com.brunch.server.author.repository.AuthorRepository;
import com.brunch.server.book.entity.Book;
import com.brunch.server.book.repository.BookRepository;
import com.brunch.server.book.service.dto.LikedBookResponse;
import com.brunch.server.book.service.dto.RecentBookResponse;
import com.brunch.server.book.service.dto.RecentLikedResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class BookService {

    private final BookRepository bookRepository;
    private final AuthorRepository authorRepository;

    private Author getAuthorById(Long authorId) {
        return authorRepository.findById(authorId)
                .orElseThrow(() -> new AuthorException(ErrorMessage.INVALID_AUTHOR_ID));
    }

    public RecentLikedResponse getRecentAndLikedBooks() {

        List<Book> recentBooks = bookRepository.findRecentBooks();
        List<Book> likedBooks = bookRepository.findLikedBooks();

        List<RecentBookResponse> recentBookResponses = recentBooks.stream()
                .map(book -> RecentBookResponse.from(book, getAuthorById(book.getAuthorId())))
                .toList();

        List<LikedBookResponse> likedBookResponses = likedBooks.stream()
                .map(book -> LikedBookResponse.from(book, getAuthorById(book.getAuthorId())))
                .toList();

        return RecentLikedResponse.builder()
                .recentBooks(recentBookResponses)
                .likedBooks(likedBookResponses)
                .build();
    }

}
