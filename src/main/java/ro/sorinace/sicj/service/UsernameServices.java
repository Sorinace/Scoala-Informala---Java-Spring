package ro.sorinace.sicj.service;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import ro.sorinace.sicj.dao.db.UsernameDBI;
import ro.sorinace.sicj.model.Username;
import ro.sorinace.sicj.security.UsernamePrincipal;

/**
 * @author Sorin created on 3/31/2020
 */
@Service
public class UsernameServices implements UserDetailsService {
    private final UsernameDBI usernameDBI;

    public UsernameServices(UsernameDBI usernameDBI){
        super();
        this.usernameDBI = usernameDBI;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Username user = this.usernameDBI.findByUsername(username);
        if (null == user){
            throw new UsernameNotFoundException("Cannot find username : " + username);
        }
        return new UsernamePrincipal(user);
    }
}
