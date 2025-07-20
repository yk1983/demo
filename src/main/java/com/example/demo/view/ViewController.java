package com.example.demo.view;

import com.example.demo.auth.dto.SignupRequestDto;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Slf4j
@Controller
@RequestMapping
@Schema(description = "회원 관련 View 화면", example = "로그인 / 회원가입 / 비밀번호 찾기 등 ...")
public class ViewController {
    @GetMapping("/signup")
    public String join(Model model, Authentication authentication) {
        // TODO: 인증된 사용자가 /signup 접근 시 대시보드로 리다이렉트 처리
        if (authentication != null && authentication.isAuthenticated()) {
            return "redirect:/dashboard";
        }

        model.addAttribute("user", new SignupRequestDto());
        return "demo/signup";
    }
}
