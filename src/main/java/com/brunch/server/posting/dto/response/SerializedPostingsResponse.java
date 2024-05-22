package com.brunch.server.posting.dto.response;
import lombok.Builder;
import lombok.NonNull;

import java.util.List;

import static lombok.AccessLevel.PRIVATE;

@Builder(access = PRIVATE)
public record SerializedPostingsResponse(
        @NonNull List<SerializedPostingResponse> recentPostings,
        @NonNull List<SerializedPostingResponse> likePostings
) {

    public static SerializedPostingsResponse of(
            List<SerializedPostingResponse> recentPostings,
            List<SerializedPostingResponse> likePostings
    ) {
        return SerializedPostingsResponse.builder()
                .recentPostings(recentPostings)
                .likePostings(likePostings)
                .build();
    }
}
