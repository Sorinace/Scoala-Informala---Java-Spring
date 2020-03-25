package ro.sorinace.sicj.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

@Controller
@RequestMapping("/")
public class MyController {

    @RequestMapping
    public String handleRequest (Model model) {
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("HH:mm");

        model.addAttribute("msg", "A message from the controller!!!");
        model.addAttribute("time", LocalTime.now().format(dtf));
        return "index";
    }
}