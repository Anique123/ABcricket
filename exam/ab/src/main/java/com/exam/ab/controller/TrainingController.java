package com.exam.ab.controller;

import com.exam.ab.model.Training;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.*;

@Controller
public class TrainingController {
    ArrayList<Training> træningstider = new ArrayList<Training>();

    @GetMapping("/addTrainingSite")
    public String addTrainingSite(Model model){
        model.addAttribute("Training",new Training());
        return "addTrainingSite";
    }

    @PostMapping("/addTrainingSite")
    public String Træning(@ModelAttribute Training training, BindingResult bindingResult){
        træningstider.add(training);
        return "redirect:/";
    }





}
