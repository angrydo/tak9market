package com.t9m.tak9market.user.service;

import com.t9m.tak9market.user.domain.Role;
import com.t9m.tak9market.user.domain.User;
import com.t9m.tak9market.user.dto.UserCreateRequestDto;
import com.t9m.tak9market.user.dto.UserResponseDto;
import com.t9m.tak9market.user.repository.UserRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@Transactional
@RequiredArgsConstructor
public class UserWriteService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    public UserResponseDto create(UserCreateRequestDto requestDto) {
        if (userRepository.existsByUsername(requestDto.getUsername())) {
            throw new IllegalArgumentException("Username already exists");
        }
        if (userRepository.existsByEmail(requestDto.getEmail())) {
            throw new IllegalArgumentException("Email already exists");
        }
        // 비밀번호 암호화
        String encodedPassword = passwordEncoder.encode(requestDto.getPassword());
        User user = requestDto.toEntity(encodedPassword);
        user.setRole(Role.USER);    // 생성시 defualt로 Role USER로 지정
        User userSaved = userRepository.save(user);
        return new UserResponseDto(userSaved);
    }

}
