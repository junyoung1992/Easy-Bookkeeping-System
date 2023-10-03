package com.example.easybookkeepingsystem.domain.member;

import com.example.easybookkeepingsystem.common.mapper.MemberMapper;
import com.example.easybookkeepingsystem.infrastructure.persistence.member.MemberJpaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
@RequiredArgsConstructor
public class MemberRepository {

    private final MemberJpaRepository memberJpaRepository;

    public Optional<Member> findOneByUserId(String userId) {
        return memberJpaRepository.findOneByUserId(userId)
                .map(MemberMapper.INSTANCE::fromMemberEntity);
    }

}
