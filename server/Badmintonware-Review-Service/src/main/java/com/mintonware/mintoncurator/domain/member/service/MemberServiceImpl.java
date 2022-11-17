package com.mintonware.mintoncurator.domain.member.service;

import com.mintonware.mintoncurator.domain.member.entity.Member;
import com.mintonware.mintoncurator.domain.member.repository.MemberRepository;
import com.mintonware.mintoncurator.function.exception.BusinessLogicException;
import com.mintonware.mintoncurator.function.exception.ExceptionCode;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class MemberServiceImpl implements MemberService {

    private final MemberRepository memberRepository;

    @Override
    public Member createMember(Member member) {
        verifyExistsNickname(member.getNickname());
        Member savedMember = memberRepository.save(member);

        return savedMember;
    }

    @Override
    public Member findMember(Long memberId) {

        return findVerifiedMember(memberId);
    }

    @Override
    public Page<Member> findMembers(int page, int size) {

        return memberRepository.findAll(PageRequest.of(
                page, size, Sort.by("memberId").descending()));
    }

    @Override
    public Member updateMember(Member member) {
        Member findMember = findVerifiedMember(member.getMemberId());

        Optional.ofNullable(member.getNickname())
                .ifPresent(findMember::setNickname);
        // 패스워드는 암호화해서 저장해야할 듯
        // 패스워드 암호화 메서드 필요
        Optional.ofNullable(member.getEmail())
                .ifPresent(findMember::setEmail);
        Optional.ofNullable(member.getGrade())
                .ifPresent(findMember::setGrade);

        return memberRepository.save(findMember);
    }

    @Override
    public void deleteMember(Long memberId) {
        Member findMember = findVerifiedMember(memberId);
        memberRepository.delete(findMember);
    }

    // 등록된 회원 검색
    @Override
    public Member findVerifiedMember(Long memberId) {
        Optional<Member> optionalMember = memberRepository.findById(memberId);
        Member findMember = optionalMember.orElseThrow(
                () -> new BusinessLogicException(ExceptionCode.MEMBER_NOT_FOUND));

        return findMember;
    }

    // 등록된 회원인지 확인
    @Override
    public void verifyExistsMemberId(Long memberId) {
        Optional<Member> member = memberRepository.findById(memberId);
        if(member.isPresent()) {
            throw new BusinessLogicException(ExceptionCode.MEMBER_EXISTS);
        }
    }

    // 등록된 닉네임인지 확인
    @Override
    public void verifyExistsNickname(String nickname) {
        Optional<Member> member = memberRepository.findByNickname(nickname);
        if(member.isPresent()) {
            throw new BusinessLogicException(ExceptionCode.MEMBER_EXISTS);
        }
    }

    // 등록된 이메일인지 확인
    @Override
    public void verifyExistsEmail(String email) {
        Optional<Member> member = memberRepository.findByEmail(email);
        if(member.isPresent()) {
            throw new BusinessLogicException(ExceptionCode.MEMBER_EXISTS);
        }
    }
}
