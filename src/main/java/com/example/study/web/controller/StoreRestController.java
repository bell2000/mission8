package com.example.study.web.controller;

import com.example.study.apiPayload.ApiResponse;
import com.example.study.converter.StoreConverter;
import com.example.study.domain.Mission;
import com.example.study.domain.Review;
import com.example.study.domain.Store;
import com.example.study.service.MemberService.MemberMissionService;
import com.example.study.service.MemberService.MemberQueryService;
import com.example.study.service.ReviewService.ReviewCommandService;
import com.example.study.service.StoreService.StoreCommandService;
import com.example.study.service.StoreService.StoreQueryService;
import com.example.study.service.StoreService.StoreQueryServiceImpl;
import com.example.study.validation.annotation.ExistMember;
import com.example.study.validation.annotation.ExistStore;
import com.example.study.web.dto.ReviewRequestDto;
import com.example.study.web.dto.ReviewResponseDto;
import com.example.study.web.dto.StoreRequestDTO;
import com.example.study.web.dto.StoreResponseDTO;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.Parameters;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.weaver.patterns.AndPointcut;
import org.slf4j.Logger;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@Validated
@RequestMapping("/stores")
@Slf4j
public class StoreRestController {

    private final StoreCommandService storeCommandService;
    private final ReviewCommandService reviewCommandService;
    private final MemberMissionService memberMissionService;
    private final StoreQueryService storeQueryService;
    private final MemberQueryService memberQueryService;

    //9.1 특정 지역에 가게 추가하기
    @PostMapping("/regions/{regionId}")
    public ApiResponse<StoreResponseDTO.JoinResultDTO> addStoreToRegion(
            @PathVariable Long regionId,
            @RequestBody @Valid StoreRequestDTO.registerDTO request) {
        Store store = storeCommandService.registStore(regionId, request);
        return ApiResponse.onSuccess(StoreConverter.toJoinResultDTO(store));
    }

    //9.4 가게의 미션을 도전 중인 미션에 추가하기
    @PostMapping("/startChallenge/{memberId}/{missionId}")
    public ResponseEntity<Void> challengeMission(@PathVariable Long memberId, @PathVariable Long missionId) {
        memberMissionService.challengeMission(memberId, missionId);
        return ResponseEntity.ok().build();
    }

    //10.0 특정 가게의 리뷰 목록
    @Operation(summary = "특정 가게의 리뷰 목록 조회 API", description = "특정 가게의 리뷰들의 목록을 조회하는 API이며, 페이징을 포함합니다. query String 으로 page 번호를 주세요")
    @GetMapping("/{storeId}/reviews")
    @ApiResponses({
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "COMMON200", description = "OK, 성공"),
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "AUTH003", description = "access 토큰을 주세요!", content = @Content(schema = @Schema(implementation = ApiResponse.class))),
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "AUTH004", description = "acess 토큰 만료", content = @Content(schema = @Schema(implementation = ApiResponse.class))),
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "AUTH006", description = "acess 토큰 모양이 이상함", content = @Content(schema = @Schema(implementation = ApiResponse.class))),
    })
    @Parameters({
            @Parameter(name = "storeId", description = "가게의 아이디, path variable 입니다!"),
            @Parameter(name = "page", description = "페이지 번호, 0번이 1 페이지 입니다.")
    })
    public ApiResponse<StoreResponseDTO.ReviewPreViewListDTO> getReviewList(@ExistStore @PathVariable(name = "storeId") Long storeId, @RequestParam(name = "page") Integer page) {
        Page<Review> reviewList = storeQueryService.getReviewList(storeId, page);
        log.info(reviewList.toString());
        return ApiResponse.onSuccess(StoreConverter.reviewPreViewListDTO(reviewList));

    }

    //10.1 내가 작성한 리뷰 목록
    @GetMapping("/{memberId}/user-reviews")
    public ApiResponse<StoreResponseDTO.ReviewPreViewListDTO> getUserReviewList(@ExistMember @PathVariable(name = "memberId") Long memberId, @RequestParam(name = "page") Integer page){
        Page<Review> userReviewList = memberQueryService.getUserReviewList(memberId, page);
        return ApiResponse.onSuccess(StoreConverter.reviewPreViewListDTO(userReviewList));
    }

    //10.2 특정 가게의 미션 목록
    @GetMapping("/{storeId}/missions")
    public ApiResponse<StoreResponseDTO.MissionPreViewListDTO> getMissionList(@ExistStore @PathVariable Long storeId, @RequestParam(name = "page") Integer page){
        Page<Mission> missionList = storeQueryService.getMissionList(storeId, page);
        return ApiResponse.onSuccess(StoreConverter.missionPreViewListDTO(missionList));
    }




}
