package ro.sorinace.sicj.dao.db;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import ro.sorinace.sicj.model.Feedback;
import ro.sorinace.sicj.model.Speakers;

/**
 * <S extends T> S save(S entity): Saves and updates the current entity and returns that entity.
 * Optional<T> findById(ID primaryKey): Returns the entity for the given id.
 * Iterable<T> findAll(): Returns all entities.
 * long count(): Returns the count.
 * void delete(T entity): Deletes the given entity.
 * boolean existsById(ID primaryKey): Checks if the entity for the given id exists or not.
 */
public interface SpeakersDBI extends CrudRepository<Speakers, Long> {
    /**
     * @author Sorin
     * @param shortname for the speaker
     * @return the speaker with the that shortname
     */
    @Query("SELECT speaker FROM Speakers speaker WHERE speaker.shortname = ?1")
    Speakers findByName(String shortname);
}
