package com.fabian.rest.client.security;

import com.fabian.rest.client.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class SecurityHelper {

    private final UserRepository userRepository;

    public String getUserSessionId() {
        return userRepository.findByEmail(getEmail()).get().getId();
    }

    private static String getEmail() {
        return SecurityContextHolder.getContext().getAuthentication().getName();
    }


}
