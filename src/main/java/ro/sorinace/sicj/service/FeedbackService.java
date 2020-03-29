package ro.sorinace.sicj.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ro.sorinace.sicj.dao.db.FeedbackDBI;
import ro.sorinace.sicj.model.Feedback;

import java.util.ArrayList;

@Service
public class FeedbackService {


        @Autowired
        private FeedbackDBI feedbackCBI;

        public ArrayList<Feedback> findAll() {

            return (ArrayList<Feedback>) feedbackCBI.findAll();
        }

        public Long count() {

            return feedbackCBI.count();
        }

        public void deleteById(Long userId) {

            feedbackCBI.deleteById(userId);
        }
}
