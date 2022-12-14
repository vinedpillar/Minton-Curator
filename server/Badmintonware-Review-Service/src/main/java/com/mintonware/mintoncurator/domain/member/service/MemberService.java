package com.mintonware.mintoncurator.domain.member.service;

import com.mintonware.mintoncurator.domain.member.entity.Member;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

@Service
public interface MemberService {
    // 회원 생성
    Member createMember(Member member);

    // 회원 정보 확인
    Member findMember(Long memberId);

    // 모든 회원 정보 확인
    Page<Member> findMembers(int page, int size);

    // 회원 정보 수정
    Member updateMember(Member member);

    // 회원 정보 삭제
    void deleteMember(Long memberId);

    // 회원 정보가 있는지 확인
    Member findVerifiedMember(Long memberId);

    // 회원 아이디 검증
    void verifyExistsMemberId(Long memberId);

    // 회원 닉네임 검증
    void verifyExistsNickname(String nickname);

    // 회원 메일 검증
    void verifyExistsEmail(String email);
}
