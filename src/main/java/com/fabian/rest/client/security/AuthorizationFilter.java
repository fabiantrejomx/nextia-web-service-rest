package com.fabian.rest.client.security;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.DecodedJWT;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.filter.OncePerRequestFilter;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class AuthorizationFilter extends OncePerRequestFilter {
    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {

        if(request.getServletPath().equals("/api/v1/login")){
            filterChain.doFilter(request, response);
        }else{
            final String authHeader = request.getHeader(HttpHeaders.AUTHORIZATION);

            if(authHeader != null && authHeader.startsWith("Bearer ")){
                try{
                    final String token = authHeader.substring("Bearer ".length());
                    final Algorithm algorithm = Algorithm.HMAC256("localhost".getBytes());
                    final JWTVerifier verifier = JWT.require(algorithm).build();
                    final DecodedJWT decodedJWT = verifier.verify(token);
                    final String email = decodedJWT.getSubject();

                    final UsernamePasswordAuthenticationToken authenticationToken =
                            new UsernamePasswordAuthenticationToken(email, null, new ArrayList<>());

                    SecurityContextHolder.getContext().setAuthentication(authenticationToken);
                    filterChain.doFilter(request, response);
                }catch (final Exception e){
                    error(response);
                }
            }else{
                error(response);
            }
        }
    }

    private void error(HttpServletResponse response) throws IOException {
        response.setHeader("error", "error");
        response.setStatus(HttpStatus.UNAUTHORIZED.value());
        response.setContentType(MediaType.APPLICATION_JSON_VALUE);

        final Map<String, String> error = new HashMap<>();
        new ObjectMapper().writeValue(response.getOutputStream(), error);
    }
}
