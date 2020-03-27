package ro.sorinace.sicj.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ro.sorinace.sicj.dao.db.FeedbackDBI;
import ro.sorinace.sicj.model.Feedback;

import java.util.ArrayList;
import java.util.List;

@Service
public class FeedbackService {


        @Autowired
        private FeedbackDBI feedbackCBI;

        public List<Feedback> findAll() {

            ArrayList<Feedback>  it = (ArrayList<Feedback>) feedbackCBI.findAll();

//            ArrayList<Feedback> feedback = new ArrayList<>();
//            it.forEach(e -> feedback.add(e));

            return it;
        }

        public Long count() {

            return feedbackCBI.count();
        }

        public void deleteById(Long userId) {

            feedbackCBI.deleteById(userId);
        }
}
