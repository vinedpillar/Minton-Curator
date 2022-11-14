package com.mintonware.mintoncurator.domain.member.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

public class MemberDto {
    @Getter
    @AllArgsConstructor
    static class Post {
        private String nickname;
        private String password;
        private String email;
    }

    @Getter
    @AllArgsConstructor
    static class Patch {
        private Long id;
        private String nickname;
        private String password;
        private String email;
        private Character grade;
    }

    static class Response {
        private Long id;
        private String nickname;
        private String email;
        private Character grade;

    }
}
