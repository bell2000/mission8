package com.example.study.converter;

import com.example.study.domain.Region;
import com.example.study.domain.Review;
import com.example.study.domain.Store;
import com.example.study.web.dto.ReviewRequestDto;
import com.example.study.web.dto.ReviewResponseDto;
import com.example.study.web.dto.StoreRequestDTO;

import java.time.LocalDateTime;

public class ReviewConverter {
    public static Review toReview(ReviewRequestDto.ReviewDTO request, Store store) {
        return Review.builder()
                .title(request.getTitle())
                .score(request.getScore())
                .body(request.getBody())
                .store(store)
                .build();
    }

    public static ReviewResponseDto.RegistResultDto toRegistResultDto(Review review){
        return ReviewResponseDto.RegistResultDto.builder()
                .reviewId(review.getId())
                .createdAt(LocalDateTime.now())
                .build();
    }

    ///////////////////////////////////////////////////////////////
    public static Review toReview(ReviewRequestDto.ReviewDTO request){
        return Review.builder()
                .title(request.getTitle())
                .score(request.getScore())
                .body(request.getBody())
                .build();
    }


}
