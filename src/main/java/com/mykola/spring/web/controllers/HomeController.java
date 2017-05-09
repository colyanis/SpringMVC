package com.mykola.spring.web.controllers;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by mtverdok on 4/19/2017.
 */
@Controller
public class HomeController {
    private static Logger logger = Logger.getLogger(HomeController.class);

    @RequestMapping("/")
    public String showHome() {
        logger.info("SHowing home page...");
        return "home";
    }
}
