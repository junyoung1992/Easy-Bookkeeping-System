package com.example.easybookkeepingsystem.application.impl;

import com.example.easybookkeepingsystem.application.MemberService;
import com.example.easybookkeepingsystem.domain.member.Member;
import com.example.easybookkeepingsystem.domain.member.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MemberServiceImpl implements MemberService {

    private final MemberRepository memberRepository;

    @Override
    public Member getMemberForAuth(String userId) {
        return memberRepository.findOneByUserId(userId)
                .orElseThrow(() -> new UsernameNotFoundException("존재하지 않는 회원입니다."));
    }

}
