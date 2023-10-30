package com.example.easybookkeepingsystem.domain.member;

import com.example.easybookkeepingsystem.common.enums.Role;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.experimental.FieldDefaults;

@Builder
@Getter
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
@EqualsAndHashCode
public class Member {
    Long memberId;
    Long memberVersion;
    String userId;
    String password;
    Role role;
    Long companyId;
}
