package com.example.study.domain.mapping;

import com.example.study.domain.Member;
import com.example.study.domain.Terms;
import com.example.study.domain.common.BaseEntity;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.Fetch;

@Entity
@Getter
@Builder
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
public class MemberAgree extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;



    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "member_id")
//    @Column(columnDefinition = "bigint")
    private Member member;


    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "terms_id")
//    @Column(columnDefinition = "bigint")
    private Terms terms;
}
