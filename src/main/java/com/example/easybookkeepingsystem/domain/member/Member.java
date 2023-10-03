package com.example.easybookkeepingsystem.domain.member;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.experimental.FieldDefaults;

@Builder
@Getter
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class Member {
    Long memberId;
    Long memberVersion;
    String userId;
    String password;
    String role;
}
