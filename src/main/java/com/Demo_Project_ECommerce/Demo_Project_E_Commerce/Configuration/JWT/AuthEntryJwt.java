package com.Demo_Project_ECommerce.Demo_Project_E_Commerce.Configuration.JWT;

import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Component
public class AuthEntryJwt implements AuthenticationEntryPoint
{
    @Override
    public void commence(HttpServletRequest request, HttpServletResponse response, AuthenticationException authException)
    throws IOException, ServletException
    {
        response.sendError(HttpServletResponse.SC_UNAUTHORIZED,"Error : Unauthorized");
    }
}
