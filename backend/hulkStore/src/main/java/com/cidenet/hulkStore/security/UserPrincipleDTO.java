package com.cidenet.hulkStore.security;

import com.cidenet.hulkStore.entities.UsersDTO;
import com.fasterxml.jackson.annotation.JsonIgnore;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.io.Serializable;
import java.util.Collection;

public class UserPrincipleDTO implements UserDetails, Serializable {

    private static final long serialVersionUID = 813793535224893660L;

    private int id;

    private int type;

    private int subCount;

    private String username;

    @JsonIgnore
    private String password;

    public UserPrincipleDTO(int id, int type, String username, String password) {
        this.id = id;
        this.type = type;
        this.username = username;
        this.password = password;
    }

    public UserPrincipleDTO(int id, String username, String password) {
        this.id = id;
        this.username = username;
        this.password = password;
    }

    public static UserPrincipleDTO build(UsersDTO user) {
        return new UserPrincipleDTO(user.getUser_id(), user.getUser_type(), user.getEmail(), user.getPassword());
    }

    public int getId() {
        return id;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public int getSubCount() {
        return subCount;
    }

    public void setSubCount(int subCount) {
        this.subCount = subCount;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return null;
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public String getUsername() {
        return username;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}
