package com.morphosium.api.controller;


import com.morphosium.api.controller.endpoint.AccountEndpoint;
import com.morphosium.api.model.GenericResponse;
import com.morphosium.api.model.request.UserAuthenticationRequest;
import com.morphosium.api.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class AccountController {

    private final UserService userService;

    @Transactional
    @PostMapping(value = AccountEndpoint.AUTHENTICATION)
    public GenericResponse<?> authentication(@RequestBody UserAuthenticationRequest request) {
        return userService.authenticate(request);
    }
}
