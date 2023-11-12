package com.example.easybookkeepingsystem.config.security;

import com.example.easybookkeepingsystem.application.MemberUseCase;
import com.example.easybookkeepingsystem.domain.member.Member;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class CustomUserDetailService implements UserDetailsService {

    private final MemberUseCase memberUseCase;

    @Override
    public UserDetails loadUserByUsername(String userId) throws UsernameNotFoundException {
        Member member = memberUseCase.getMemberForAuth(userId);
        return new UserSession(member);
    }

}
