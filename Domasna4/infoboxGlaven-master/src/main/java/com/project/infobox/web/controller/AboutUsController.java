package com.project.infobox.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/about_us")
public class AboutUsController {

    /**
     * Returns the about us page.
     */
    @GetMapping
    public String getAboutUsPage() {
        return "about_us";
    }
}
