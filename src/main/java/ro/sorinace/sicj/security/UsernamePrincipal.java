package ro.sorinace.sicj.security;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import ro.sorinace.sicj.model.Username;

import java.util.Collection;
import java.util.Collections;

/**
 * @author Sorin created on 3/31/2020
 */
public class UsernamePrincipal implements UserDetails {
    private Username username;

    public UsernamePrincipal(Username username){
        super();
        this.username = username;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return Collections.singleton(new SimpleGrantedAuthority("username"));
    }

    @Override
    public String getPassword() {
        return this.username.getPassword();
    }

    @Override
    public String getUsername() {
        return this.username.getUsername();
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
