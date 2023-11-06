package com.example.easybookkeepingsystem.domain.member;

import com.example.easybookkeepingsystem.common.enums.Role;
import com.example.easybookkeepingsystem.infrastructure.cache.member.MemberCache;
import com.example.easybookkeepingsystem.infrastructure.cache.member.MemberCacheRepository;
import com.example.easybookkeepingsystem.infrastructure.persistence.member.MemberEntity;
import com.example.easybookkeepingsystem.infrastructure.persistence.member.MemberJpaRepository;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.Instant;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.BDDMockito.given;
import static org.mockito.BDDMockito.then;

@ExtendWith(MockitoExtension.class)
class MemberRepositoryTest {

    @Mock
    MemberJpaRepository memberJpaRepository;

    @Mock
    MemberCacheRepository memberCacheRepository;

    @InjectMocks
    MemberRepository memberRepository;

    @Nested
    @DisplayName("findOneByUserId")
    class FindOneByUserId {
        @Test
        @DisplayName("캐시 회원 정보 조회 성공")
        void successByCache() {
            // given
            String userId = "admin";
            String password = "admin";
            Role role = Role.ADMIN;

            MemberCache memberCache = MemberCache.builder()
                    .id(1L)
                    .version(1L)
                    .userId(userId)
                    .password(password)
                    .role(role)
                    .build();

            Member expected = Member.builder()
                    .memberId(1L)
                    .memberVersion(1L)
                    .userId(userId)
                    .password(password)
                    .role(role)
                    .build();

            given(memberCacheRepository.findById(userId)).willReturn(Optional.of(memberCache));

            // when
            Member actual = memberRepository.findOneByUserId(userId).orElseThrow();

            // then
            assertThat(actual).isEqualTo(expected);
        }

        @Test
        @DisplayName("DB 회원 정보 조회 성공")
        void successByDB() {
            // given
            String userId = "admin";
            String password = "admin";
            Role role = Role.ADMIN;

            MemberEntity memberEntity = MemberEntity.builder()
                    .id(1L)
                    .version(1L)
                    .userId(userId)
                    .password(password)
                    .role(role)
                    .createdDate(Instant.now())
                    .modifiedDate(Instant.now())
                    .build();

            Member expected = Member.builder()
                    .memberId(1L)
                    .memberVersion(1L)
                    .userId(userId)
                    .password(password)
                    .role(role)
                    .build();

            given(memberCacheRepository.findById(userId)).willReturn(Optional.empty());
            given(memberJpaRepository.findOneByUserId(userId)).willReturn(Optional.of(memberEntity));

            // when
            Member actual = memberRepository.findOneByUserId(userId).orElseThrow();

            // then
            assertThat(actual).isEqualTo(expected);

            then(memberCacheRepository).should().findById(userId);
            then(memberCacheRepository).should().save(any(MemberCache.class));
        }

        @Test
        @DisplayName("존재하지 않는 회원 정보")
        void noFoundData() {
            // given
            String userId = "admin";

            given(memberJpaRepository.findOneByUserId(userId)).willReturn(Optional.empty());

            // when
            Optional<Member> actual = memberRepository.findOneByUserId(userId);

            // then
            assertThat(actual).isEqualTo(Optional.empty());
        }
    }

}