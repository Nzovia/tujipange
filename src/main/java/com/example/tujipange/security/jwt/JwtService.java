package com.example.tujipange.security.jwt;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import java.security.Key;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * @author Nicholas Nzovia
 * @On 19/01/2024
 * @Contact: itsdevelopernic22@gmail.com
 */

@Component
public class JwtService {
    //new enc VY04s0fYxDiAP5FHEnpyo5G2izIdFmfzqeLWXGQL0MJIMXiRkNg/dnZOuqzzZySj
    public static  final String SECRET_KEY = "9a39863c912d9d310f5c4fd043ac9d4c1a4114fc39033ecb41b5d249092f6b1f";
    public  String generateToken(String username){
        Map<String, Object> claims = new HashMap<>();
        return createToken(claims, username);
    }

    private String createToken(Map<String, Object> claims, String username) {
        return Jwts.builder()
                .setClaims(claims)
                .setSubject(username)
                .setIssuedAt(new Date(System.currentTimeMillis()))
                .setExpiration(new Date(System.currentTimeMillis()+1000*60*30))
                .signWith(getSignKey(), SignatureAlgorithm.HS256)
                .compact();
    }

    private Key getSignKey() {
        byte [] keyBytes = Decoders.BASE64.decode(SECRET_KEY);
        return Keys.hmacShaKeyFor(keyBytes);
    }

    public boolean isJWTTokenValid(String jwt, UserDetails userDetails) {
        return  true;
    }

    public String extractUserNameFromToken(String jwt) {
        return  null;
    }
}
