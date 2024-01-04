package com.example.study.repository;

import com.example.study.domain.Member;
import com.example.study.domain.Mission;
import com.example.study.domain.Store;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface MissionRepository extends JpaRepository<Mission, Long> {
    Page<Mission> findAllByStore(Store store, PageRequest pageRequest);


    @Query("SELECT ms FROM MemberMission mm join mm.mission ms where mm.member.id = :memberId AND mm.status = 'CHALLENGING'")
    Page<Mission> findAllByMember(@Param("memberId") Long memberId, PageRequest pageRequest);
}