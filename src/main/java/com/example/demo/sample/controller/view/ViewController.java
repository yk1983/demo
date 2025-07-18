package com.example.demo.sample.controller.view;

import com.example.demo.sample.domain.dto.SignupRequestDto;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Slf4j
@Controller
@RequestMapping
public class ViewController {
    @GetMapping("/hello")
    public String hello() { return "demo/hello"; }

    @GetMapping("/login")
    public String login() { return "demo/login"; }

    @GetMapping("/signup")
    public String join(Model model, Authentication authentication) {
        // TODO: 인증된 사용자가 /register 접근 시 대시보드로 리다이렉트 처리
        if (authentication != null && authentication.isAuthenticated()) {
            return "redirect:/dashboard";
        }

        model.addAttribute("user", new SignupRequestDto());
        return "demo/signup";
    }

    @GetMapping("/dashboard")
    public String dashboard() { return "demo/hello"; }
}
