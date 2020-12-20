package com.project.infobox.web.controller;

import com.project.infobox.service.LocationService;
import com.project.infobox.service.QuotesService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping("/")
public class HomeController {

    private final QuotesService quotesService;
    private final LocationService locationService;

    public HomeController(QuotesService quotesService, LocationService locationService) {
        this.quotesService = quotesService;
        this.locationService = locationService;
    }

    @GetMapping // localhost:8080/
    public String getHomePage(HttpServletRequest request, Model model) {
        model.addAttribute("quote", quotesService.getQuote());
        return "index";
    }

    @PostMapping
    public String postMethod(HttpServletRequest request, Model model) {
        // vrednostite od search se prakjaat na ime searchItems
        model.addAttribute("quote", quotesService.getQuote());
        System.out.println(request.getParameter("searchItems"));
        return "index";
    }


}
