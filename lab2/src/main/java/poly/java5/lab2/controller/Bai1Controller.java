package poly.java5.lab2.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/ctrl")
public class Bai1Controller {
    @GetMapping("/index")
    public String index(){
        return "bai1/ok";
    }

    @PostMapping(value = "/ok", params = "!x")
    public String m1(Model model){
        model.addAttribute("mess", "m1");
        return "bai1/ok";
    }

    @GetMapping("/ok")
    public String m2(Model model){
        model.addAttribute("mess", "m2");
        return "bai1/ok";
    }

    @PostMapping(value = "/ok", params = "x")
    public String m3(Model model){
        model.addAttribute("mess", "m3");
        return "bai1/ok";
    }
}
