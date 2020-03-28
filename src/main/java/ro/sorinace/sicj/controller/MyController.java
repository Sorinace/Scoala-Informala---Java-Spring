package ro.sorinace.sicj.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import ro.sorinace.sicj.dao.db.FeedbackDBI;
import ro.sorinace.sicj.dao.db.SpeakersDBI;
import ro.sorinace.sicj.model.Speakers;

import java.util.ArrayList;
import java.util.HashMap;

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
    private FeedbackDBI feedbackCBI;

    @RequestMapping
    public String rootMapping (Model model)  {

        model.addAttribute("speakers", speakersDBI.findAll());
        model.addAttribute("title", "Roux - Main page");
        return "index";
    }

    @RequestMapping(value = "/speakers", method = RequestMethod.GET)
    public String speakerMapping(Model model)  {

        model.addAttribute("speakers", speakersDBI.findAll());
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

    @RequestMapping(value = "/speakers/{name}", method = RequestMethod.GET)
    public String speakerMapping(Model model, @PathVariable String name)  {

        for (Speakers artist: speakersDBI.findAll()) {
            if (artist.getShortname().equals(name)){
                model.addAttribute("speaker", artist);
            }
        }

        model.addAttribute("speakers", speakersDBI.findAll());
        model.addAttribute("title", "Roux - " + name);
        return "speaker";
    }


}