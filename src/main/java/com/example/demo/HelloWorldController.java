package com.example.demo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;


/**
 * Simple Controller that returns the helloworld.html when the helloworld path is called.
 */
@Controller
public class HelloWorldController {

    Logger logger = LoggerFactory.getLogger(HelloWorldController.class);

    @RequestMapping("/helloworld")
    public String helloworld(Model model) {
        logger.info("Hello world called. Provide file helloworld.html...");
        
        return "helloworld.html";
    }
}