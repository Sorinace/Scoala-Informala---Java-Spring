package ro.sorinace.sicj.security;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import ro.sorinace.sicj.model.AuthGroup;
import ro.sorinace.sicj.model.Username;

import java.util.*;

/**
 * @author Sorin created on 3/31/2020
 */
public class UsernamePrincipal implements UserDetails {
    private Username username;
    private List<AuthGroup> authGroups;

    public UsernamePrincipal(Username username, List<AuthGroup> authGroups){
        super();
        this.username = username;
        this. authGroups = authGroups;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        if(authGroups == null){
            return Collections.emptySet();
        }
        Set<SimpleGrantedAuthority> simpleGrantedAuthoritySet= new HashSet<>();
        authGroups.forEach(group->{
            simpleGrantedAuthoritySet.add(new SimpleGrantedAuthority(group.getAuth_group()));
        });
        return simpleGrantedAuthoritySet;
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
