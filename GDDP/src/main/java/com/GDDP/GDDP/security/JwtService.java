package com.GDDP.GDDP.security;

import java.security.Key;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;
@Service
// this service  will generate token , decode token , extract info from token etc ..
public class JwtService {


    @Value("${application.security.jwt.expiration }")
    private Long jwtExpiration;

    @Value("${application.security.jwt.secret-key }")
    private String secretKey;

    public String generateToken(UserDetails userDetails ) {
        return generateToken(new HashMap<>() , userDetails);

    }
    private String generateToken(Map<String, Object> claims, UserDetails userDetails) {
        // TODO Auto-generated method stub
        return buildToken(claims, userDetails , jwtExpiration);
    }
    private String buildToken(
            Map<String, Object> extraClaims,
            UserDetails userDetails,
            Long jwtExpiration) {

        var authorities = userDetails.getAuthorities()
                .stream().map(GrantedAuthority :: getAuthority)
                .toList();

        return Jwts.builder().setClaims(extraClaims)
                .setSubject(userDetails.getUsername())
                .setIssuedAt(new Date(System.currentTimeMillis()))
                .setExpiration(null)
                .claim("authorities", authorities)
                .signWith(getSignInKey())
                .compact();

    }
    private Key getSignInKey() {
        byte[] keyBytes=Decoders.BASE64.decode(secretKey);
        return Keys.hmacShaKeyFor(keyBytes);
    }




}
