package com.example.compta.SecurityConfig;

import com.example.compta.Entities.Comptable;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Arrays;
import java.util.Collection;

public class MyUserDetails implements UserDetails {
    private Comptable comptable;
    public MyUserDetails(Comptable comptable){
        this.comptable=comptable;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        SimpleGrantedAuthority authority = new SimpleGrantedAuthority("ADMIN");
        return Arrays.asList(authority);
    }

    @Override
    public String getPassword() {
        return comptable.getPasswd();
    }

    @Override
    public String getUsername() {
        return comptable.getEmail();
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
