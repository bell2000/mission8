package com.example.study.web.controller;

import com.example.study.apiPayload.ApiResponse;
import com.example.study.converter.StoreConverter;
import com.example.study.domain.Store;
import com.example.study.service.StoreService.StoreCommandService;
import com.example.study.web.dto.StoreRequestDTO;
import com.example.study.web.dto.StoreResponseDTO;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.aspectj.weaver.patterns.AndPointcut;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@Validated
@RequestMapping("/stores")
public class StoreRestController {

    private final StoreCommandService storeCommandService;
    @PostMapping("/regions/{regionId}")
    public ApiResponse<StoreResponseDTO.JoinResultDTO> addStoreToRegion(
            @PathVariable Long regionId,
            @RequestBody @Valid StoreRequestDTO.registerDTO request){
        Store store = storeCommandService.registStore(regionId, request);
        return ApiResponse.onSuccess(StoreConverter.toJoinResultDTO(store));
    }

}
