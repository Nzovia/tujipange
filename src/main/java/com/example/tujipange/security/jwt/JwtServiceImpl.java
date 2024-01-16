package com.example.tujipange.security.jwt;

import com.example.tujipange.security.jwt.JwtService;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import java.security.Key;
import java.security.KeyStore;
import java.util.Base64;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

/**
 * @author Nicholas Nzovia
 * @On 25/10/2023
 * @Contact: itsdevelopernic22@gmail.com
 */

@Service
public class JwtServiceImpl implements JwtService {
    private Key jwtSignInKey;
    public JwtServiceImpl() {
        this.jwtSignInKey = getSignInKey();
    }

    public Key getSignInKey() {
        try {
            jwtSignInKey = Keys.secretKeyFor(SignatureAlgorithm.HS256);
            return jwtSignInKey;
        } catch (Exception exception) {
            exception.printStackTrace();
            throw new RuntimeException("Error generating jwt exception", exception);
        }
    }

    @Override
    public String extractUserNameFromToken(String token) {
        return extractClaim(token, Claims::getSubject);
    }

    @Override
    public String generateJWTToken(UserDetails userDetails) {
        return generateToken(new HashMap<>(), userDetails);
    }

    @Override
    public boolean isJWTTokenValid(String token, UserDetails userDetails) {
        //check whether extracted name is the same as username provided
        final String userName = extractUserNameFromToken(token);
        return (userName.equals(userDetails.getUsername())) && !isTokenExpired(token);
    }

    private <T> T extractClaim(String token, Function<Claims, T> claimsResolvers) {
        final Claims claims = extractAllClaims(token);
        return claimsResolvers.apply(claims);
    }

    private Claims extractAllClaims(String token) {
        return Jwts.parserBuilder().setSigningKey(getSignInKey()).build().parseClaimsJws(token).getBody();
    }


    //Generating the JWT token
    private String generateToken(Map<String, Object> extractClaims, UserDetails userDetails) {
        return Jwts.builder().setClaims(extractClaims).setSubject(userDetails.getUsername())
                .setIssuedAt(new Date(System.currentTimeMillis()))
                .setExpiration(new Date(System.currentTimeMillis() + 1000 * 60))
                .signWith(getSignInKey(), SignatureAlgorithm.HS256).compact();
    }

    private boolean isTokenExpired(String token) {
        return extractExpiration(token).before(new Date());
    }

    private Date extractExpiration(String token) {
        return extractClaim(token, Claims::getExpiration);
    }


}
