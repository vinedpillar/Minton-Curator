package com.mintonware.mintoncurator.domain.member.service;

import com.mintonware.mintoncurator.domain.member.entity.Member;
import com.mintonware.mintoncurator.domain.member.repository.MemberRepository;
import com.mintonware.mintoncurator.function.exception.BusinessLogicException;
import com.mintonware.mintoncurator.function.exception.ExceptionCode;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class MemberServiceImpl implements MemberService {

    private final MemberRepository memberRepository;

    public MemberServiceImpl(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }

    @Override
    public Member createMember(Member member) {
        verifyExistsNickname(member.getNickname());
        Member savedMember = memberRepository.save(member);

        return savedMember;
    }

    @Override
    public Member findMember(Long id) {
        return null;
    }

    @Override
    public Page<Member> findMembers(int page, int size) {
        return null;
    }

    @Override
    public Member updateMember(Member member) {
        return null;
    }

    @Override
    public void deleteMember(Long id) {

    }

    @Override
    public Member findVerifiedMember(Long id) {
        Optional<Member> optionalMember = memberRepository.findById(id);
        Member findMember = optionalMember
                .orElseThrow(() -> new BusinessLogicException(ExceptionCode.MEMBER_NOT_FOUND));

        return findMember;
    }

    @Override
    public void verifyExistsId(Long id) {
        Optional<Member> member = memberRepository.findById();
        if(member.isPresent()) {
            throw new BusinessLogicException(ExceptionCode.MEMBER_EXISTS);
        }
    }

    @Override
    public void verifyExistsNickname(String nickname) {
        Optional<Member> member = memberRepository.findByNickname(nickname);
        if(member.isPresent()) {
            throw new BusinessLogicException(ExceptionCode.MEMBER_EXISTS);
        }
    }

    @Override
    public void verifyExistsEmail(String email) {
        Optional<Member> member = memberRepository.findByEmail(email);
        if(member.isPresent()) {
            throw new BusinessLogicException(ExceptionCode.MEMBER_EXISTS);
        }
    }
}
