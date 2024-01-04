package com.example.study.service.StoreService;

import com.example.study.domain.Mission;
import com.example.study.domain.Review;
import com.example.study.domain.Store;
import com.example.study.repository.MemberRepository;
import com.example.study.repository.MissionRepository;
import com.example.study.repository.ReviewRepository;
import com.example.study.repository.StoreRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class StoreQueryServiceImpl implements StoreQueryService{

    private final StoreRepository storeRepository;
    private final ReviewRepository reviewRepository;
    private final MissionRepository missionRepository;


    @Override
    public Optional<Store> findStore(Long id) {
        return storeRepository.findById(id);
    }

    @Override
    public Page<Review> getReviewList(Long storeId, Integer page){
        Store store = storeRepository.findById(storeId).get();
        Page<Review> StorePage = reviewRepository.findAllByStore(store, PageRequest.of(page, 10));
        return StorePage;

    }

    @Override
    public Page<Mission> getMissionList(Long missionId, Integer page){
        Store store = storeRepository.findById(missionId).get();
        Page<Mission> missionPage = missionRepository.findAllByStore(store,PageRequest.of(page, 10));
        return missionPage;
    }



}
