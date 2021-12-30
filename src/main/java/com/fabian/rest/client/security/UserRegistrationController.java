package com.fabian.rest.client.security;

import com.fabian.rest.client.dto.TokenDTO;
import com.fabian.rest.client.form.AccessRequest;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;

import javax.servlet.http.HttpServletRequest;


@RestController
@RequestMapping("/api/v1")
@RequiredArgsConstructor
@Slf4j
public class UserRegistrationController {

    private final UserServiceSecurity userServiceSecurity;
    private final AuthenticationManager authenticationManager;


    @PostMapping(value = "/registration")
    public ResponseEntity<Void> register(
            @Validated @RequestBody final AccessRequest accessRequest,
            final BindingResult bindingResult) throws Exception {
        if (bindingResult.hasErrors()) {
            throw new Exception("Error");
        }

        userServiceSecurity.signUpUser(accessRequest);
        return ResponseEntity.ok().build();
    }

    /*@PostMapping(value = "/login")
    public ResponseEntity<TokenDTO> authenticateUser(
            @Validated @RequestBody AccessRequest logInRequest,
            final HttpServletRequest request) {

        log.info("entrroooo");
        final Authentication authentication =
                authenticationManager.authenticate(
                        new UsernamePasswordAuthenticationToken(
                                logInRequest.getEmail(), logInRequest.getPassword()));

        log.info("auuausausduausdasd");

        SecurityContextHolder.getContext().setAuthentication(authentication);
        final String token = AuthFilter.createToken(logInRequest.getEmail(),request);

        return ResponseEntity.ok(TokenDTO.builder().token(token).build());
    }*/
}
