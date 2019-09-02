package com.kurowska.master.controller;

import com.kurowska.master.model.RockYou;
import com.kurowska.master.repository.RockYouRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.Optional;

@Controller
public class RockYouController {
    private RockYouRepository rockYouRepository;

    @Autowired
    public RockYouController(RockYouRepository rockYouRepository){
        this.rockYouRepository = rockYouRepository;
    }

    @GetMapping("/show")
    public String show(Model model){
        Optional<RockYou> rockyou = rockYouRepository.findById(1L);
        System.out.println(rockyou);
        model.addAttribute("password", rockyou);
        return "index";
    }
}
