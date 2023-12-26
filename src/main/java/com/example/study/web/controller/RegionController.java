package com.example.study.web.controller;

import com.example.study.service.RegionService;
import com.example.study.web.dto.RegionDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/regions")
public class RegionController {
    private final RegionService regionService;

    @GetMapping(value = "/{regionId}",produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_JSON_UTF8_VALUE})
    public ResponseEntity<RegionDTO> getRegion(@PathVariable Long regionId) {
        RegionDTO regionDTO = regionService.getRegionWithStoreList(regionId);
        return new ResponseEntity<>(regionDTO, HttpStatus.OK);
    }
}
