package com.example.study.web.dto;

import com.example.study.domain.Mission;
import com.example.study.domain.Region;
import com.example.study.domain.Review;
import com.example.study.validation.annotation.ExistCategories;
import com.example.study.validation.annotation.ExistRegion;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class StoreRequestDTO {

    @Getter
    public static class registerDTO {

        String name;
        String address;

    }


}
