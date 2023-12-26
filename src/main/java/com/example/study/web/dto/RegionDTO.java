package com.example.study.web.dto;

import java.util.List;

public class RegionDTO {
    private Long id;
    private String name;
    private List<StoreDTO> storeList;

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public List<StoreDTO> getStoreList() {
        return storeList;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setStoreList(List<StoreDTO> storeDTOList) {
        this.storeList = storeDTOList;
    }
}
