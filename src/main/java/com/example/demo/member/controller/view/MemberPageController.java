package com.example.demo.member.controller.view;

import com.example.demo.auth.service.UserService;
import com.example.demo.member.dto.MemberResponseDto;
import com.example.demo.member.service.MemberService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Slf4j
@Controller
@RequiredArgsConstructor
@RequestMapping("/admin/members")
@Tag(name = "회원 관련 VIEW 컨트롤러", description = "회원 조회 및 수정 관리 VIEW")
public class MemberPageController {

    private final MemberService memberService;

    @GetMapping
    @Operation(summary = "회원 목록 VIEW", description = "회원 목록을 조회하는 화면을 호출합니다.")
    public String getUserView(@RequestParam(required = false) String keyword,
                              Model model) {
        List<MemberResponseDto> members = memberService.searchMember(keyword);
        model.addAttribute("members", members);
        model.addAttribute("keyword", keyword);
        return "user/user-list";
    }
}
