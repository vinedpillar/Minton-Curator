package com.mintonware.mintoncurator.domain.member.controller;

import com.mintonware.mintoncurator.domain.member.dto.MemberDto;
import com.mintonware.mintoncurator.domain.member.entity.Member;
import com.mintonware.mintoncurator.domain.member.mapper.MemberMapper;
import com.mintonware.mintoncurator.domain.member.service.MemberService;
import com.mintonware.mintoncurator.function.response.MultiResponse;
import com.mintonware.mintoncurator.function.response.SingleResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.Positive;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/v1/members")
@Validated
@Slf4j
public class MemberController {
    private final MemberService memberService;
    private final MemberMapper memberMapper;

    // 회원 생성 요청
    @PostMapping
    public ResponseEntity postMember(@RequestBody @Valid MemberDto.Post requestBody) {
        Member member = memberMapper.memberPostToMember(requestBody);
        Member createdMember = memberService.createMember(member);
        MemberDto.Response response = memberMapper.memberToMemberResponse(createdMember);

        return new ResponseEntity<>(
                new SingleResponse<>(response), HttpStatus.CREATED);
    }

    // 회원 조회 요청
    @GetMapping("/{member-id}")
    public ResponseEntity getMember(@PathVariable("member-id") @Positive Long memberId) {
        Member foundMember = memberService.findMember(memberId);
        MemberDto.Response response = memberMapper.memberToMemberResponse(foundMember);

        return new ResponseEntity<>(
                new SingleResponse<>(response), HttpStatus.OK);
    }

    @GetMapping
    // 모든 회원 조회 요청
    public ResponseEntity getMembers(@RequestParam @Positive int page,
                                     @RequestParam @Positive int size) {
        Page<Member> pageMembers = memberService.findMembers(page - 1, size);
        List<Member> members = pageMembers.getContent();
        List<MemberDto.Response> responses = memberMapper.MembersToMemberResponses(members);

        return new ResponseEntity<>(
                new MultiResponse<>(responses, pageMembers), HttpStatus.OK);
    }

    /** 회원 생성 및 수정
     * 나중에 필요 시에 사용
     * @Param -
     * @return ResponseEntity
     * @throws -
    public ResponseEntity putMember() {

        return new ResponseEntity<>();
    }
    */

    // 회원 정보 수정 요청
    @PatchMapping("/{member-id}")
    public ResponseEntity patchMember(@PathVariable("member-id") @Positive Long memberId,
                                      @RequestBody @Valid MemberDto.Patch requestBody) {
        requestBody.setMemberId(memberId);
        Member member = memberMapper.memberPatchToMember(requestBody);
        Member patchedMember = memberService.updateMember(member);
        MemberDto.Response response = memberMapper.memberToMemberResponse(patchedMember);

        return new ResponseEntity<>(
                new SingleResponse<>(response), HttpStatus.OK);
    }

    // 회원 삭제 요청
    @DeleteMapping("/{member-id}")
    private ResponseEntity deleteMember(@PathVariable("member-id") @Positive Long memberId) {
        memberService.deleteMember(memberId);

        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

}
