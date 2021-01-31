package com.project.infobox.web.controller;

import com.project.infobox.model.Amenity;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.client.RestTemplate;

import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping("/explore")
public class ExploreController {

    public final RestTemplate restTemplate;

    public ExploreController(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    /**
     * Returns the explore page with the selected amenity details.
     */
    @GetMapping
    public String getExplorePage(Model model,
                                 @RequestParam(value = "id", required = false) Long id) {

        //if the id is not null hide the amenity selection and show only the selected amenity
        if (id != null) {
            ResponseEntity<Amenity> locationInfo = restTemplate.getForEntity(
                    "http://AMENITY-PLACES-SERVICE/api/place?id=" + id,
                    Amenity.class
            );

            model.addAttribute("locationInfo", locationInfo.getBody());
            model.addAttribute("hasId", true);
            model.addAttribute("id", id);
        }
        else {

            //if the id is null show the select section to choose an amenity type
            model.addAttribute("hasId", false);
        }
        return "explore";
    }

}
