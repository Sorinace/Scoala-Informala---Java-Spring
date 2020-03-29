package ro.sorinace.sicj.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import ro.sorinace.sicj.dao.db.ArtworkDBI;
import ro.sorinace.sicj.dao.db.SpeakersDBI;
import ro.sorinace.sicj.model.Speakers;
import ro.sorinace.sicj.service.FeedbackService;

@Controller
@RequestMapping("/")
public class MyController {
//    /**
//     * read speakers data from file speakers.json
//     */
//    @Autowired
//    private ArrayList<HashMap> getSpeakersFile;
//    /**
//     * read feedback data from file feedback.json
//     */
//    @Autowired
//    private ArrayList<HashMap> getFeedbackFile;

    /**
     * read speakers data from DB
     */
    @Autowired
    private SpeakersDBI speakersDBI;
    /**
     * read feedback data from DB
     */
    @Autowired
    private FeedbackService feedbackCBI;

    @Autowired
    private ArtworkDBI artworkDBI;

    @RequestMapping
    public String rootMapping (Model model)  {

        model.addAttribute("speakers", speakersDBI.findAll());
        model.addAttribute("artworks", artworkDBI.findAll());
        model.addAttribute("title", "Roux - Main page");
        return "index";
    }

    @RequestMapping(value = "/speakers", method = RequestMethod.GET)
    public String speakerMapping(Model model)  {

        model.addAttribute("speakers", speakersDBI.findAll());
        model.addAttribute("artworks", artworkDBI.findAll());
        model.addAttribute("title", "Roux - Speakers");
        return "speakers";
    }

    @RequestMapping(value = "/feedback", method = RequestMethod.GET)
    public String feedbackMapping(Model model)  {

        model.addAttribute("speakers", speakersDBI.findAll());
        model.addAttribute("feedback", feedbackCBI.findAll());
        model.addAttribute("title", "Roux - Feedback");
        return "feedback";
    }

    @RequestMapping(value = "/speakers/{id}", method = RequestMethod.GET)
    public String speakerMapping(Model model, @PathVariable Long id)  {

        model.addAttribute("artworks", artworkDBI.findBySpeakerId(id));
        model.addAttribute("speaker", speakersDBI.findById(id).get());
        model.addAttribute("speakers", speakersDBI.findAll());
        model.addAttribute("title", "Roux - artist");
        return "speaker";
    }
}