package com.mykola.spring.web.controllers;

import com.mykola.spring.web.dao.Offer;
import com.mykola.spring.web.service.OffersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.validation.Valid;
import java.util.List;

/**
 * Created by mtverdok on 4/12/2017.
 */
@Controller
public class OffersController {

    private OffersService offersService;

    @Autowired
    public void setOffersService(OffersService offersService) {
        this.offersService = offersService;
    }

    @RequestMapping(value = "/test", method = RequestMethod.GET)
    public String showTest(Model model, @RequestParam("id") String id) {
        System.out.println("Id is: " + id);
        return "home";
    }

    @RequestMapping("/offers")
    public String showOffers(Model model) {

        List<Offer> offers = offersService.getCurrent();

        model.addAttribute("offers", offers);
        return "offers";
    }

    @RequestMapping("/createOffer")
    public String createOffer(Model model) {
        model.addAttribute("offer", new Offer());
        return "createOffer";
    }

    @RequestMapping(value = "/docreate", method = RequestMethod.POST)
    public String doCreate(Model model, @Valid Offer offer, BindingResult result) {

        if (result.hasErrors()) {

            return "createOffer";
        } else {
            System.out.println("Form validated.");
        }

        return "offercreated";
    }
}