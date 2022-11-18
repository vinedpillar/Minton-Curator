package com.mintonware.mintoncurator.domain.member.dto;

import com.mintonware.mintoncurator.domain.member.entity.MemberStatus;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

public class MemberDto {
    @Getter
    @AllArgsConstructor
    public static class Post {
        @NotBlank
        private String nickname;
        @NotBlank
        private String password;
        @Email
        @NotBlank
        private String email;
    }

    @Getter
    @AllArgsConstructor
    public static class Patch {
        private Long memberId;
        private String nickname;
        private String password;
        private String email;
        private Character grade;

        public void setMemberId(Long memberId) {
            this.memberId = memberId;
        }
    }

    @Getter
    @AllArgsConstructor
    public static class Response {
        private Long memberId;
        private String nickname;
        private String email;
        private Character grade;
        private MemberStatus memberStatus;

        public String getMemberStatus() {
            return memberStatus.getStatus();
        }
    }
}
