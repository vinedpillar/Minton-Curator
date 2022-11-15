package com.mintonware.mintoncurator.domain.member.dto;

import com.mintonware.mintoncurator.domain.member.entity.MemberStatus;
import lombok.AllArgsConstructor;
import lombok.Getter;

public class MemberDto {
    @Getter
    @AllArgsConstructor
    public static class Post {
        private String nickname;
        private String password;
        private String email;
    }

    @Getter
    @AllArgsConstructor
    public static class Patch {
        private Long id;
        private String nickname;
        private String password;
        private String email;
        private Character grade;
    }

    @Getter
    @AllArgsConstructor
    public static class Response {
        private Long id;
        private String nickname;
        private String email;
        private Character grade;
        private MemberStatus memberStatus;
    }
}
