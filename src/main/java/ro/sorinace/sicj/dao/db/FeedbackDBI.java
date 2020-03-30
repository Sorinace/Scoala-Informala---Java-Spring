package ro.sorinace.sicj.dao.db;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import ro.sorinace.sicj.model.Feedback;

import javax.transaction.Transactional;


/**
 * CrudRepository library
 * <S extends T> S save(S entity): Saves and updates the current entity and returns that entity.
 * Optional<T> findById(ID primaryKey): Returns the entity for the given id.
 * Iterable<T> findAll(): Returns all entities.
 * long count(): Returns the count.
 * void delete(T entity): Deletes the given entity.
 * boolean existsById(ID primaryKey): Checks if the entity for the given id exists or not.
 */
public interface FeedbackDBI extends CrudRepository<Feedback, Long> {
    /**
     * @author Sorin
     * @param id for the feedback
     */
    @Transactional
    @Modifying
    @Query("UPDATE Feedback feedback SET visible = TRUE WHERE feedback.id = ?1")
    void publishFeedback(Long id);

    /**
     * @author Sorin
     * @param id for the feedback
     */
    @Transactional
    @Modifying
    @Query("UPDATE Feedback feedback SET name = ?2, email = ?3, title = ?4, message = ?5 WHERE feedback.id = ?1")
    void updateFeedback(Long id, String name, String email, String title, String message);
}
