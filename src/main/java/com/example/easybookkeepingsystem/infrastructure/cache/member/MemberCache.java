package com.example.easybookkeepingsystem.infrastructure.cache.member;

import com.example.easybookkeepingsystem.common.enums.Role;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.experimental.FieldDefaults;
import org.springframework.data.annotation.Id;
import org.springframework.data.redis.core.RedisHash;

@Builder
@Getter
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
@RedisHash(value = "MEMBER", timeToLive = 60 * 60 * 24)
public class MemberCache {

    Long id;

    Long version;

    @Id
    String userId;

    String password;

    Role role;

    Long companyId;

}
