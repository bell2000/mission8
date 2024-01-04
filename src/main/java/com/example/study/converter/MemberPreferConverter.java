package com.example.study.converter;

import com.example.study.domain.FoodCategory;
import com.example.study.domain.mapping.MemberPrefer;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

public class MemberPreferConverter {

    public static List<MemberPrefer> toMemberPreferList(List<FoodCategory> foodCategoryList) {

        return foodCategoryList.stream()
                .map(foodCategory ->
                        MemberPrefer.builder()
                                .foodCategory(foodCategory)
                                .build()
                ).collect(Collectors.toList());
    }

}
