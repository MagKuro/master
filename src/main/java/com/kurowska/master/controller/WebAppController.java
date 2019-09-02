package com.kurowska.master.controller;

import com.kurowska.master.model.GeneratedPassword;
import com.kurowska.master.model.RockYou;
import com.kurowska.master.repository.GeneratedPasswordRepository;
import com.kurowska.master.repository.RockYouRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Date;
import java.util.Optional;

@Controller
public class WebAppController {
    private RockYouRepository rockYouRepository;
    private GeneratedPasswordRepository generatedPasswordRepository;

    @Autowired
    public WebAppController(RockYouRepository rockYouRepository, GeneratedPasswordRepository generatedPasswordRepository){
        this.rockYouRepository = rockYouRepository;
        this.generatedPasswordRepository = generatedPasswordRepository;
    }

    @GetMapping
    public String index(Model model){
        model.addAttribute("rockyou", new RockYou());
        return "index";
    }

    @RequestMapping("/contact")
    public String contact(){
        return "contact";
    }

    @RequestMapping("/aboutproject")
    public String aboutproject(){
        return "aboutproject";
    }

    @PostMapping("/index")
    public String crack(@RequestParam()String function, @RequestParam()String hash,
                        Model model){

        System.out.println(function);
        System.out.println(hash);
        RockYou rockYou = null;

        if(function.equals("md5")){
            rockYou = rockYouRepository.getByMd5(hash);
        }
        else if(function.equals("sha1")){
            rockYou = rockYouRepository.getBySha1(hash);
        }
        else if(function.equals("sha2")){
            rockYou = rockYouRepository.getBySha2(hash);
        }
        if(rockYou==null){
            rockYou = new RockYou();
        }

        model.addAttribute("datetime", new Date());
        model.addAttribute("password", rockYou.getPassword());
        model.addAttribute("hash", hash);
        model.addAttribute("function", function);

        return "index";
    }
}

