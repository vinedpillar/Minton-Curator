package com.mintonware.mintoncurator.domain.member.mapper;

import com.mintonware.mintoncurator.domain.member.dto.MemberDto;
import com.mintonware.mintoncurator.domain.member.entity.Member;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

import java.util.List;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface MemberMapper {
    Member memberPostToMember(MemberDto.Post requestBody);
    Member memberPatchToMember(MemberDto.Patch requestBody);
    MemberDto.Response memberToMemberResponse(Member member);
    List<MemberDto.Response> MembersToMemberResponse(List<Member> members);

}
