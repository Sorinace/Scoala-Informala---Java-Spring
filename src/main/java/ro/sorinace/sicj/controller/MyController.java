package ro.sorinace.sicj.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ro.sorinace.sicj.dao.db.ArtworkDBI;
import ro.sorinace.sicj.dao.db.FeedbackDBI;
import ro.sorinace.sicj.dao.db.SpeakersDBI;
import ro.sorinace.sicj.model.Feedback;

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
    private FeedbackDBI feedbackDBI;

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

    @RequestMapping(value = "/speakers/{id}", method = RequestMethod.GET)
    public String speakerMapping(Model model, @PathVariable Long id)  {

        model.addAttribute("artworks", artworkDBI.findBySpeakerId(id));
        model.addAttribute("speaker", speakersDBI.findById(id).get());
        model.addAttribute("speakers", speakersDBI.findAll());
        model.addAttribute("title", "Roux - artist");
        return "speaker";
    }

    @GetMapping(value = "/feedback")
    public String feedbackMapping(Model model)  {

        model.addAttribute("speakers", speakersDBI.findAll());
        model.addAttribute("feedback", feedbackDBI.findAll());
        model.addAttribute("title", "Roux - Feedback");
        model.addAttribute("message", "Send feedback:");
        return "feedback";
    }

    @PostMapping("/feedback")
    public String addFeedback(Feedback feedback_form, Model model) {

        feedback_form.setVisible(false);
        feedbackDBI.save(feedback_form);

        model.addAttribute("feedback_form", feedback_form);
        model.addAttribute("speakers", speakersDBI.findAll());
        model.addAttribute("feedback", feedbackDBI.findAll());
        model.addAttribute("title", "Roux - Feedback response");
        model.addAttribute("message", "Thank you for feedback!");

        return "feedback";
    }

    @RequestMapping("/delete/{id}")
    public String deleteFeedback(Model model, @PathVariable Long id) {
        feedbackDBI.delete(feedbackDBI.findById(id).get());

        model.addAttribute("message", "Message deleted!");
        model.addAttribute("speakers", speakersDBI.findAll());
        model.addAttribute("feedback", feedbackDBI.findAll());
        model.addAttribute("title", "Roux - Feedback deleted!");

        return "feedback";
    }

    @RequestMapping("/publish/{id}/{visible}")
    public String publishFeedback(@PathVariable("id") Long id, @PathVariable("visible") boolean visible, Model model) {
        feedbackDBI.visibleFeedback(id, visible);

        model.addAttribute("speakers", speakersDBI.findAll());
        model.addAttribute("feedback", feedbackDBI.findAll());
        model.addAttribute("title", "Roux - Feedback publish");
        model.addAttribute("message", "Change the visibility!");
        return "feedback";
    }

    @RequestMapping("/update/{id}")
    public String updateRequestFeedback(Feedback feedback_form, Model model, @PathVariable Long id) {

        model.addAttribute("feedback_form", feedback_form);
        model.addAttribute("feedback_update", feedbackDBI.findById(id).get());
        model.addAttribute("speakers", speakersDBI.findAll());
        model.addAttribute("feedback", feedbackDBI.findAll());
        model.addAttribute("title", "Roux - Feedback update request");
        model.addAttribute("message", "Change the message:");
        return "feedback";
    }

    @PostMapping("/update/{id}")
    public String updateFeedback(Feedback feedback_form, Model model, @PathVariable Long id) {
        feedbackDBI.updateFeedback(id, feedback_form.getName(), feedback_form.getEmail(), feedback_form.getTitle(), feedback_form.getMessage());

        model.addAttribute("feedback_form", feedback_form);
        model.addAttribute("speakers", speakersDBI.findAll());
        model.addAttribute("feedback", feedbackDBI.findAll());
        model.addAttribute("title", "Roux - Feedback update");
        model.addAttribute("message", "Message updated!");
        return "feedback";
    }
}