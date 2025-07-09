package com.example.demo.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {
    /*----------------------------
        브라우저에서 "http://localhost:8080/hello" 로 접속시
        브라우저에서 "Hello, Spring Boot!" 가 출력됨을 확인 !
    ----------------------------*/
    @GetMapping("/hello")
    public String hello(){
        return "Hello, Spring Boot!";
    }
}
