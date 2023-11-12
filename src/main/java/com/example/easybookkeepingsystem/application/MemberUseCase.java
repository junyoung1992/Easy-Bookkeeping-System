package com.example.easybookkeepingsystem.application;

import com.example.easybookkeepingsystem.domain.member.Member;

public interface MemberUseCase {

    Member getMemberForAuth(String userId);

}
