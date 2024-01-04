package com.example.study.web.controller;

import com.example.study.apiPayload.ApiResponse;
import com.example.study.converter.MemberConverter;
import com.example.study.converter.StoreConverter;
import com.example.study.domain.Member;
import com.example.study.domain.Mission;
import com.example.study.domain.mapping.MemberMission;
import com.example.study.service.MemberService.MemberCommandService;
import com.example.study.service.MemberService.MemberQueryService;
import com.example.study.validation.annotation.ExistMember;
import com.example.study.validation.annotation.ExistStore;
import com.example.study.web.dto.MemberRequestDTO;
import com.example.study.web.dto.MemberResponseDTO;
import com.example.study.web.dto.StoreResponseDTO;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static com.example.study.apiPayload.ApiResponse.onSuccess;

@RestController
@RequiredArgsConstructor
@Validated
@RequestMapping("/members")
public class  MemberRestController {
    private final MemberCommandService memberCommandService;
    private final MemberQueryService memberQueryService;

    @PostMapping("/")
    public ApiResponse<MemberResponseDTO.JoinResultDTO> join(@RequestBody @Valid MemberRequestDTO.JoinDTO request){
        Member member = memberCommandService.joinMember(request);
        return ApiResponse.onSuccess(MemberConverter.toJoinResultDTO(member));
    }

    //10.3 내가 진행중인 미션 보기
    @GetMapping("/{memberId}/missions")
    public ApiResponse<StoreResponseDTO.MissionPreViewListDTO> getMissionList(@ExistMember @PathVariable Long memberId, @RequestParam(name = "page") Integer page){

        Page<Mission> missionList = memberQueryService.getMemberMissionList(memberId, page);
        return ApiResponse.onSuccess(StoreConverter.missionPreViewListDTO(missionList));
    }
}
