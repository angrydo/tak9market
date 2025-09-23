package com.t9m.tak9market.user.dto;

import com.t9m.tak9market.user.domain.Gender;
import com.t9m.tak9market.user.domain.Role;
import com.t9m.tak9market.user.domain.User;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class UserCreateRequestDto {
    private Role role;
    private String name;
    private Gender gender;
    private String email;
    private String nickname;
    private String username;
    private String password;
    private String phone;
    private LocalDateTime birthday;

    public User toEntity(String encodedPassword) {
        return User.builder()
                .role(this.role)
                .gender(this.gender)
                .name(this.name)
                .gender(this.gender)
                .email(this.email)
                .nickname(this.nickname)
                .username(this.username)
                .password(encodedPassword)
                .phone(this.phone)
                .birthday(this.birthday)
                .build();
    }
}
