package com.example.study.service.MemberService;

import com.example.study.domain.Member;
import com.example.study.web.dto.MemberRequestDTO;

public interface MemberCommandService {
    Member joinMember(MemberRequestDTO.JoinDTO request);

}
