package com.t9m.tak9market.user.domain;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDateTime;

@Getter
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Setter
    @Enumerated(EnumType.STRING)
    private Role role;                  // 회원, 관리자
    private String name;                // 성명
    @Enumerated(EnumType.STRING)
    private Gender gender;              // 성별
    @Column(nullable = false, unique = true)
    private String email;               // 메일 주소
    @Column(nullable = false, unique = true)
    private String nickname;            // 닉네임
    @Column(nullable = false, unique = true)
    private String username;            // id
    @Column(nullable = false)
    private String password;            // password
    private String phone;               // 휴대전화 번호
    private LocalDateTime birthday;     // 생년월일
    @CreationTimestamp
    private LocalDateTime createdDate;  // 생성일자
    @UpdateTimestamp
    private LocalDateTime updatedDate;  // 수정일자

}
