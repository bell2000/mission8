package com.example.study.converter;

import com.example.study.domain.*;
import com.example.study.domain.enums.Gender;
import com.example.study.domain.mapping.MemberMission;
import com.example.study.web.dto.*;
import org.slf4j.Logger;
import org.springframework.data.domain.Page;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

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
    public static StoreResponseDTO.ReviewPreViewDTO reviewPreViewDTO(Review review){
        return StoreResponseDTO.ReviewPreViewDTO.builder()
                .ownerNickname(review.getMember().getName())
                .score(review.getScore())
                .createdAt(review.getCreatedAt().toLocalDate())
                .body(review.getBody())
                .build();
    }
    public static StoreResponseDTO.ReviewPreViewListDTO reviewPreViewListDTO(Page<Review> reviewList){


        List<StoreResponseDTO.ReviewPreViewDTO> reviewPreViewDTOList = reviewList.stream()
                .map(StoreConverter::reviewPreViewDTO).collect(Collectors.toList());

        return StoreResponseDTO.ReviewPreViewListDTO.builder()
                .isLast(reviewList.isLast())
                .isFirst(reviewList.isFirst())
                .totalPage(reviewList.getTotalPages())
                .totalElements(reviewList.getTotalElements())
                .listSize(reviewPreViewDTOList.size())
                .reviewList(reviewPreViewDTOList)
                .build();
    }
    public static StoreResponseDTO.MissionPreViewListDTO missionPreViewListDTO(Page<Mission> missionList){
        List<StoreResponseDTO.MissionPreviewDto> missionPreviewDTOList = missionList.stream()
                .map(StoreConverter::missionPreviewDto).collect(Collectors.toList());

        return StoreResponseDTO.MissionPreViewListDTO.builder()
                .isLast(missionList.isLast())
                .isFirst(missionList.isFirst())
                .totalPage(missionList.getTotalPages())
                .totalElements(missionList.getTotalElements())
                .listSize(missionPreviewDTOList.size())
                .reviewList(missionPreviewDTOList)
                .build();

    }

    public static StoreResponseDTO.MissionPreviewDto missionPreviewDto(Mission mission){
        return StoreResponseDTO.MissionPreviewDto.builder()
                .ownStoreName(mission.getStore().getName())
                .missionSpec(mission.getMissionSpec())
                .missionStatus(mission.getStatus())
                .build();
    }

    //////////////////////////////////////////////////////////////////



    public static ReviewResponseDto.RegistResultDto toCreateReviewResultDTO(Review review){
        return ReviewResponseDto.RegistResultDto.builder()
                .reviewId(review.getId())
                .createdAt(LocalDateTime.now())
                .build();
    }

}
