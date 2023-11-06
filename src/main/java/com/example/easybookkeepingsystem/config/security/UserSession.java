package com.example.easybookkeepingsystem.config.security;

import com.example.easybookkeepingsystem.domain.member.Member;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.experimental.FieldDefaults;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;

import java.util.List;

@Getter
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class UserSession extends User {

    Member member;

    public UserSession(Member member) {
        super(member.getUserId(), member.getPassword(), List.of(new SimpleGrantedAuthority("ROLE_" + member.getRole())));
        this.member = member;
    }

}
