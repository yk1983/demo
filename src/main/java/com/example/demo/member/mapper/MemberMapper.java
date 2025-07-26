package com.example.demo.member.mapper;

import com.example.demo.global.entity.User;
import com.example.demo.global.util.DateUtil;
import com.example.demo.global.util.StringUtil;
import com.example.demo.member.dto.MemberResponseDto;
import org.springframework.stereotype.Component;

@Component
public class MemberMapper {

    public MemberResponseDto toDto(User user) {
        if (user == null) return null;

        return MemberResponseDto.builder()
                .id(user.getUserId())
                .name(user.getName())
                .email(user.getUsername()) // username → email
                .phone(StringUtil.formatPhoneNumber(user.getPhone()))
                .gender(user.getGender())
                .birthDate(DateUtil.formatToDelimitedDate(user.getBirthDate()))
                .createdAt(DateUtil.format(user.getCreatedAt(), "yyyy-MM-dd HH:mm:ss"))
                .build();
    }
}
