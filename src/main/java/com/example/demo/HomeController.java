package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {
    @Autowired
    JobsRepository jobsRepository;

    @RequestMapping("/")
    public String jobsList(Model model){
        model.addAttribute("jobs",jobsRepository.findAll());
        return "list";
    }
}
