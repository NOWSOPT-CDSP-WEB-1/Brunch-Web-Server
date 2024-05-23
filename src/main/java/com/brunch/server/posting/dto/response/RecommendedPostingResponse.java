package com.brunch.server.posting.dto.response;
import lombok.Builder;
import lombok.NonNull;

import java.util.List;

import static lombok.AccessLevel.PRIVATE;

@Builder(access = PRIVATE)
public record RecommendedPostingResponse(
        @NonNull List<PostingResponse> recommendedPostings
) {

    public static RecommendedPostingResponse of(List<PostingResponse> recommendedPostings) {
        return RecommendedPostingResponse.builder()
                .recommendedPostings(recommendedPostings)
                .build();
    }
}
