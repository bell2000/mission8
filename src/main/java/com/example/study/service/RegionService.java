package com.example.study.service;

import com.example.study.apiPayload.code.status.ErrorStatus;
import com.example.study.apiPayload.exception.handler.RegionHandler;
import com.example.study.domain.Region;
import com.example.study.repository.FoodCategoryRepository;
import com.example.study.repository.RegionRepository;
import com.example.study.web.dto.RegionDTO;
import com.example.study.web.dto.StoreDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class RegionService {

    private final RegionRepository regionRepository;

    public boolean existsById(Long regionId) {
        return regionRepository.existsById(regionId);
    }


    public RegionDTO getRegionWithStoreList(Long regionId) {
        Region region = regionRepository.findById(regionId)
                .orElseThrow(() -> new RegionHandler(ErrorStatus.REGION_NOT_FOUND));

        // 간단한 매핑 예제
        RegionDTO regionDTO = new RegionDTO();
        regionDTO.setId(region.getId());
        regionDTO.setName(region.getName());

        // StoreDTO 리스트를 생성하고 매핑
        List<StoreDTO> storeDTOList = region.getStoreList().stream()
                .map(store -> {
                    StoreDTO storeDTO = new StoreDTO();
                    storeDTO.setId(store.getId());
                    storeDTO.setName(store.getName());
                    return storeDTO;
                })
                .collect(Collectors.toList());

        regionDTO.setStoreList(storeDTOList);

        return regionDTO;
    }
}