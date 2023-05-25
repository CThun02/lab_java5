package poly.java5.lab4.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import poly.java5.lab4.model.Item;
import poly.java5.lab4.service.CartServiceImpl;
import poly.java5.lab4.service.CartServiceInterface;

import java.util.List;

@Controller
@RequestMapping("/cart")
public class CartController {
    private CartServiceInterface service;
    private List<Item> shopItems;

    @Autowired
    public CartController(CartServiceImpl service) {
        this.service = service;
        shopItems = List.of(new Item(1, "product 1", 2000.0, 1),
                            new Item(2, "product 2", 2000.0, 1),
                            new Item(3, "product 3", 2000.0, 1),
                            new Item(4, "product 4", 2000.0, 1));
    }

    @ModelAttribute("cartitems")
    public List<Item> getCart(){
        return service.getCartItems();
    }

    @GetMapping("/add")
    public String addToCart(@RequestParam("id") int id) {
        Item item = service.getOneByID(id, shopItems);
        service.add(item);
        return "cart/index";
    }
    @GetMapping("/index")
    public String index(){
        return "cart/index";
    }

    @PostMapping("/update/{id}")
    public String update(@PathVariable int id, @RequestParam("quantity") int quantity, Model model){
        if(quantity<0){
            model.addAttribute("mess", "Số lượng phải lớn hơn 0!");
            return "cart/index";
        }
        Item item = service.getOneByID(id, shopItems);
        service.update(item, quantity);
        return "cart/index";
    }

    @GetMapping("/remove/{id}")
    public String remove(@PathVariable int id){
        service.remove(id);
        return "cart/index";
    }

    @GetMapping("/clear")
    public String clear(){
        service.clear();
        return "cart/index";
    }
}
