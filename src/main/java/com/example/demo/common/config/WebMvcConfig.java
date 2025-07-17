package com.example.demo.common.config;

import com.example.demo.common.config.interceptor.LoggingInterceptor;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@RequiredArgsConstructor
@Configuration
public class WebMvcConfig implements WebMvcConfigurer {
    private final LoggingInterceptor loggingInterceptor;

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(loggingInterceptor)
                .addPathPatterns("/**") // 적용할 경로
                .excludePathPatterns("/css/**", "/js/**", "/images/**", "/assets/**", "/favicon*", "/error/**") // 제외할 경로
        ;
    }

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        // 정적 리소스로 등록
        registry.addResourceHandler("/favicon*")
                .addResourceLocations("classpath:/static/");
    }
}
