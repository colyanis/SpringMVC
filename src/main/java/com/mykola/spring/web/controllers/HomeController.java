package com.mykola.spring.web.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by mtverdok on 4/19/2017.
 */
@Controller
public class HomeController {
    @RequestMapping("/")
    public String showHome() {
        return "home";
    }

    @RequestMapping("/admin")
    public String showAdmin() {
        return "admin";
    }
}
