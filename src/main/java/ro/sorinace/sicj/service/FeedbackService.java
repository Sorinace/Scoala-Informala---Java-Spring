package ro.sorinace.sicj.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ro.sorinace.sicj.dao.db.FeedbackDBI;
import ro.sorinace.sicj.model.Feedback;

import java.util.ArrayList;

@Service
public class FeedbackService {


        @Autowired
        private FeedbackDBI feedbackDBI;

        public ArrayList<Feedback> findAll() {

            return (ArrayList<Feedback>) feedbackDBI.findAll();
        }

        public Long count() {

            return feedbackDBI.count();
        }

        public void deleteById(Long userId) {

            feedbackDBI.deleteById(userId);
        }
}
