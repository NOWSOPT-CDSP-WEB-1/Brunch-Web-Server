package com.brunch.server.posting.dto.response;
import lombok.Builder;
import lombok.NonNull;

import java.util.List;

import static lombok.AccessLevel.PRIVATE;

@Builder(access = PRIVATE)
public record SerializedPostingsResponse(
        @NonNull List<SerializedPostingResponse> serializedPostings
) {

    public static SerializedPostingsResponse of(List<SerializedPostingResponse> serializedPostings) {
        return SerializedPostingsResponse.builder()
                .serializedPostings(serializedPostings)
                .build();
    }
}
