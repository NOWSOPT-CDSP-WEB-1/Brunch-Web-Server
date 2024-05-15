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
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class BookService {

    @Autowired
    private BookRepository bookRepository;

    @Autowired
    private AuthorRepository authorRepository;

    public RecentLikedResponse getRecentAndLikedBooks() {

        List<Book> recentBooks = bookRepository.findRecentBooks();
        List<Book> likedBooks = bookRepository.findLikedBooks();

        List<RecentBookResponse> recentBookResponses = recentBooks.stream().map(book -> {

            // Author Entity 조회
            Author author = authorRepository.findById(book.getAuthorId())
                    .orElseThrow(() -> new AuthorException(ErrorMessage.INVALID_AUTHOR_ID));

            return new RecentBookResponse(
                    book.getId(),
                    book.getTitle(),
                    author.getName(),
                    book.getBookImage(),
                    book.getDescription(),
                    book.getEpisode(),
                    book.getRequiredTime(),
                    book.getProgress()

            );
        }).collect(Collectors.toList());

        List<LikedBookResponse> likedBookResponses = likedBooks.stream().map(book -> {

            // Author Entity 조회
            Author author = authorRepository.findById(book.getAuthorId())
                    .orElseThrow(() -> new AuthorException(ErrorMessage.INVALID_AUTHOR_ID));

            return new LikedBookResponse(
                    book.getId(),
                    book.getTitle(),
                    author.getName(),
                    book.getBookImage()
            );
        }).collect(Collectors.toList());

        return new RecentLikedResponse(recentBookResponses, likedBookResponses);
    }

}
