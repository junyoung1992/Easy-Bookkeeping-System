package com.example.easybookkeepingsystem.application.impl;

import com.example.easybookkeepingsystem.common.enums.Role;
import com.example.easybookkeepingsystem.domain.member.Member;
import com.example.easybookkeepingsystem.domain.member.MemberRepository;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.mockito.BDDMockito.given;

@ExtendWith(MockitoExtension.class)
class MemberServiceImplTest {

    @Mock
    MemberRepository memberRepository;

    @InjectMocks
    MemberServiceImpl memberService;

    @Nested
    @DisplayName("getMemberForAuth")
    class GetMemberForAuth {
        @Test
        @DisplayName("회원 정보 조회 성공")
        void success() {
            // given
            String userId = "admin";
            String password = "admin";
            Role role = Role.ADMIN;

            Member member = Member.builder()
                    .memberId(1L)
                    .memberVersion(1L)
                    .userId(userId)
                    .password(password)
                    .role(role)
                    .build();

            given(memberRepository.findOneByUserId(userId)).willReturn(Optional.of(member));

            // when
            Member actual = memberService.getMemberForAuth(userId);

            // then
            assertThat(actual).isEqualTo(member);
        }

        @Test
        @DisplayName("존재하지 않는 회원 정보")
        void noFoundData() {
            // given
            String userId = "admin";
            given(memberRepository.findOneByUserId(userId)).willReturn(Optional.empty());

            // when - exception
            assertThatThrownBy(() -> memberService.getMemberForAuth(userId))
                    .isInstanceOf(UsernameNotFoundException.class)
                    .hasMessage("존재하지 않는 회원입니다.");
        }
    }

}