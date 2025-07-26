package com.example.demo.global.config;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.enums.SecuritySchemeType;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.security.SecurityScheme;
import io.swagger.v3.oas.models.ExternalDocumentation;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import io.swagger.v3.oas.models.servers.Server;
import org.springdoc.core.models.GroupedOpenApi;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@OpenAPIDefinition(
        info = @io.swagger.v3.oas.annotations.info.Info(
                title = "내부 시스템 API 명세서",
                description = "Spring Boot + Springdoc OpenAPI 기반 API 명세",
                version = "v1.0",
                contact = @io.swagger.v3.oas.annotations.info.Contact(name = "API 담당자", email = "admin@example.com"),
                license = @io.swagger.v3.oas.annotations.info.License(name = "MIT License")
        ),
        security = @SecurityRequirement(name = "bearerAuth"),
        servers = {
                @io.swagger.v3.oas.annotations.servers.Server(url = "http://localhost:9090", description = "로컬 서버"),
                @io.swagger.v3.oas.annotations.servers.Server(url = "https://api.example.com", description = "운영 서버")
        }
)
@SecurityScheme(
        name = "bearerAuth",
        type = SecuritySchemeType.HTTP,
        scheme = "bearer",
        bearerFormat = "JWT"
)
public class SwaggerConfig {
    @Bean
    public OpenAPI customOpenAPI() {
        return new OpenAPI()
                .info(new Info()
                        .title("DEMO 시스템 API")
                        .description("Spring Boot DEMO 예제")
                        .version("v1.0.0")
                        .license(new License().name("MIT").url("https://opensource.org/licenses/MIT"))
                        .contact(new Contact().name("관리자").email("omiyong@gmail.com")))
                .addServersItem(new Server()
                        .url("http://localhost:9090")
                        .description("로컬 서버"))
                .externalDocs(new ExternalDocumentation()
                        .description("GitHub Repository")
                        .url("https://github.com/yk1983/demo"));
    }

    /**
     * 표준사전 API
     * @return GroupedOpenApi
     */
    @Bean
    public GroupedOpenApi domainApi() {
        return GroupedOpenApi.builder()
                .group("0. 표준사전")
                .pathsToMatch("/api/standard/**")
                .build();
    }

    /**
     * 공통 API
     * @return GroupedOpenApi
     */
    @Bean
    public GroupedOpenApi apiCommon() {
        return GroupedOpenApi.builder()
                .group("1. 공통") // 그룹 이름 (UI 탭)
                .pathsToMatch("/common/**", "/api/common/**") // 포함할 API 경로
                .build();
    }

    /**
     * 권한 관련 API
     * @return GroupedOpenApi
     */
    @Bean
    public GroupedOpenApi apiAuth() {
        return GroupedOpenApi.builder()
                .group("2. 권한") // 그룹 이름
                .pathsToMatch("/api/auth/**")
                .build();
    }

    /**
     * 사용자 관련 API
     * @return GroupedOpenApi
     */
    @Bean
    public GroupedOpenApi apiUser() {
        return GroupedOpenApi.builder()
                .group("3. 사용자") // 그룹 이름
                .pathsToMatch("/admin/members/**", "/api/members/**")
                .build();
    }

    /**
     * 커뮤니티 관련 API
     * @return GroupedOpenApi
     */
    @Bean
    public GroupedOpenApi apiCommunity() {
        return GroupedOpenApi.builder()
                .group("4. 커뮤니티") // 그룹 이름
                .pathsToMatch("/community/**", "/api/community/**")
                .build();
    }

}
