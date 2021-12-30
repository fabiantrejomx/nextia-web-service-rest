package com.fabian.rest.client.security;

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

@RestController
@RequestMapping("/api/v1")
@RequiredArgsConstructor
@Slf4j
public class UserRegistrationController {

    private final UserServiceSecurity userServiceSecurity;

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
}
