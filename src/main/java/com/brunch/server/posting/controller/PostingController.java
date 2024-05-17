package com.brunch.server.posting.controller;

import com.brunch.server.common.dto.SuccessResponse;
import com.brunch.server.posting.dto.response.SerializedPostingsResponse;
import com.brunch.server.posting.dto.response.ViewedPostingResponse;
import com.brunch.server.posting.service.PostingService;
import lombok.RequiredArgsConstructor;
import lombok.val;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import static com.brunch.server.common.dto.SuccessResponse.*;
import static com.brunch.server.posting.message.SuccessMessage.SUCCESS_GET_SERIALIZED_POSTINGS;
import static com.brunch.server.posting.message.SuccessMessage.SUCCESS_GET_VIEWED_POSTINGS;

@RestController
@RequiredArgsConstructor
@RequestMapping("api/v1/postings")
public class PostingController {

    private final PostingService postingService;

    @GetMapping
    public ResponseEntity<SuccessResponse<ViewedPostingResponse>> getViewedPosting() {
        val response = postingService.getViewedPosting();
        return ResponseEntity.ok(success(SUCCESS_GET_VIEWED_POSTINGS.getMessage(), response));
    }

    @GetMapping("/serialized")
    public ResponseEntity<SuccessResponse<SerializedPostingsResponse>> getSerializedPosting(@RequestParam String day) {
        val response = postingService.getSerializedPosting(day);
        return ResponseEntity.ok(success(SUCCESS_GET_SERIALIZED_POSTINGS.getMessage(), response));
    }
}
