package com.example.demo.global.config;

import com.example.demo.global.config.filter.JwtFilter;
import com.example.demo.global.error.CustomAccessDeniedHandler;
import com.example.demo.global.error.CustomAuthenticationEntryPoint;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
@EnableWebSecurity
@RequiredArgsConstructor
public class SecurityConfig {
    private final JwtFilter jwtFilter;
    private final CustomAccessDeniedHandler accessDeniedHandler;
    private final CustomAuthenticationEntryPoint authenticationEntryPoint;

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http
                .csrf(AbstractHttpConfigurer::disable) // CSRF 보호 비활성화 (API 프로젝트에서 주로 사용)
                .authorizeHttpRequests(auth ->
                        auth
                                .requestMatchers(
                                        "/css/**", "/js/**", "/images/**", "/fonts/**", "/favicon.ico",
                                        "/swagger-ui/**", "/v3/api-docs/**",
                                        "/signin", "/signup", "/api/auth/**", "/error/**",
                                        "/api/signup"
                                ).permitAll() // 인증 없이 접근 가능
                                .requestMatchers("/signup").anonymous() // 인증된 사용자는 접근 불가
                                .anyRequest().authenticated() // 나머지는 로그인 필요
                )
                .sessionManagement(session ->
                    session.sessionCreationPolicy(SessionCreationPolicy.IF_REQUIRED) // Web 인증은 세션 유지
                )
                .exceptionHandling(exception ->
                        exception
                                .accessDeniedHandler(accessDeniedHandler)
                                .authenticationEntryPoint(authenticationEntryPoint)
                )
                .addFilterBefore(jwtFilter, UsernamePasswordAuthenticationFilter.class)
                // ✅ HTML 로그인 처리
                .formLogin(form ->
                        form
                                .loginPage("/login") // 커스텀 로그인 페이지 URL
                                .loginProcessingUrl("/login") // 로그인 처리 URL (form action)
                                .defaultSuccessUrl("/dashboard", true) // 로그인 성공 후 이동할 URL
                                .failureUrl("/login?error=true")
                                .permitAll()
                )
                .logout(logout ->
                        logout
                                .logoutUrl("/logout") // 로그아웃 URL
                                .logoutSuccessUrl("/login?logout=true") // 로그아웃 성공 후 이동 URL
                                .permitAll()
                )
        ;
        return http.build();
    }
}
