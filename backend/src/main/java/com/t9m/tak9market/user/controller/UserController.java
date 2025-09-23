package com.t9m.tak9market.user.controller;

import com.t9m.tak9market.common.dto.CommonResponse;
import com.t9m.tak9market.user.dto.UserCreateRequestDto;
import com.t9m.tak9market.user.dto.UserLoginRequestDto;
import com.t9m.tak9market.user.dto.UserResponseDto;
import com.t9m.tak9market.user.repository.UserRepository;
import com.t9m.tak9market.user.service.UserReadService;
import com.t9m.tak9market.user.service.UserWriteService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/user")
@RequiredArgsConstructor
public class UserController {

    private final UserWriteService userWriteService;
    private final UserReadService userReadService;

    //* 회원가입 API */
    @PostMapping("/create")
    public ResponseEntity<CommonResponse<?>> createUser(@RequestBody UserCreateRequestDto requestDto) {
        UserResponseDto responseDto = userWriteService.create(requestDto);
        return ResponseEntity.status(HttpStatus.OK).body(CommonResponse.success(responseDto));
    }

    //* 로그인 API */
    @PostMapping("/login")
    public ResponseEntity<CommonResponse<?>> login(@RequestBody UserLoginRequestDto requestDto) {
        String token = userReadService.login(requestDto);
        return ResponseEntity.status(HttpStatus.OK).body(CommonResponse.success(token));
    }

}
