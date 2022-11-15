package com.mintonware.mintoncurator.domain.member.controller;

import com.mintonware.mintoncurator.domain.member.dto.MemberDto;
import com.mintonware.mintoncurator.domain.member.entity.Member;
import com.mintonware.mintoncurator.domain.member.mapper.MemberMapper;
import com.mintonware.mintoncurator.domain.member.service.MemberService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/v1/members")
@Slf4j
public class MemberController {
    private final MemberService memberService;
    private final MemberMapper memberMapper;

    // 회원 생성 요청
    @PostMapping
    public ResponseEntity postMember(@RequestBody MemberDto.Post requestBody) {
        Member member = memberMapper.memberPostToMember(requestBody);
        Member createdMember = memberService.createMember(member);
        MemberDto.Response response = memberMapper.memberToMemberResponse(createdMember);

        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }

    // 회원 조회 요청
    public ResponseEntity getMember() {

        return new ResponseEntity<>();
    }

    // 모든 회원 조회 요청

    public ResponseEntity getMembers() {

        return new ResponseEntity<>();
    }

    // 회원 생성 및 수정
    public ResponseEntity putMember() {

        return new ResponseEntity<>();
    }

    // 회원 정보 수정 요청
    public ResponseEntity patchMember() {

        return new ResponseEntity<>();
    }

    // 회원 삭제 요청
    private ResponseEntity deleteMember() {

        return new ResponseEntity<>();
    }

}
