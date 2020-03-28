package ro.sorinace.sicj.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ro.sorinace.sicj.dao.db.FeedbackDBI;
import ro.sorinace.sicj.dao.db.SpeakersDBI;
import ro.sorinace.sicj.model.Feedback;
import ro.sorinace.sicj.model.Speakers;

import java.util.ArrayList;
import java.util.List;

@Service
public class SpeakersService {


        @Autowired
        private SpeakersDBI speakersDBI;

        public List<Speakers> findAll() {
            ArrayList<Speakers>  it = (ArrayList<Speakers>) speakersDBI.findAll();
            return it;
        }

        public Long count() {

            return speakersDBI.count();
        }

        public void deleteById(Long userId) {

            speakersDBI.deleteById(userId);
        }
}
