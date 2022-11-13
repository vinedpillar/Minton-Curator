package com.mintonware.mintoncurator.domain.member.service;

import com.mintonware.mintoncurator.domain.member.entity.Member;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

@Service
public class MemberServiceImpl implements MemberService {

    @Override
    public Member createMember(Member member) {
        return null;
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
        return null;
    }

    @Override
    public void verifyExistsNickname(String nickname) {

    }

    @Override
    public void verifyExistsEmail(String email) {

    }
}
