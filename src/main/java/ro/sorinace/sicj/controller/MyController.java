package ro.sorinace.sicj.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ro.sorinace.sicj.dao.db.ArtworkDBI;
import ro.sorinace.sicj.dao.db.FeedbackDBI;
import ro.sorinace.sicj.dao.db.SpeakersDBI;
import ro.sorinace.sicj.model.Feedback;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;

@Controller
@RequestMapping("/")
public class MyController implements ErrorController {
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

    private static final String PATH = "/error";

    @Override
    public String getErrorPath() {
        return PATH;
    }

    @RequestMapping(value = PATH)
    public String errorPage(Model model, HttpServletRequest request) {
        Object status = request.getAttribute(RequestDispatcher.ERROR_STATUS_CODE);
        model.addAttribute("speakers", speakersDBI.findAll());
        model.addAttribute("message", "Request ERROR:");
        model.addAttribute("title", "Roux - ERROR");

        if (status != null) {
            Integer statusCode = Integer.valueOf(status.toString());

            if(statusCode == HttpStatus.NOT_FOUND.value()) {
                model.addAttribute("error", "Page request was not found: error-404");
            }
            else if(statusCode == HttpStatus.INTERNAL_SERVER_ERROR.value()) {
                model.addAttribute("error", "Server don't respond: error-500");
            }
            else if(statusCode == HttpStatus.FORBIDDEN.value()) {
                model.addAttribute("feedback", feedbackDBI.findAll());
                model.addAttribute("error", "You have no right for this action.<br/>Please contact the administrator! ");
                return "feedback";
            }
            else{
                model.addAttribute("error", "General error: " + status.toString());
            }

        }

        model.addAttribute("admin", isAdmin());
        model.addAttribute("speakers", speakersDBI.findAll());
        return "error";
    }

    @RequestMapping
    public String rootMapping (Model model)  {

        model.addAttribute("admin", isAdmin());
        model.addAttribute("speakers", speakersDBI.findAll());
        model.addAttribute("artworks", artworkDBI.findAll());
        model.addAttribute("title", "Roux - Main page");
        return "index";
    }

    @RequestMapping("/login")
    public String getLoginPages(Model model){

        model.addAttribute("admin", isAdmin());
        model.addAttribute("speakers", speakersDBI.findAll());
        model.addAttribute("title", "Roux - Login");
        return "login";
    }

    @RequestMapping("/logout-success")
    public String getLogoutPages(Model model){

        model.addAttribute("admin", isAdmin());
        model.addAttribute("speakers", speakersDBI.findAll());
        model.addAttribute("title", "Roux - Logout");
        return "logout";
    }

    @RequestMapping(value = "/speakers", method = RequestMethod.GET)
    public String speakerMapping(Model model)  {

        model.addAttribute("admin", isAdmin());
        model.addAttribute("speakers", speakersDBI.findAll());
        model.addAttribute("artworks", artworkDBI.findAll());
        model.addAttribute("title", "Roux - Speakers");
        return "speakers";
    }

    @RequestMapping(value = "/speakers/{id}", method = RequestMethod.GET)
    public String speakerMapping(Model model, @PathVariable Long id)  {

        model.addAttribute("admin", isAdmin());
        model.addAttribute("artworks", artworkDBI.findBySpeakerId(id));
        model.addAttribute("speaker", speakersDBI.findById(id).get());
        model.addAttribute("speakers", speakersDBI.findAll());
        model.addAttribute("title", "Roux - artist");
        return "speaker";
    }

    @GetMapping(value = "/feedback")
    public String feedbackMapping(Model model)  {
        Feedback feedback_form = new Feedback();

        model.addAttribute("admin", isAdmin());
        model.addAttribute("feedback_form", feedback_form);
        model.addAttribute("speakers", speakersDBI.findAll());
        model.addAttribute("feedback", feedbackDBI.findAll());
        model.addAttribute("title", "Roux - Feedback");
        model.addAttribute("message", "Send feedback:");

        return "feedback";
    }

    @PostMapping("/feedback")
    public String addFeedback(Feedback feedback_form, Model model) {
        ArrayList<String> errors = feedback_form.check();
        if (errors.size() == 0) {
            feedback_form.setVisible(false);
            feedbackDBI.save(feedback_form);
            feedback_form = new Feedback();
        }

        model.addAttribute("admin", isAdmin());
        model.addAttribute("errors", errors);
        model.addAttribute("feedback_form", feedback_form);
        model.addAttribute("speakers", speakersDBI.findAll());
        model.addAttribute("feedback", feedbackDBI.findAll());
        model.addAttribute("title", "Roux - Feedback response");
        model.addAttribute("message", "Thank you for feedback!");

        return "feedback";
    }


    @RequestMapping("/publish/{id}/{visible}")
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public String publishFeedback(@PathVariable("id") Long id, @PathVariable("visible") boolean visible, Model model) {
        Feedback feedback_form = new Feedback();
        feedbackDBI.visibleFeedback(id, visible);

        model.addAttribute("admin", isAdmin());
        model.addAttribute("feedback_form", feedback_form);
        model.addAttribute("speakers", speakersDBI.findAll());
        model.addAttribute("feedback", feedbackDBI.findAll());
        model.addAttribute("title", "Roux - Feedback publish");
        model.addAttribute("message", "Change the visibility!");
        return "feedback";
    }

    @RequestMapping("/update/{id}")
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public String updateRequestFeedback(Feedback feedback_form, Model model, @PathVariable Long id) {

        model.addAttribute("admin", isAdmin());
        model.addAttribute("feedback_form", feedback_form);
        model.addAttribute("feedback_update", feedbackDBI.findById(id).get());
        model.addAttribute("speakers", speakersDBI.findAll());
        model.addAttribute("feedback", feedbackDBI.findAll());
        model.addAttribute("title", "Roux - Feedback update request");
        model.addAttribute("message", "Change the message:");
        return "feedback";
    }

    @PostMapping("/update/{id}")
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public String updateFeedback(Feedback feedback_form, Model model, @PathVariable Long id) {
        ArrayList<String> errors = feedback_form.check();
        if (errors.size() == 0){
            feedbackDBI.updateFeedback(id, feedback_form.getName(), feedback_form.getEmail(), feedback_form.getTitle(), feedback_form.getMessage());
            feedback_form = new Feedback();
        }
        else
            model.addAttribute("feedback_update", feedback_form);

        model.addAttribute("admin", isAdmin());
        model.addAttribute("errors", errors);
        model.addAttribute("feedback_form", feedback_form);
        model.addAttribute("speakers", speakersDBI.findAll());
        model.addAttribute("feedback", feedbackDBI.findAll());
        model.addAttribute("title", "Roux - Feedback update");
        model.addAttribute("message", "Message updated!");
        return "feedback";
    }

    @RequestMapping("/delete/{id}")
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public String deleteFeedback(Model model, @PathVariable Long id) {
        Feedback feedback_form = new Feedback();
        feedbackDBI.delete(feedbackDBI.findById(id).get());

        model.addAttribute("admin", isAdmin());
        model.addAttribute("feedback_form", feedback_form);
        model.addAttribute("message", "Message deleted!");
        model.addAttribute("speakers", speakersDBI.findAll());
        model.addAttribute("feedback", feedbackDBI.findAll());
        model.addAttribute("title", "Roux - Feedback deleted!");

        return "feedback";
    }


    private Boolean isAdmin(){
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();

        boolean hasAdminRole = authentication.getAuthorities().stream()
                .anyMatch(r -> r.getAuthority().equals("ROLE_ADMIN"));
        return hasAdminRole;
    };
}