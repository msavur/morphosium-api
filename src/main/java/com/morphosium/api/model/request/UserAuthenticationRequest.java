package com.morphosium.api.model.request;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import java.io.Serializable;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class UserAuthenticationRequest implements Serializable {

    private static final long serialVersionUID = 6576954542237019446L;

    @NotBlank
    @Email
    private String username;
    @NotBlank
    private String password;

}
