package com.morphosium.api.service;

import com.morphosium.api.config.jwt.exception.AuthenticationException;
import com.morphosium.api.model.GenericResponse;
import com.morphosium.api.model.request.UserAuthenticationRequest;

public interface UserService {
    GenericResponse authenticate(UserAuthenticationRequest request)  throws AuthenticationException;
}
