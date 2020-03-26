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

    @RequestMapping(value = "{configKey}", method = RequestMethod.GET)
    public String speakerMapping(Model model, @PathVariable String configKey)  {
        //DateTimeFormatter dtf = DateTimeFormatter.ofPattern("HH:mm");

        model.addAttribute("speakers", speakers);
        //model.addAttribute("cale", configKey);
        model.addAttribute("title", "Roux - Speakers page");
        //model.addAttribute("time", LocalTime.now().format(dtf));
        return "speakers";
    }


}