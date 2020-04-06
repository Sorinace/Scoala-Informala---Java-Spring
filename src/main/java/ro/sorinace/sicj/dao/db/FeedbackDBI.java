package ro.sorinace.sicj.dao.db;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import ro.sorinace.sicj.model.Feedback;

import javax.transaction.Transactional;


/**
 * @Author Sorin
 * Connection for the "feedback" table in the DB
 */
public interface FeedbackDBI extends CrudRepository<Feedback, Long> {
    /**
     * Change the visibility of the feedback
     * @param id is the id of the selected feedback
     * @param visible is the visibility (true - visible, false - hided)
     */
    @Transactional
    @Modifying
    @Query("UPDATE Feedback feedback SET visible = ?2 WHERE feedback.id = ?1")
    void visibleFeedback(Long id, Boolean visible);

    /**
     * Update / change the selected feedback
     * @param id is the id of the selected feedback
     * @param name is the client name of the selected feedback
     * @param email is the e-mail of the selected feedback
     * @param title is the title of the selected feedback
     * @param message is the message of the selected feedback
     */
    @Transactional
    @Modifying
    @Query("UPDATE Feedback feedback SET name = ?2, email = ?3, title = ?4, message = ?5 WHERE feedback.id = ?1")
    void updateFeedback(Long id, String name, String email, String title, String message);
}
