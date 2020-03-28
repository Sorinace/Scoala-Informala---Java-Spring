package ro.sorinace.sicj.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ro.sorinace.sicj.dao.db.ArtworkDBI;
import ro.sorinace.sicj.dao.db.FeedbackDBI;
import ro.sorinace.sicj.model.Artwork;
import ro.sorinace.sicj.model.Feedback;

import java.util.ArrayList;
import java.util.List;

@Service
public class ArtworkService {


        @Autowired
        private ArtworkDBI artworkCBI;

        public List<Artwork> findAll() {
            ArrayList<Artwork>  it = (ArrayList<Artwork>) artworkCBI.findAll();
            return it;
        }

        public Long count() {

            return artworkCBI.count();
        }

        public void deleteById(Long userId) {

            artworkCBI.deleteById(userId);
        }
}
