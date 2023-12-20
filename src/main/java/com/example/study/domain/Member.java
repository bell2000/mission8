package com.example.study.domain;

import com.example.study.domain.common.BaseEntity;
import com.example.study.domain.enums.Gender;
import com.example.study.domain.enums.MemberStatus;
import com.example.study.domain.enums.SocialType;
import com.example.study.domain.mapping.MemberAgree;
import com.example.study.domain.mapping.MemberMission;
import com.example.study.domain.mapping.MemberPrefer;
import com.fasterxml.jackson.databind.ser.Serializers;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Builder
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
public class Member extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 20)
    private String name;

    @Column(nullable = false, length = 40)
    private String address;

    @Column(nullable = false, length = 40)
    private String specAddress;

    @Column(nullable = false, length = 10)
    @Enumerated(EnumType.STRING)
    private Gender gender;

    @Column(nullable = false, length = 10)
    @Enumerated(EnumType.STRING)
    private SocialType socialType;

    @Column(nullable = false, length = 15)
    @Enumerated(EnumType.STRING)
    private MemberStatus memberStatus;

    @Column(nullable = false, length = 20)
    private LocalDate inactiveDate;

    @Column(nullable = false, length = 50)
    private String email;


    @Column(nullable = false, length = 20)
    private Integer point;

    @OneToMany(mappedBy = "member", cascade = CascadeType.ALL)
    private List<MemberAgree> memberAgreeList = new ArrayList<>();

    @OneToMany(mappedBy = "member", cascade = CascadeType.ALL)
    private List<MemberPrefer> memberPreferList = new ArrayList<>();

    @OneToMany(mappedBy = "member", cascade = CascadeType.ALL)
    private List<Review> reviewList = new ArrayList<>();

    @OneToMany(mappedBy = "member", cascade = CascadeType.ALL)
    private List<MemberMission> memberMissionList = new ArrayList<>();
}
