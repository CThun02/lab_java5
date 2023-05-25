package poly.java5.lab2.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import poly.java5.lab2.model.Product;

@Controller
@RequestMapping("/product")
public class Bai3Controller {

    @ModelAttribute("product")
    public Product getProduct(){
        return new Product();
    }

    @GetMapping("/form")
    public String form(){
        return "bai3/form";
    }

    @PostMapping("/save")
    public String save(@ModelAttribute("product")Product product){
        return "bai3/form";
    }
}
