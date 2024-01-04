package com.example.study.service.MemberService;

import com.example.study.domain.Member;
import com.example.study.domain.Mission;
import com.example.study.domain.Review;
import com.example.study.domain.mapping.MemberMission;
import org.springframework.data.domain.Page;

import java.util.Optional;

public interface MemberQueryService {
    Optional<Member> findMember(Long id);

    Page<Review> getUserReviewList(Long MemberId, Integer page);
    Page<Mission> getMemberMissionList(Long MemberId, Integer page);
}
