package com.example.study.web.controller;

import com.example.study.apiPayload.ApiResponse;
import com.example.study.converter.ReviewConverter;
import com.example.study.domain.Review;
import com.example.study.service.ReviewService.ReviewCommandService;
import com.example.study.validation.annotation.ExistMember;
import com.example.study.web.dto.ReviewRequestDto;
import com.example.study.web.dto.ReviewResponseDto;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
@RequestMapping("/reviews")
public class ReviewRestController {
    private final ReviewCommandService reviewCommandService;

    //9.2 가게에 리뷰 추가하기
    @PostMapping("/stores/{storeId}")
    public ApiResponse<ReviewResponseDto.RegistResultDto> addReviewToStore(

            @ExistMember @RequestParam(name = "memberId") Long memberId,
            @PathVariable Long storeId,
            @RequestBody ReviewRequestDto.ReviewDTO request){
        Review review = reviewCommandService.registReview(memberId, storeId, request);
        return ApiResponse.onSuccess(ReviewConverter.toRegistResultDto(review));
    }

}
