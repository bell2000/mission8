package com.example.study.service.MemberService;

import com.example.study.domain.Member;
import com.example.study.domain.Mission;
import com.example.study.domain.Review;
import com.example.study.domain.Store;
import com.example.study.domain.mapping.MemberMission;
import com.example.study.repository.MemberMissionRepository;
import com.example.study.repository.MemberRepository;
import com.example.study.repository.MissionRepository;
import com.example.study.repository.ReviewRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class MemberQueryServiceImpl implements MemberQueryService{

    private final MemberRepository memberRepository;
    private final ReviewRepository reviewRepository;

    private final MemberMissionRepository  memberMissionRepository;
    private final MissionRepository missionRepository;
    @Override
    public Optional<Member> findMember(Long id){
        return memberRepository.findById(id);
    }

    @Override
    public Page<Review> getUserReviewList(Long userId, Integer page){
        Member member = memberRepository.findById(userId).get();
        Page<Review> userPage = reviewRepository.findAllByMember(member, PageRequest.of(page, 10));
        return userPage;
    }

    @Override
    public Page<Mission> getMemberMissionList(Long memberId, Integer page){
        Member member = memberRepository.findById(memberId).get();
        Page<Mission> missionPage = missionRepository.findAllByMember(memberId,PageRequest.of(page, 10));
        return missionPage;
    }
}
