package com.ivanart555.hrtemplate.api.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/home")
public class HRTemplateController {
    @GetMapping()
    public String index(Model model) {

        return "hrtemplate/home";
    }
}
