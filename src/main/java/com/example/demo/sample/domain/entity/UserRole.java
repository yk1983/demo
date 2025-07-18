package com.example.demo.sample.domain.entity;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class UserRole {
    @Id
    @GeneratedValue
    private Long id;

    @Schema(example = "ADMIN, STUDENT, TEACHER, GUEST")
    private String roleCode;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;
}
