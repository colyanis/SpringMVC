package com.mykola.spring.web.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by mtverdok on 4/12/2017.
 */
@Controller
public class OffersController {

    @RequestMapping("/")
    public String showHome(Model model) {
        model.addAttribute("name", "River");

        return "home";
    }
}
