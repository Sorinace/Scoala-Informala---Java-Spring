package ro.sorinace.sicj.dao.db;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import ro.sorinace.sicj.model.Username;

/** @Author Sorin
 * Connection for the "username" table in the DB
 */
public interface UsernameDBI extends CrudRepository<Username, Long> {
    @Query("SELECT username FROM Username username WHERE username.username = ?1")
    Username findByUsername(String username);
}
