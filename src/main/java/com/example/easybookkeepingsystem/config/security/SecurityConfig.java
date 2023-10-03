package com.example.easybookkeepingsystem.config.security;

import jakarta.servlet.DispatcherType;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

@Configuration
public class SecurityConfig {

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http.csrf(AbstractHttpConfigurer::disable)
                .cors(AbstractHttpConfigurer::disable)
                .authorizeHttpRequests(request -> request
                        .dispatcherTypeMatchers(DispatcherType.FORWARD).permitAll() // FORWARD : 서블릿에서 다른 서블릿이나 JSP를 호출할 때
                        .requestMatchers(new AntPathRequestMatcher("/")).permitAll()
                        .anyRequest().authenticated())
                .formLogin(login -> login   // formLogin 활용
                        .loginPage("/login")    // 커스텀 로그인 페이지
                        .loginProcessingUrl("/login/process")   // submit 받을 페이지
                        .usernameParameter("userId")    // submit 할 아이디
                        .passwordParameter("password")  // submit 할 비밀번호
                        .defaultSuccessUrl("/bookkeeping/list", true).permitAll())  // 로그인 완료시
//                .logout(Customizer.withDefaults()); // default : /logout
                .logout(logout -> logout
                        .logoutUrl("/logout")
                        .deleteCookies("JSESSIONID")
                        .logoutSuccessUrl("/"));

        return http.build();
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

}
