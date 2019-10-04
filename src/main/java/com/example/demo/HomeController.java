package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.text.SimpleDateFormat;
import java.util.Date;

@Controller
public class HomeController {
    @Autowired
    JobsRepository jobsRepository;
    @RequestMapping("/")
    public String homePage(){
        return "home";
    }
    @GetMapping("/postJob")
    public String postJob(Model model){
        model.addAttribute("job", new Jobs());
        return "jobForm";
    }
    @PostMapping("/processJob")
    public String processJob(@ModelAttribute Jobs job,
                             @RequestParam(name="date") String date){
        try{
            String formatedDate = date;
            SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
            Date realDate = format.parse(formatedDate);
            job.setPostedDate(realDate);
        }catch(java.text.ParseException e){
            e.printStackTrace();
        }
        return "listJobs";
    }



    @RequestMapping("/listJobs")
    public String jobsList(Model model){
        model.addAttribute("jobs",jobsRepository.findAll());
        return "listJobs";
    }

    @GetMapping("/viewJob")
    public String viewJob(Model model){
        model.addAttribute("job", new Jobs());
        return "jobForm";
    }



}
