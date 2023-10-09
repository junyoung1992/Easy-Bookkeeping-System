package com.example.easybookkeepingsystem.domain.member;

import com.example.easybookkeepingsystem.common.mapper.MemberMapper;
import com.example.easybookkeepingsystem.infrastructure.cache.member.MemberCacheRepository;
import com.example.easybookkeepingsystem.infrastructure.persistence.member.MemberEntity;
import com.example.easybookkeepingsystem.infrastructure.persistence.member.MemberJpaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
@RequiredArgsConstructor
public class MemberRepository {

    private final MemberJpaRepository memberJpaRepository;
    private final MemberCacheRepository memberCacheRepository;

    public Optional<Member> findOneByUserId(String userId) {
        return Optional.ofNullable(
                memberCacheRepository.findById(userId)
                        .map(MemberMapper.INSTANCE::fromMemberCache)
                        .orElseGet(() -> {
                            Optional<MemberEntity> found = memberJpaRepository.findOneByUserId(userId);
                            found.ifPresent(memberEntity -> memberCacheRepository.save(MemberMapper.INSTANCE.fromEntityToCache(memberEntity)));
                            return found.map(MemberMapper.INSTANCE::fromMemberEntity)
                                    .orElse(null);
                        })
        );
    }

}
