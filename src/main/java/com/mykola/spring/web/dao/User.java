package com.mykola.spring.web.dao;

/**
 * Created by M on 27.04.2017.
 */
public class User {
    private String username;
    private String password;
    private boolean enabled = false;
    private String authority;

    public User() {

    }

    public User(String username, String password, boolean enabled, String authority) {
        this.username = username;
        this.password = password;
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
}
