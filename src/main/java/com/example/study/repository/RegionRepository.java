package com.example.study.repository;

import com.example.study.domain.Region;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RegionRepository extends JpaRepository<Region, Long> {
    // 여기에 필요한 추가 메서드를 정의할 수 있습니다.
    Region findById(long id);
}

