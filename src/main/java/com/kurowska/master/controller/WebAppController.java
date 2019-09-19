package com.kurowska.master.controller;

import com.kurowska.master.model.Password;
import com.kurowska.master.repository.PasswordRepository;
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
    private PasswordRepository passwordRepository;

    @Autowired
    public WebAppController(PasswordRepository passwordRepository){
        this.passwordRepository = passwordRepository;
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

        Password password = null;

        if(function.equals("md5")){
            password = passwordRepository.getByMd5(hash).stream().findFirst().orElse(null);
        }
        else if(function.equals("sha1")){
            password = passwordRepository.getBySha1(hash).stream().findFirst().orElse(null);
        }
        else if(function.equals("sha2")){
            password = passwordRepository.getBySha2(hash).stream().findFirst().orElse(null);
        }
        if(password==null){
            model.addAttribute("result", "Nie udało się odzyskać hasła.");
        }
        else{
            model.addAttribute("result", password.getPassword());
        }
        model.addAttribute("datetime", new Date());
        model.addAttribute("hash", hash);
        model.addAttribute("function", function);

        return "index";
    }
}

