package com.mykola.spring.web.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by mtverdok on 4/27/2017.
 */
@Controller
public class LoginController {

    @RequestMapping("/login")
    public String showLogin() {
        return "login";
    }
}
