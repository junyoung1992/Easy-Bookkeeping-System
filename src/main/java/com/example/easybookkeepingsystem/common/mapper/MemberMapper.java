package com.example.easybookkeepingsystem.common.mapper;

import com.example.easybookkeepingsystem.domain.member.Member;
import com.example.easybookkeepingsystem.infrastructure.cache.member.MemberCache;
import com.example.easybookkeepingsystem.infrastructure.persistence.member.MemberEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public interface MemberMapper {
    MemberMapper INSTANCE = Mappers.getMapper(MemberMapper.class);

    @Mapping(target = "memberId", source = "id")
    @Mapping(target = "memberVersion", source = "version")
    Member fromMemberEntity(MemberEntity memberEntity);

    @Mapping(target = "memberId", source = "id")
    @Mapping(target = "memberVersion", source = "version")
    Member fromMemberCache(MemberCache memberCache);

    MemberCache fromEntityToCache(MemberEntity memberEntity);
}
