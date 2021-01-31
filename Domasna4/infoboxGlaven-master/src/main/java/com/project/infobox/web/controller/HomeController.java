package com.project.infobox.web.controller;

import com.project.infobox.repository.CuisineRepository;
import com.project.infobox.service.QuotesService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.client.RestTemplate;

import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping("/")
public class HomeController {

    private final QuotesService quotesService;
    private final CuisineRepository cuisineRepository;

    public HomeController(QuotesService quotesService,
                          CuisineRepository cuisineRepository) {

        this.quotesService = quotesService;
        this.cuisineRepository = cuisineRepository;
    }

    /**
     * Returns the home page with the random selected quote.
     * Hides the table until the user searches for amenities.
     */
    @GetMapping
    public String getHomePage(HttpServletRequest request, Model model) {

        model.addAttribute("quote", quotesService.getQuote());
        model.addAttribute("hasTable", false);

        return "index";
    }

    /**
     * Returns the home page
     * Shows a data table with the searched amenities
     */
    @PostMapping
    public String postMethod(HttpServletRequest request, Model model) {

        model.addAttribute("quote", quotesService.getQuote());
        model.addAttribute("hasTable", true);
        model.addAttribute("items", request.getParameter("searchItems"));
        model.addAttribute("tableData", cuisineRepository.findBySelectedItems(request.getParameter("searchItems")));

        return "index";
    }











}
