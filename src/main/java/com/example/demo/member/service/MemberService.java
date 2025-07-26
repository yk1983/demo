package com.example.demo.member.service;

import com.example.demo.member.dto.MemberResponseDto;

import java.util.List;

public interface MemberService {

    List<MemberResponseDto> searchMember(String keyword);
}
