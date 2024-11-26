package com.example.tienda_emazon.infrastructure.security.util;

import io.jsonwebtoken.*;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

import java.util.Collection;
import java.util.Collections;

import static com.example.tienda_emazon.domain.util.Constants.ACCESS_TOKEN_SECRET;

public class TokenUtils {


    private TokenUtils() {
    }

    public static UsernamePasswordAuthenticationToken getAuthenticationToken(String token) {
        try {
            Claims claims = Jwts
                    .parserBuilder()
                    .setSigningKey(ACCESS_TOKEN_SECRET.getBytes())
                    .build()
                    .parseClaimsJws(token)
                    .getBody();
            //Extract the email from the token
            String email = claims.getSubject();
            //Extract the role from the token
            String role = (String) claims.get("role");
            //Create an Authorities with the role
            Collection<? extends GrantedAuthority> authorities =
                    Collections.singletonList(new SimpleGrantedAuthority(role));
            //Return a new User authentication with user credentials
            return new UsernamePasswordAuthenticationToken(
                    email,
                    null,
                    authorities
            );
        }
        catch (JwtException e) {
            return null;
        }
    }


}
