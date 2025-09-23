package com.t9m.tak9market.user.service;

import com.t9m.tak9market.user.config.JwtProvider;
import com.t9m.tak9market.user.domain.User;
import com.t9m.tak9market.user.dto.UserLoginRequestDto;
import com.t9m.tak9market.user.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class UserReadService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final JwtProvider jwtProvider;

    /* 로그인 */
    public String login(UserLoginRequestDto requestDto) {
        User user = userRepository.findByUsername(requestDto.getUsername())
                .orElseThrow(() -> new IllegalArgumentException("존재하지 않는 회원입니다."));
        if (!passwordEncoder.matches(requestDto.getPassword(), user.getPassword())) {
            throw new IllegalArgumentException("비밀번호가 일치하지 않습니다.");
        }
        // JWT 토큰 발급
        return jwtProvider.createToken(user.getUsername(), user.getRole().name());
    }
}
