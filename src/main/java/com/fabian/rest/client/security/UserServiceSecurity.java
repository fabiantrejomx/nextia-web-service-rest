package com.fabian.rest.client.security;

import com.fabian.rest.client.entity.User;
import com.fabian.rest.client.form.AccessRequest;
import com.fabian.rest.client.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;

@Service
@RequiredArgsConstructor
@Slf4j
public class UserServiceSecurity implements UserDetailsService {

    private final UserRepository userRepository;
    private final BCryptPasswordEncoder bCryptPasswordEncoder;
    private static final String USER_NOT_FOUND_MSG = "User with email %s not found";

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        final User user = userRepository
                .findByEmail(email)
                .orElseThrow(() -> new UsernameNotFoundException(String.format(USER_NOT_FOUND_MSG, email)));

        return new org.springframework.security.core.userdetails
                .User(user.getUsername(), user.getPassword(), new ArrayList<>());
    }


    @Transactional(
            propagation = Propagation.REQUIRED,
            isolation = Isolation.DEFAULT,
            rollbackFor = {Exception.class, RuntimeException.class})
    public void signUpUser(final AccessRequest request) {
        final boolean userIsPresent = userRepository.findByEmail(request.getEmail()).isPresent();

        if (userIsPresent) {
            throw new IllegalStateException("email already taken");
        }

        final String encodedPassword = bCryptPasswordEncoder.encode(request.getPassword());
        final User user = new User(request.getEmail(), encodedPassword);
        userRepository.save(user);
        log.info("New user was save");
    }
}
