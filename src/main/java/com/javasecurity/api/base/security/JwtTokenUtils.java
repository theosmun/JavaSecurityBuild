//package com.javasecurity.api.base.security;
//
//import io.jsonwebtoken.Claims;
//import io.jsonwebtoken.Jwts;
//import jakarta.annotation.PostConstruct;
//import org.springframework.beans.factory.annotation.Value;
//import org.springframework.stereotype.Component;
//
//import javax.crypto.SecretKey;
//import javax.crypto.spec.SecretKeySpec;
//import java.util.Base64;
//import java.util.Date;
//
//@Component
//public class JwtTokenUtils {
//    @Value("${jwt.secretKey}")
//    private String secretKey;
//
//    @Value("${jwt.accessToken.expiration}")
//    private Long accessTokenExpire;
//
//    @Value("${jwt.refreshToken.expiration}")
//    private Long refreshTokenExpire;
//
//    private SecretKey tokenSecretKey;
//
//    @PostConstruct
//    protected void init() {
//        this.tokenSecretKey = new SecretKeySpec(Base64.getEncoder().encode(secretKey.getBytes()), "HmacSHA256");
//    }
//
//    public String createToken(String userId, String uuid, boolean isAccessToken) {
//        Long expire = isAccessToken ? accessTokenExpire : refreshTokenExpire;
//        return Jwts.builder()
//                .setId(uuid)
//                .claim("ID", uuid)
//                .claim("USER_ID", userId)
//                .setSubject(userId)
//                .setIssuedAt(new Date())
//                .setExpiration(new Date(System.currentTimeMillis() + expire))
//                .signWith(tokenSecretKey)
//                .compact();
//    }
//
//    public Claims getTokenInfo(String token) {
//        return Jwts.parserBuilder()
//                .setSigningKey(tokenSecretKey)
//                .build()
//                .parseClaimsJws(token)
//                .getBody();
//    }
//}