package com.example.demo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;


/**
 * Simple Controller that returns the index.html when the home path is called.
 */
@Controller
public class HomeController {

    Logger logger = LoggerFactory.getLogger(HomeController.class);

    @RequestMapping("/")
    public String home(Model model) {
        logger.info("home called. Provide file index.html...");
        
        return "index.html";
    }
}