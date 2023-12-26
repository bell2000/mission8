package com.example.study.service.StoreService;

import com.example.study.apiPayload.code.status.ErrorStatus;
import com.example.study.apiPayload.exception.handler.FoodCategoryHandler;
import com.example.study.apiPayload.exception.handler.RegionHandler;
import com.example.study.converter.MemberConverter;
import com.example.study.converter.MemberPreferConverter;
import com.example.study.converter.StoreConverter;
import com.example.study.domain.FoodCategory;
import com.example.study.domain.Member;
import com.example.study.domain.Region;
import com.example.study.domain.Store;
import com.example.study.domain.mapping.MemberPrefer;
import com.example.study.repository.MemberRepository;
import com.example.study.repository.RegionRepository;
import com.example.study.repository.StoreRepository;
import com.example.study.web.dto.MemberRequestDTO;
import com.example.study.web.dto.StoreRequestDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class StoreCommandServiceImpl implements StoreCommandService{
    private final StoreRepository storeRepository;
    private final RegionRepository regionRepository;

    @Override
    @Transactional
    public Store registStore(Long regionId,StoreRequestDTO.registerDTO request){

        Region region = regionRepository.findById(regionId)
                .orElseThrow(() -> new RegionHandler(ErrorStatus.REGION_NOT_FOUND));

        Store store = StoreConverter.toStore(request, region);

        region.getStoreList().add(store);
        System.out.println(region);

        return storeRepository.save(store);

    }
}
