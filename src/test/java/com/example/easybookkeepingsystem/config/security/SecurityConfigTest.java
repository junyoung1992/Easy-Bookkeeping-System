package com.example.easybookkeepingsystem.config.security;

import org.junit.jupiter.api.Test;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

class SecurityConfigTest {

    @Test
    void test() {
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        String result = encoder.encode("admin");
        System.out.println("result = " + result);
    }

}