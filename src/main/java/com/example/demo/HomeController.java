package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {
    @Autowired
    JobsRepository jobsRepository;
    @RequestMapping("/")
    public String homePage(){
        return "home";
    }
    @RequestMapping("/viewJobs")
    public String jobsList(Model model){
        model.addAttribute("jobs",jobsRepository.findAll());
        return "jobForm";
    }

    @GetMapping("/postJob")
    public String postJob(Model model){
        model.addAttribute("job", new Jobs());
        return "jobForm";
    }
    @GetMapping("/viewJob")
    public String viewJob(Model model){
        model.addAttribute("job", new Jobs());
        return "list";
    }
}
