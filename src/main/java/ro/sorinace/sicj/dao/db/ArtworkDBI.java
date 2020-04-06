package ro.sorinace.sicj.dao.db;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import ro.sorinace.sicj.model.Artwork;

import java.util.ArrayList;

/**
 * @Author Sorin
 *
 * CrudRepository<T, ID>
 * <S extends T> S save(S entity): Saves and updates the current entity and returns that entity.
 * Optional<T> findById(ID primaryKey): Returns the entity for the given id.
 * Iterable<T> findAll(): Returns all entities.
 * long count(): Returns the count.
 * void delete(T entity): Deletes the given entity.
 * boolean existsById(ID primaryKey): Checks if the entity for the given id exists or not.
 */
public interface ArtworkDBI extends CrudRepository<Artwork, Long> {

    /**
     * @param id for the request speaker artworks
     * @return all the artwork which are made by the speaker with this id
     */
    @Query("SELECT artwork FROM Artwork artwork WHERE artwork.speaker_id = ?1")
    ArrayList<Artwork> findBySpeakerId(Long id);
}
