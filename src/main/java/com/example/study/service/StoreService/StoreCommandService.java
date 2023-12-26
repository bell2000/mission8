package com.example.study.service.StoreService;

import com.example.study.domain.Store;
import com.example.study.web.dto.StoreRequestDTO;

public interface StoreCommandService {

    Store registStore(Long regionId, StoreRequestDTO.registerDTO request);
}
