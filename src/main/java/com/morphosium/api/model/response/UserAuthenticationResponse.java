package com.morphosium.api.model.response;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserAuthenticationResponse {
    private static final long serialVersionUID = 2360650378188204337L;
    private long id;
    private String name;
    private String surname;
    private String token;
    private String email;
}