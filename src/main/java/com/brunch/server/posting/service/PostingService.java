package com.brunch.server.posting.service;

import com.brunch.server.author.entity.Author;
import com.brunch.server.author.repository.AuthorRepository;
import com.brunch.server.book.entity.Book;
import com.brunch.server.book.repository.BookRepository;
import com.brunch.server.posting.dto.response.PostingResponse;
import com.brunch.server.posting.dto.response.SerializedPostingResponse;
import com.brunch.server.posting.dto.response.SerializedPostingsResponse;
import com.brunch.server.posting.dto.response.ViewedPostingResponse;
import com.brunch.server.posting.entity.Posting;
import com.brunch.server.posting.repository.PostingRepository;
import lombok.RequiredArgsConstructor;
import lombok.val;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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
        val serializedPostings = getSerializedPostingResponse(day);
        return SerializedPostingsResponse.of(serializedPostings);
    }

    private List<PostingResponse> getLatestViewedPostingResponse() {
        val latestViewedPosting = postingRepository.findAllByIsViewed(1);
        return latestViewedPosting.stream()
                .map(this::getViewedPostingResponse)
                .toList();
    }

    private List<PostingResponse> getLikedPostingResponse() {
        val likedPosting = postingRepository.findAllByIsLiked(1);
        return likedPosting.stream()
                .map(this::getViewedPostingResponse)
                .toList();
    }

    private PostingResponse getViewedPostingResponse(Posting posting) {
        val author = findAuthor(posting.getAuthorId());
        return PostingResponse.of(posting, author);
    }

    private List<SerializedPostingResponse> getSerializedPostingResponse(String day) {
        val serializedPostings = postingRepository.findAllByDay(day);
        return serializedPostings.stream()
                .map(this::getSerializedPostingResponse)
                .toList();
    }

    private SerializedPostingResponse getSerializedPostingResponse(Posting posting) {
        val author = findAuthor(posting.getAuthorId());
        val book = findBook(posting.getBookId());
        return SerializedPostingResponse.of(posting, book, author);
    }

    private Author findAuthor(long id) {
        return authorRepository.findById(id).get();
    }

    private Book findBook(long id) {
        return bookRepository.findById(id).get();
    }
}
