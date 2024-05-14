package com.brunch.server.posting.service;

import com.brunch.server.posting.dto.response.ViewedPostingResponse;
import com.brunch.server.posting.repository.PostingRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class PostingService {

    private final PostingRepository postingRepository;

    public ViewedPostingResponse getViewedPosting() {
        return null;
    }
}
