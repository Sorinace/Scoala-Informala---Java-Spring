package ro.sorinace.sicj.dao.db;

import org.springframework.data.repository.CrudRepository;
import ro.sorinace.sicj.model.Speakers;

        /** @Author Sorin
        * Connection for the "speakers" table in the DB
        */
public interface SpeakersDBI extends CrudRepository<Speakers, Long> {

}
