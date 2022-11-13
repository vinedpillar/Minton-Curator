package com.mintonware.mintoncurator.domain.member.repository;

import com.mintonware.mintoncurator.domain.member.entity.Member;
import org.springframework.data.repository.CrudRepository;

public interface MemberRepository extends CrudRepository<Member, Long> {
}
