package com.Demo_Project_ECommerce.Demo_Project_E_Commerce.Configuration.JWT;

import com.Demo_Project_ECommerce.Demo_Project_E_Commerce.Services.RefreshTokenService.Refresh_Token_Service;
import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTVerificationException;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
public class Jwt_Utils
{    @Value("${dashboard.app.jwtSecret}")
     private String jwtSecret;

    @Value("${dashboard.app.jwtExpirationMs}")
    private int jwtExpirationMs;

    private Refresh_Token_Service refreshTokenService;


    public Integer getJwtMillis(){
        return jwtExpirationMs;
    }

    public String generateJwtToken(String username) {
        Algorithm algorithm = Algorithm.HMAC512(jwtSecret);
        return JWT.create()
                  .withSubject(String.valueOf(username))
                  .withIssuedAt(new Date())
                  .withExpiresAt(new Date((new Date()).getTime() + jwtExpirationMs))
                  .sign(algorithm);
    }

    public String getUserNameFromJwtToken(String token) {
        return JWT.decode(token)
                  .getSubject();
    }

    public boolean validateJwtToken(String authToken) {
        try {
            Algorithm algorithm = Algorithm.HMAC512(jwtSecret);
            JWTVerifier verifier = JWT.require(algorithm).build(); //Reusable verifier instance
            verifier.verify(authToken);
            return true;
        } catch (JWTVerificationException e) {
            e.printStackTrace();
        }

        return false;
    }
}

