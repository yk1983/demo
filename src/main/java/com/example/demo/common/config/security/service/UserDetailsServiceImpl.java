package com.example.demo.common.config.security.service;

import com.example.demo.sample.domain.dto.UserResponseDto;
import com.example.demo.sample.domain.entity.User;
import com.example.demo.sample.mapper.UserMapper;
import com.example.demo.sample.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserDetailsServiceImpl implements UserDetailsService {

    private final UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        // TODO: 사용자 조회
        User user = userRepository.findByUsername(email)
                .orElseThrow(() -> new UsernameNotFoundException("사용자를 찾을 수 없습니다: " + email));

        // 비밀번호는 UserDetails 내부에서 직접 엔티티로 접근하거나 다른 방식으로 처리 가능
        UserResponseDto userDto = UserMapper.toDto(user);

        return null;
    }
}
