package com.mintonware.mintoncurator.domain.member.entity;

import lombok.Getter;

public enum MemberStatus {
    MEMBER_ACTIVE("활동"),
    MEMBER_SLEEP("휴면"),
    MEMBER_QUIT("탈퇴");

    @Getter
    private String status;

    MemberStatus(String status) {
        this.status = status;
    }
}
