package com.brunch.server.book.service;

import com.brunch.server.author.entity.Author;
import com.brunch.server.author.exeception.AuthorException;
import com.brunch.server.author.message.ErrorMessage;
import com.brunch.server.author.repository.AuthorRepository;
import com.brunch.server.book.entity.Book;
import com.brunch.server.book.exception.BookException;
import com.brunch.server.book.repository.BookRepository;
import com.brunch.server.book.service.dto.*;
import com.brunch.server.posting.entity.Posting;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class BookServiceImpl implements BookService {

    private final BookRepository bookRepository;
    private final AuthorRepository authorRepository;

    private Author getAuthorById(long authorId) {
        return authorRepository.findById(authorId)
                .orElseThrow(() -> new AuthorException(ErrorMessage.INVALID_AUTHOR_ID));
    }

    @Override
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

    @Override
    public BookDetailResponse getBookDetail(long bookId) {

        List<Book> bookOverview = bookRepository.findBookOverview(bookId);
        List<Posting> bookChapter = bookRepository.findBookChapter(bookId);

        List<BookOverviewResponse> bookOverviewResponses = bookOverview.stream()
                .map(book -> BookOverviewResponse.from(book, getAuthorById(book.getAuthorId())))
                .toList();

        List<BookChapterResponse> bookChapterResponses = bookChapter.stream()
                .map(posting -> BookChapterResponse.from(bookOverview.get(0), posting))
                .toList();

        return BookDetailResponse.builder()
                .bookOverview(bookOverviewResponses)
                .bookChapter(bookChapterResponses)
                .build();
    }

    @Override
    public List<BannerResponse> getBanner() {
        List<Book> bannerBooks = bookRepository.findBanner();

        return bannerBooks.stream()
                .map(book -> BannerResponse.from(book, getAuthorById(book.getAuthorId())))
                .toList();
    }

    @Transactional
    public BookLikeResponse likeBook(long bookId) {
        bookRepository.increaseLikeCount(bookId);
        Book book = bookRepository.findById(bookId)
                .orElseThrow(() -> new BookException(com.brunch.server.book.message.ErrorMessage.INVALID_BOOK));
        return BookLikeResponse.from(book);
    }
}
