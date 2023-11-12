package com.example.easybookkeepingsystem.config.security;

import com.example.easybookkeepingsystem.application.MemberUseCase;
import com.example.easybookkeepingsystem.common.enums.Role;
import com.example.easybookkeepingsystem.domain.member.Member;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.mockito.BDDMockito.given;

@ExtendWith(MockitoExtension.class)
class CustomUserDetailServiceTest {

    @Mock
    MemberUseCase memberUseCase;

    @InjectMocks
    CustomUserDetailService customUserDetailService;

    @Nested
    @DisplayName("loadUserByUsername")
    class LoadUserByUsername {
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

            given(memberUseCase.getMemberForAuth(userId)).willReturn(member);

            // when
            UserDetails actual = customUserDetailService.loadUserByUsername(userId);

            // then
            assertThat(actual.getUsername()).isEqualTo(userId);
            assertThat(actual.getPassword()).isEqualTo(password);
            assertThat(actual.getAuthorities()).allMatch(x -> x.getAuthority().equals("ROLE_" + role.name()));
        }

        @Test
        @DisplayName("존재하지 않는 회원 정보")
        void noFoundData() {
            // given
            String userId = "admin";
            given(memberUseCase.getMemberForAuth(userId)).willThrow(new UsernameNotFoundException("존재하지 않는 회원입니다."));

            // when - exception
            assertThatThrownBy(() -> customUserDetailService.loadUserByUsername(userId))
                    .isInstanceOf(UsernameNotFoundException.class)
                    .hasMessage("존재하지 않는 회원입니다.");
        }
    }

}