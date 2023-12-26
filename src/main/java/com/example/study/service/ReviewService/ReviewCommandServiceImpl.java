package com.example.study.service.ReviewService;

import com.example.study.apiPayload.code.status.ErrorStatus;
import com.example.study.apiPayload.exception.handler.StoreHandler;
import com.example.study.converter.ReviewConverter;
import com.example.study.domain.Review;
import com.example.study.domain.Store;
import com.example.study.repository.ReviewRepository;
import com.example.study.repository.StoreRepository;
import com.example.study.web.dto.ReviewRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class ReviewCommandServiceImpl implements ReviewCommandService{

    private final ReviewRepository reviewRepository;
    private final StoreRepository storeRepository;

    @Override
    @Transactional
    public Review registReview(Long storeId, ReviewRequestDto.ReviewDTO request){

        Store store = storeRepository.findById(storeId)
                .orElseThrow(() -> new StoreHandler(ErrorStatus.STORE_NOT_FOUND));

        Review review = ReviewConverter.toReview(request, store);

        store.getReviewList().add(review);

        return reviewRepository.save(review);



    };

}
