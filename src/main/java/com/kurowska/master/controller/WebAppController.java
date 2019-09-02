package com.kurowska.master.controller;

import com.kurowska.master.model.RockYou;
import com.kurowska.master.repository.RockYouRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Date;

@Controller
public class WebAppController {
    private RockYouRepository rockYouRepository;

    @Autowired
    public WebAppController(RockYouRepository rockYouRepository){
        this.rockYouRepository = rockYouRepository;
    }

    @GetMapping
    public String index(Model model){
        model.addAttribute("datetime", new Date());
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
            model.addAttribute("result", "Nie udało się odzyskać hasła.");
        }
        else{
            model.addAttribute("result", rockYou.getPassword());
        }
        model.addAttribute("datetime", new Date());
        model.addAttribute("hash", hash);
        model.addAttribute("function", function);

        return "index";
    }
}

