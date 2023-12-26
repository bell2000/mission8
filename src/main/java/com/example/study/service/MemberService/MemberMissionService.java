package com.example.study.service.MemberService;

import com.example.study.domain.enums.MissionStatus;
import com.example.study.domain.mapping.MemberMission;
import com.example.study.repository.MemberMissionRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class MemberMissionService {

    private final MemberMissionRepository memberMissionRepository;

    @Transactional
    public void challengeMission(Long memberId, Long missionId) {
        MemberMission memberMission = memberMissionRepository.findByMemberIdAndMissionId(memberId, missionId)
                .orElseThrow(() -> new RuntimeException("MemberMission not found"));

        if (memberMission.getStatus() == null) {
            memberMission.setStatus(MissionStatus.CHALLENGING);
            // 여기서 다른 처리도 추가할 수 있습니다.
        } else {
            throw new RuntimeException("MemberMission is already in a state other than null");
        }
    }
}
