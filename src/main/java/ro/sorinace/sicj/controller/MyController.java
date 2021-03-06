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

/**
 * @author Sorin
 * In this class we setup the path for different locations and get the permission for the WEB page
 */
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

    /**
     * read artwork data from DB
     */
    @Autowired
    private ArtworkDBI artworkDBI;

    /**
     * Override the implicit error page location /file
     */
    private static final String PATH = "/error";

    @Override
    public String getErrorPath() {
        return PATH;
    }

    /**
     *  Mapping the new location of the error page, where will be send errors
     *  Also separate the main error (404, 500 etc.) and add an clear error message
     * @param model data to be sent to the randed page
     * @param request get the error generated
     * @return the name of the mapped page (error.ftl) for error handling
     */

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

    /**
     * Mapping for the root path of the WEB
     * @param model data to be sent to the randed page:
     * - attribute: admin is boolean, and tell us the privilege of the user
     * - attribute: speakers send all the speakers from DB
     * - attribute: artwork send all the artworks fom DB
     * - attribute: title is the title of the randed page
     * @return the name of the mapped page (index.ftl)
     */
    @RequestMapping
    public String rootMapping (Model model)  {

        model.addAttribute("admin", isAdmin());
        model.addAttribute("speakers", speakersDBI.findAll());
        model.addAttribute("artworks", artworkDBI.findAll());
        model.addAttribute("title", "Roux - Main page");
        return "index";
    }

    /**
     * Mapping for the /login path of the WEB when we receive a GET request
     * @param model data to be sent to the randed page:
     * - attribute: admin is boolean, and tell us the privilege of the user
     * - attribute: speakers send all the speakers from DB
     * - attribute: title is the title of the randed page
     * @return the name of the mapped page (login.ftl)
     */
    @RequestMapping("/login")
    public String getLoginPages(Model model){

        model.addAttribute("admin", isAdmin());
        model.addAttribute("speakers", speakersDBI.findAll());
        model.addAttribute("title", "Roux - Login");
        return "login";
    }

    /**
     * Mapping for the /logout-success path of the WEB when we receive a GET request
     * @param model data to be sent to the randed page:
     * - attribute: admin is boolean, and tell us the privilege of the user
     * - attribute: speakers send all the speakers from DB
     * - attribute: title is the title of the randed page
     * @return the name of the mapped page (logout.ftl)
     */
    @RequestMapping("/logout-success")
    public String getLogoutPages(Model model){

        model.addAttribute("admin", isAdmin());
        model.addAttribute("speakers", speakersDBI.findAll());
        model.addAttribute("title", "Roux - Logout");
        return "logout";
    }

    /**
     * Mapping for the /speakers path of the WEB when we receive a GET request
     * @param model data to be sent to the randed page:
     * - attribute: admin is boolean, and tell us the privilege of the user
     * - attribute: speakers send all the speakers from DB
     * - attribute: artwork send all the artworks fom DB
     * - attribute: title is the title of the randed page
     * @return the name of the mapped page (speakers.ftl)
     */
    @RequestMapping(value = "/speakers", method = RequestMethod.GET)
    public String speakerMapping(Model model)  {

        model.addAttribute("admin", isAdmin());
        model.addAttribute("speakers", speakersDBI.findAll());
        model.addAttribute("artworks", artworkDBI.findAll());
        model.addAttribute("title", "Roux - Speakers");
        return "speakers";
    }

    /**
     * Mapping for the /speakers/id path of the WEB, the page of the speaker when we receive a GET request
     * @param id is the ID from DB of the selected speaker
     * @param model data to be sent to the randed page:
     * - attribute: admin is boolean, and tell us the privilege of the user
     * - attribute: speakers send all the speakers from DB
     * - attribute: speker send the data of the speaker with the specific ID
     * - attribute: artwork send all the artworks fom DB
     * - attribute: title is the title of the randed page
     * @return the name of the mapped page (speaker.ftl)
     */
    @RequestMapping(value = "/speakers/{id}", method = RequestMethod.GET)
    public String speakerMapping(Model model, @PathVariable Long id)  {

        model.addAttribute("admin", isAdmin());
        model.addAttribute("artworks", artworkDBI.findBySpeakerId(id));
        model.addAttribute("speaker", speakersDBI.findById(id).get());
        model.addAttribute("speakers", speakersDBI.findAll());
        model.addAttribute("title", "Roux - artist");
        return "speaker";
    }

    /**
     * Mapping for the /feedback path of the WEB when we receive a GET request
     * @param model data to be sent to the randed page:
     * - attribute: feedback_form is the empty feedback from (reset the form)
     * - attribute: admin is boolean, and tell us the privilege of the user
     * - attribute: spekers send all the speakers from DB
     * - attribute: feedback send all the feedback fom DB
     * - attribute: title is the title of the randed page
     * - attribute: message is the message the customers will get
     * @return the name of the mapped page (feedback.ftl)
     */
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

    /**
     * Mapping for the /feedback path of the WEB when we receive a POST request
     * @param model data to be sent to the randed page:
     * @param feedback_form is the feedback received from the customer (fill the form)
     * - attribute: admin is boolean, and tell us the privilege of the user
     * - attribute: error are the errors from the filling of the form (if are errors)
     * - attribute: speakers send all the speakers from DB
     * - attribute: feedback send all the feedback fom DB
     * - attribute: title is the title of the randed page
     * - attribute: message is the message the customers will get
     * @return the name of the mapped page (feedback.ftl)
     */
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

    /**
     * Mapping for the /publish/id/visible path of the WEB when we receive a GET request
     * @param id is the ID from DB of the selected feedback
     * @param visible it is true or false (true if it is visible for the costumers)
     * @param model data to be sent to the randed page:
     * - attribute: feedback_form is the empty feedback (reset the form)
     * - attribute: admin is boolean, and tell us the privilege of the user
     * - attribute: speakers send all the speakers from DB
     * - attribute: feedback send all the feedback fom DB
     * - attribute: title is the title of the randed page
     * - attribute: message is the message the customers will get
     * @return the name of the mapped page (feedback.ftl)
     */
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

    /**
     * Mapping for the /update/id path of the WEB when we receive a GET request
     * @param id is the ID from DB of the selected feedback
     * @param model data to be sent to the randed page:
     * - attribute: feedback_update is the feedback get for the specific ID (to populate the form)
     * - attribute: admin is boolean, and tell us the privilege of the user
     * - attribute: spekers send all the speakers from DB
     * - attribute: feedback send all the feedback fom DB
     * - attribute: title is the title of the randed page
     * - attribute: message is the message the customers will get
     * @return the name of the mapped page (feedback.ftl)
     */
    @RequestMapping("/update/{id}")
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public String updateRequestFeedback( Model model, @PathVariable Long id) {

        model.addAttribute("admin", isAdmin());
        model.addAttribute("feedback_update", feedbackDBI.findById(id).get());
        model.addAttribute("speakers", speakersDBI.findAll());
        model.addAttribute("feedback", feedbackDBI.findAll());
        model.addAttribute("title", "Roux - Feedback update request");
        model.addAttribute("message", "Change the message:");
        return "feedback";
    }

    /**
     * Mapping for the /update/id path of the WEB when we receive a POST request
     * @param id is the ID from DB of the selected feedback
     * @param model data to be sent to the randed page:
     * @param feedback_form is the updated feedback form get from user
     * - attribute: feedback_update is the feedback get for the specific ID (to populate the form)
     * - attribute: admin is boolean, and tell us the privilege of the user
     * - attribute: speakers send all the speakers from DB
     * - attribute: feedback send all the feedback fom DB
     * - attribute: title is the title of the randed page
     * - attribute: message is the message the customers will get
     * - attribute: the name of the mapped page (feedback.ftl)
     */
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

    /**
     * Mapping for the /delete/id path of the WEB when we receive a GET request
     * @param id is the ID from DB of the selected feedback for deleting
     * @param model data to be sent to the randed page:
     * - attribute: feedback_form is the empty feedback (reset the form)
     * - attribute: admin is boolean, and tell us the privilege of the user
     * - attribute: speakers send all the speakers from DB
     * - attribute: feedback send all the feedback fom DB
     * - attribute: title is the title of the randed page
     * - attribute: message is the message the customers will get
     * @return the name of the mapped page (feedback.ftl)
     */
    @RequestMapping("/delete/{id}")
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public String deleteFeedback(Model model, @PathVariable Long id) {
        Feedback feedback_form = new Feedback();
        feedbackDBI.delete(feedbackDBI.findById(id).get());

        model.addAttribute("admin", isAdmin());
        model.addAttribute("feedback_form", feedback_form);
        model.addAttribute("message", "Feedback deleted!");
        model.addAttribute("speakers", speakersDBI.findAll());
        model.addAttribute("feedback", feedbackDBI.findAll());
        model.addAttribute("title", "Roux - Feedback deleted!");

        return "feedback";
    }

    /**
     * This method check if the client / user have the administrator role
     * @return true if have the administrator role else return false
     */
    private Boolean isAdmin(){
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();

        boolean hasAdminRole = authentication.getAuthorities().stream()
                .anyMatch(r -> r.getAuthority().equals("ROLE_ADMIN"));
        return hasAdminRole;
    };
}