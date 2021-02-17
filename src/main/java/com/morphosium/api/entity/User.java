package com.morphosium.api.entity;

import com.morphosium.api.entity.base.BaseEntity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Getter
@Setter
@Entity
@Table(name = "users")
@NoArgsConstructor
@AllArgsConstructor
public class User extends BaseEntity {

    private static final long serialVersionUID = -6069416998571340540L;

    private String name;
    private String surname;

    private String email;

    private String username;

    @NotNull
    private String password;


    private String about;

    private boolean enabled;

    private boolean accountNonExpired = true;
    private boolean accountNonLocked = true;
    private boolean credentialsNonExpired = true;

    @Column(columnDefinition = "text", length = 10485760)
    private String token;

}
