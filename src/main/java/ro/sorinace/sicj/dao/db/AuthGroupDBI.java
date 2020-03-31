package ro.sorinace.sicj.dao.db;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import ro.sorinace.sicj.model.AuthGroup;


import java.util.List;

public interface AuthGroupDBI extends CrudRepository<AuthGroup, Long> {
    @Query("SELECT authGroup FROM AuthGroup authGroup WHERE authGroup.username = ?1")
    List<AuthGroup> findByUsername(String username);
}
