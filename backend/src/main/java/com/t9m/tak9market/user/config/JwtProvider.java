package com.t9m.tak9market.user.config;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.JwtException;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
public class JwtProvider {

    private final String secretkey = "MySecretKey12345";
    private final long validityInMilliseconds = 3600000; // 1시간

    //토큰 생성
    public String createToken(String username, String role) {
        Claims claims = Jwts.claims().setSubject(username);
        claims.put("role", role);

        Date now = new Date();
        Date validity = new Date(now.getTime() + validityInMilliseconds);

        return Jwts.builder()
                .setClaims(claims)
                .setIssuedAt(now)
                .setExpiration(validity)
                .signWith(SignatureAlgorithm.HS256, secretkey)
                .compact();
    }

    // 토큰에서 username 추출
    public String getUsername(String token) {
        return Jwts.parser()
                .setSigningKey(secretkey)
                .parseClaimsJws(token)
                .getBody()
                .getSubject();
    }

    // 토큰에서 유효성 검증
    public boolean validateToken(String token) {
        try {
            Jwts.parser().setSigningKey(secretkey).parseClaimsJws(token);
            return true;
        } catch (JwtException | IllegalArgumentException e) {
            return false;
        }
    }
}
