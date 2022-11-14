package com.mintonware.mintoncurator.domain.member.entity;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

@Table
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Member {
    @Id
    private Long id;
    private String nickname;
    private String password;
    private String email;
    private Character grade;
    private MemberStatus memberStatus = MemberStatus.MEMBER_ACTIVE;
}
