package com.example.study.converter;

import com.example.study.domain.Member;
import com.example.study.domain.Region;
import com.example.study.domain.Store;
import com.example.study.domain.enums.Gender;
import com.example.study.web.dto.MemberRequestDTO;
import com.example.study.web.dto.MemberResponseDTO;
import com.example.study.web.dto.StoreRequestDTO;
import com.example.study.web.dto.StoreResponseDTO;

import java.time.LocalDateTime;
import java.util.ArrayList;

public class StoreConverter {

    public static StoreResponseDTO.JoinResultDTO toJoinResultDTO(Store store){
        return StoreResponseDTO.JoinResultDTO.builder()
                .storeId(store.getId())
                .createdAt(LocalDateTime.now())
                .build();
    }
    public static Store toStore(StoreRequestDTO.registerDTO request, Region region) {
        return Store.builder()
                .name(request.getName())
                .address(request.getAddress())
                .region(region)
                .build();
    }
}
