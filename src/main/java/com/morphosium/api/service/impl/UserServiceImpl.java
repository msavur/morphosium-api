package com.morphosium.api.service.impl;

import com.morphosium.api.config.jwt.config.JwtTokenUtil;
import com.morphosium.api.config.jwt.exception.AuthenticationException;
import com.morphosium.api.entity.User;
import com.morphosium.api.enums.FailureEnums;
import com.morphosium.api.model.GenericResponse;
import com.morphosium.api.model.request.UserAuthenticationRequest;
import com.morphosium.api.model.response.JwtTokenResponse;
import com.morphosium.api.repository.UserRepository;
import com.morphosium.api.service.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Objects;
import java.util.Optional;

@Slf4j
@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final AuthenticationManager authenticationManager;
    private final JwtTokenUtil jwtTokenUtil;
    private final UserDetailsService jwtUserDetailsService;
    private final UserRepository userRepository;
    private final BCryptPasswordEncoder bCryptPasswordEncoder;

    @Transactional
    @Override
    public GenericResponse<?> authenticate(UserAuthenticationRequest request) {
        String username = request.getUsername();
        String password = request.getPassword();
        Optional<User> userOptional = userRepository.findByUsername(username);
        if (!userOptional.isPresent()) {
            log.info("Authentication create token username: " + username + " => not found");
            return GenericResponse.error(FailureEnums.INVALID_CREDENTIALS.getMessage());
        }
        User user = userOptional.get();
        if (!bCryptPasswordEncoder.matches(password, user.getPassword()))
            return GenericResponse.error(FailureEnums.INVALID_CREDENTIALS.getMessage());
        authenticate(request.getUsername(), request.getPassword());
        final UserDetails userDetails = jwtUserDetailsService.loadUserByUsername(request.getUsername());

        final String token = jwtTokenUtil.generateToken(userDetails);
        user.setToken(token);
        userRepository.save(user);
        return GenericResponse.ok(new JwtTokenResponse(token));
    }

    private void authenticate(String email, String password) {
        Objects.requireNonNull(email);
        Objects.requireNonNull(password);

        try {
            authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(email, password));
        } catch (DisabledException e) {
            throw new AuthenticationException("USER_DISABLED", e);
        } catch (BadCredentialsException e) {
            throw new AuthenticationException("INVALID_CREDENTIALS", e);
        }
    }
}
