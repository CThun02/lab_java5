package poly.java5.lab2.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/param")
public class Bai2Controller {
    @GetMapping("/form")
    public String form(){
        return "bai2/form";
    }

    @PostMapping(value = "/save/{x}")
    public String save(Model model, @RequestParam String y, @PathVariable String x){
        model.addAttribute("x", x);
        model.addAttribute("y", y);
        return "bai2/form";

    }
}
