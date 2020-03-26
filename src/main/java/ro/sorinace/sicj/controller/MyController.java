package ro.sorinace.sicj.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.ArrayList;
import java.util.HashMap;

@Controller
@RequestMapping("/")
public class MyController {

    @Autowired
    private ArrayList<HashMap> speakers;

    @RequestMapping
    public String rootMapping (Model model)  {
        //DateTimeFormatter dtf = DateTimeFormatter.ofPattern("HH:mm");

        model.addAttribute("speakers", speakers);
        model.addAttribute("title", "Roux - Main page");
        //model.addAttribute("time", LocalTime.now().format(dtf));
        return "index";
    }

    @RequestMapping(value = "/speakers", method = RequestMethod.GET)
    public String speakerMapping(Model model)  {

        model.addAttribute("speakers", speakers);
        model.addAttribute("title", "Roux - Speakers");
        return "speakers";
    }

    @RequestMapping(value = "/feedback", method = RequestMethod.GET)
    public String feedbackMapping(Model model)  {

        model.addAttribute("speakers", speakers);
        model.addAttribute("feedback", speakers);
        model.addAttribute("title", "Roux - Speakers");
        return "feedback";
    }

    @RequestMapping(value = "/speakers/{name}", method = RequestMethod.GET)
    public String speakerMapping(Model model, @PathVariable String name)  {

        for (HashMap artist: speakers) {
            if (artist.get("shortname").equals(name)){
                model.addAttribute("artist", artist);
            }
        }

        model.addAttribute("speakers", speakers);
        model.addAttribute("title", "Roux - " + name);
        return "speaker";
    }


}