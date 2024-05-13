package com.brunch.server.posting.controller;

import com.brunch.server.posting.service.PostingService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("api/v1/postings")
public class PostingController {

    private final PostingService postingService;
}
