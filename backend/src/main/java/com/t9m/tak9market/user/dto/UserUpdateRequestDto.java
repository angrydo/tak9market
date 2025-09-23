package com.t9m.tak9market.user.dto;

import com.t9m.tak9market.user.domain.Role;
import com.t9m.tak9market.user.domain.User;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UserUpdateRequestDto {
    private Long id;
    private Role role;
    private String email;
    private String nickname;
    private String password;
    private String phone;

    public User toEntity() {
        return User.builder()
                .id(this.id)
                .role(this.role)
                .email(this.email)
                .nickname(this.nickname)
                .password(this.password)
                .phone(this.phone)
                .build();
    }
}
