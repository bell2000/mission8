package com.example.study.web.dto;

public class StoreDTO {
    private Long id;

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    private String name;

    public void setId(Long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }
}
