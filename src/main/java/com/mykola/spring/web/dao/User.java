package com.mykola.spring.web.dao;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotBlank;
import org.springframework.stereotype.Component;

import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

/**
 * Created by M on 27.04.2017.
 */
public class User {
    @NotBlank
    @Size(min = 2, max = 15)
    @Pattern(regexp = "^\\w{2,}$")
    private String username;

    @NotBlank
    @Pattern(regexp = "^\\S+$")
    @Size(min = 2, max = 15)
    private String password;

    @Email
    private String email;
    private boolean enabled = false;
    private String authority;

    public User() {

    }

    public User(String username, String password, String email, boolean enabled, String authority) {
        this.username = username;
        this.password = password;
        this.email = email;
        this.enabled = enabled;
        this.authority = authority;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public boolean isEnabled() {
        return enabled;
    }

    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getAuthority() {
        return authority;
    }

    public void setAuthority(String authority) {
        this.authority = authority;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
