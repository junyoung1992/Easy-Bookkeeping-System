package com.example.easybookkeepingsystem.application;

import com.example.easybookkeepingsystem.domain.member.Member;

public interface MemberService {

    Member getMemberForAuth(String userId);

}
