package poly.java5.lab2.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import poly.java5.lab2.model.Product;

@Controller
@RequestMapping("/bai4")
public class Bai4Controller {
    @ModelAttribute("product")
    public Product getProduct(){
        return new Product();
    }

    @GetMapping("/form")
    public String form(Model model) {
        Product product = new Product();
        product.setName("iPhone 30");
        product.setPrice(5000.0);
        model.addAttribute("productDef", product);
        return "bai4/form";
    }
    @PostMapping("/save")
    public String save(@ModelAttribute Product product, RedirectAttributes redirectAttributes) {
        redirectAttributes.addFlashAttribute("product", product);
        return "redirect:/bai4/form";
    }

    @ModelAttribute("products")
    public List<Product> getItems() {
        return List.of(new Product("thuannc", 1.0), new Product("quannv", 12.0));
    }
}
