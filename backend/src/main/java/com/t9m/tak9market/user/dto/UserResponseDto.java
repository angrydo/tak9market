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
@NoArgsConstructor
@AllArgsConstructor
public class UserResponseDto {
    private Long id;
    private Role role;
    private String name;
    private Gender gender;
    private String email;
    private String nickname;
    private String username;
    private String password;
    private String phone;
    private LocalDateTime birthday;

    public UserResponseDto(User entity) {
        this.id = entity.getId();
        this.role = entity.getRole();
        this.name = entity.getName();
        this.gender = entity.getGender();
        this.email = entity.getEmail();
        this.nickname = entity.getNickname();
        this.username = entity.getUsername();
        this.password = entity.getPassword();
        this.phone = entity.getPhone();
        this.birthday = entity.getBirthday();
    }
}
