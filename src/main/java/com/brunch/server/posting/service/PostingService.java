package com.brunch.server.posting.service;

import com.brunch.server.author.entity.Author;
import com.brunch.server.author.repository.AuthorRepository;
import com.brunch.server.book.entity.Book;
import com.brunch.server.book.repository.BookRepository;
import com.brunch.server.posting.dto.response.*;
import com.brunch.server.posting.entity.Posting;
import com.brunch.server.posting.repository.PostingRepository;
import lombok.RequiredArgsConstructor;
import lombok.val;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collections;
import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class PostingService {

    private final BookRepository bookRepository;
    private final AuthorRepository authorRepository;
    private final PostingRepository postingRepository;

    public ViewedPostingResponse getViewedPosting() {
        val latestViewedPostings = getLatestViewedPostingResponse();
        val likedPostings = getLikedPostingResponse();
        return ViewedPostingResponse.of(latestViewedPostings, likedPostings);
    }

    public SerializedPostingsResponse getSerializedPosting(String day) {
        val serializedRecentPostings = getSerializedRecentPostingResponse(day);
        val serializedLikePostings = getSerializedLikePostingResponse(day);
        return SerializedPostingsResponse.of(serializedRecentPostings, serializedLikePostings);
    }

    public RecommendedPostingResponse getRecommendedPosting() {
        val recommendPostings = getRecommendedPostingResponse();
        return RecommendedPostingResponse.of(recommendPostings);
    }

    private List<PostingResponse> getLatestViewedPostingResponse() {
        val latestViewedPosting = postingRepository.findAllByIsViewed(1);
        return latestViewedPosting.stream()
                .map(this::getPostingResponse)
                .toList();
    }

    private List<PostingResponse> getLikedPostingResponse() {
        val likedPosting = postingRepository.findAllByIsLiked(1);
        return likedPosting.stream()
                .map(this::getPostingResponse)
                .toList();
    }

    private List<SerializedPostingResponse> getSerializedRecentPostingResponse(String day) {
        val serializedPostings = postingRepository.findAllByDayOrderByRequiredTimeDesc(day);
        return serializedPostings.stream()
                .map(this::getSerializedPostingResponse)
                .toList();
    }

    private List<SerializedPostingResponse> getSerializedLikePostingResponse(String day) {
        val serializedPostings = postingRepository.findAllByDayOrderByLikeCountDesc(day);
        return serializedPostings.stream()
                .map(this::getSerializedPostingResponse)
                .toList();
    }

    private SerializedPostingResponse getSerializedPostingResponse(Posting posting) {
        val author = findAuthor(posting.getAuthorId());
        val book = findBook(posting.getBookId());
        return SerializedPostingResponse.of(posting, book, author);
    }

    private List<PostingResponse> getRecommendedPostingResponse() {
        val postings = postingRepository.findAll();
        Collections.shuffle(postings);
        return postings.stream()
                .map(this::getPostingResponse)
                .limit(20)
                .toList();
    }

    private PostingResponse getPostingResponse(Posting posting) {
        val author = findAuthor(posting.getAuthorId());
        return PostingResponse.of(posting, author);
    }

    private Author findAuthor(long id) {
        return authorRepository.findById(id).get();
    }

    private Book findBook(long id) {
        return bookRepository.findById(id).get();
    }
}
