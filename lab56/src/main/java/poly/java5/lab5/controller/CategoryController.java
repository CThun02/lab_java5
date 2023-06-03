package poly.java5.lab5.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import poly.java5.lab5.model.Category;
import poly.java5.lab5.service.serviceimpl.CategoryService;

import java.util.List;
import java.util.UUID;

@Controller
@RequestMapping("/category")
public class CategoryController {

    @Autowired
    private CategoryService service;

    @ModelAttribute("categories")
    public List<Category> getList(){
        return service.getList();
    }
    @ModelAttribute("category")
    public Category getCategory(){
        return new Category();
    }

    @GetMapping("/data")
    public String data(Model model){
        model.addAttribute("nameFunction", "create");
        model.addAttribute("cateurl", "/category/create");
        return "category/index";
    }

    @PostMapping("/create")
    public String create(@ModelAttribute("category") Category category){
        service.save(category);
        return "redirect:/category/data";
    }

    @GetMapping("/update")
    public String update(@RequestParam("id")UUID id, Model model){
        model.addAttribute("nameFunction", "update");
        model.addAttribute("cateurl", "/category/update?id="+id);
        Category category = service.getOne(id);
        model.addAttribute("category", category);
        return "category/index";
    }

    @PostMapping("/update")
    public String updateDB(@RequestParam("id")UUID id, Model model, @ModelAttribute("category")Category categoryUpdate){
        Category category = service.getOne(id);
        categoryUpdate.setID(category.getID());
        service.save(categoryUpdate);
        model.addAttribute("category", category);
        return "redirect:/category/data";
    }



    @GetMapping("/delete")
    public String update(@RequestParam("id")UUID id){
        Category category = service.getOne(id);
        service.delete(category);
        return "redirect:/category/data";
    }
}
