package com.example.study.service.StoreService;

import com.example.study.domain.Mission;
import com.example.study.domain.Review;
import com.example.study.domain.Store;
import org.springframework.data.domain.Page;

import java.util.Optional;

public interface StoreQueryService {
    Optional<Store> findStore(Long id);

    Page<Review> getReviewList(Long StoreId, Integer page);

    Page<Mission> getMissionList(Long missionId, Integer page);
}
