package ro.sorinace.sicj.security;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import ro.sorinace.sicj.dao.db.AuthGroupDBI;
import ro.sorinace.sicj.dao.db.UsernameDBI;
import ro.sorinace.sicj.model.AuthGroup;
import ro.sorinace.sicj.model.Username;
import ro.sorinace.sicj.security.UsernamePrincipal;

import java.util.List;

/**
 * @author Sorin created on 3/31/2020
 */
@Service
public class UsernameServices implements UserDetailsService {
    private final UsernameDBI usernameDBI;
    private final AuthGroupDBI authGroup;

    public UsernameServices(UsernameDBI usernameDBI, AuthGroupDBI authGroup){
        super();
        this.usernameDBI = usernameDBI;
        this.authGroup = authGroup;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Username user = this.usernameDBI.findByUsername(username);

        if (null == user){
            throw new UsernameNotFoundException("Cannot find username : " + username);
        }
        List<AuthGroup> authGroups = this.authGroup.findByUsername(username);

        return new UsernamePrincipal(user, authGroups);
    }
}
