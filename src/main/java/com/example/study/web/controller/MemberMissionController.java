package com.example.study.web.controller;

import com.example.study.service.MemberService.MemberMissionService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
@RequestMapping("")
public class MemberMissionController {
    private final MemberMissionService memberMissionService;

    @PostMapping("/startChallenge/{memberId}/{missionId}")
    public ResponseEntity<Void> challengeMission(@PathVariable Long memberId, @PathVariable Long missionId) {
        memberMissionService.challengeMission(memberId, missionId);
        return ResponseEntity.ok().build();
    }
}
