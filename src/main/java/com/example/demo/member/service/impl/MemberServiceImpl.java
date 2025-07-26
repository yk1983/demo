package com.example.demo.member.service.impl;

import com.example.demo.auth.mapper.UserMapper;
import com.example.demo.global.entity.User;
import com.example.demo.member.dto.MemberResponseDto;
import com.example.demo.member.mapper.MemberMapper;
import com.example.demo.member.repository.MemberRepository;
import com.example.demo.member.service.MemberService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Slf4j
@Service
@RequiredArgsConstructor
public class MemberServiceImpl implements MemberService {

    private final MemberRepository memberRepository;
    private final MemberMapper memberMapper;

    @Override
    public List<MemberResponseDto> searchMember(String keyword) {
        if (StringUtils.hasText(keyword)) {
            log.debug("1");
            return Optional.ofNullable(memberRepository.findByUsernameOrName(keyword, keyword))
                    .orElse(Collections.emptyList())
                    .stream()
                    .map(memberMapper::toDto)
                    .collect(Collectors.toList());
        } else {
            log.debug("2");
            return memberRepository.findAll().stream()
                    .map(memberMapper::toDto)
                    .collect(Collectors.toList());
        }
    }
}
