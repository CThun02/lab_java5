package poly.java5.lab4.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import poly.java5.lab4.model.Item;

import java.util.List;
@Controller
@RequestMapping("/shop")
public class ShopController {

    @ModelAttribute("products")
    public List<Item> products(){
        return List.of(new Item(1, "product 1", 2000.0, 1),
                        new Item(2, "product 2", 2000.0, 1),
                        new Item(3, "product 3", 2000.0, 1),
                        new Item(4, "product 4", 2000.0, 1));
    }

    @GetMapping("/shopping")
    public String display(){
        return "shop/index";
    }
}
