package com.daltonkyemiller.daltonkyemillerapi.user.model;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.validation.constraints.NotNull;
import java.util.Collection;
import java.util.Objects;
import java.util.Set;

@Data
@Document
public class User implements UserDetails {
    @Id
    private final String id;

    @NotNull
    @Indexed(unique = true)
    private final String username;

    @NotNull
    private final String password;

    private final Set<? extends GrantedAuthority> grantedAuthorities;

    private final boolean isAccountNonExpired;
    private final boolean isAccountNonLocked;
    private final boolean isCredentialsNonExpired;
    private final boolean isEnabled;

    public User(
            String id, String username,
            String password,
            Set<? extends GrantedAuthority> grantedAuthorities,
            boolean isAccountNonExpired,
            boolean isAccountNonLocked,
            boolean isCredentialsNonExpired,
            boolean isEnabled) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.grantedAuthorities =
                Objects.requireNonNullElseGet(grantedAuthorities, UserRole.DEFAULT::getGrantedAuthorities);
        this.isAccountNonExpired = isAccountNonExpired;
        this.isAccountNonLocked = isAccountNonLocked;
        this.isCredentialsNonExpired = isCredentialsNonExpired;
        this.isEnabled = isEnabled;
    }


    @Override
    public String getUsername() {
        return username;
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {return grantedAuthorities;}


    @Override
    public boolean isAccountNonExpired() {
        return isAccountNonExpired;
    }

    @Override
    public boolean isAccountNonLocked() {
        return isAccountNonLocked;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return isCredentialsNonExpired;
    }

    @Override
    public boolean isEnabled() {
        return isEnabled;
    }
}
