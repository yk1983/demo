package com.example.demo.sample.controller.view;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
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

    @GetMapping("/join")
    public String join() { return "demo/join"; }
}
