package com.example.study.service.ReviewService;

import com.example.study.domain.Review;
import com.example.study.web.dto.ReviewRequestDto;

public interface ReviewCommandService {

    Review registReview(Long memberId, Long storeId, ReviewRequestDto.ReviewDTO request);

}
