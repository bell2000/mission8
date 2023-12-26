package com.example.study.domain;

import com.example.study.domain.common.BaseEntity;
import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Builder
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
public class Region extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @OneToMany(mappedBy = "region", cascade = CascadeType.ALL,fetch = FetchType.EAGER)
    private List<Store> storeList = new ArrayList<>();

    @Override
    public String toString() {
        StringBuilder result = new StringBuilder("Region{id=")
                .append(id)
                .append(", name='")
                .append(name)
                .append("', storeList=[");

        // storeList의 각 Store를 문자열로 추가
        for (Store store : storeList) {
            result.append("Store{id=")
                    .append(store.getId())
                    .append(", name='")
                    .append(store.getName())
                    .append("'}, ");
        }

        // 마지막 쉼표와 공백 제거
        if (!storeList.isEmpty()) {
            result.delete(result.length() - 2, result.length());
        }

        result.append("]}");

        return result.toString();
    }
}