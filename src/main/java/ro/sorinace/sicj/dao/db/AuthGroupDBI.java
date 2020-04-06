package ro.sorinace.sicj.dao.db;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import ro.sorinace.sicj.model.AuthGroup;


import java.util.List;

/**
 * @Author Sorin
 * Connection for the AuthGroup DB
 */
public interface AuthGroupDBI extends CrudRepository<AuthGroup, Long> {
    /**
     * Get the role for the "username" user
     * @param username the name of the user
     * @return the role from DB
     */
    @Query("SELECT authGroup FROM AuthGroup authGroup WHERE authGroup.username = ?1")
    List<AuthGroup> findByUsername(String username);
}
