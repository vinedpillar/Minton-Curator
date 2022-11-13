package com.mintonware.mintoncurator.domain.member.entity;


import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

@Table
public class Member {
    @Id
    private Long id;
    private String nickname;
    private String password;
    private String email;
    private Character grade;
}
