package poly.java5.lab5.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import poly.java5.lab5.model.Category;
import poly.java5.lab5.model.Product;
import poly.java5.lab5.service.serviceimpl.CategoryService;
import poly.java5.lab5.service.serviceimpl.ProductService;

import java.io.File;
import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import java.util.UUID;

@Controller
@RequestMapping("/product")
public class ProductController {
    private ProductService service;
    private CategoryService servceCate;

    @Autowired
    public ProductController(ProductService service, CategoryService servceCate) {
        this.service = service;
        this.servceCate = servceCate;
    }

    @ModelAttribute(name = "product")
    public Product getProduct(){
        return new Product();
    }

    @ModelAttribute(name = "categories")
    public List<Category> getListCate(){
        return servceCate.getList();
    }

    @GetMapping("/page")
    public String index(Model model, @RequestParam(value = "pagenumber", defaultValue = "0") int pageNumber, RedirectAttributes redirectAttributes){
        model.addAttribute("nameFunction", "create");
        model.addAttribute("url", "/product/create");
        model.addAttribute("pagenumber", pageNumber);
        List<Product> products = (List<Product>) redirectAttributes.getFlashAttributes().get(0);
        if(products==null){
            Page<Product> productData = service.getProducts(pageNumber, 5);
            products = productData.getContent();
        }
        model.addAttribute("products", products);
        return "product/index";
    }

    @GetMapping("/previous")
    public String previous(Model model, @RequestParam(value = "pagenumber", defaultValue = "0") int pageNumber){
        pageNumber--;
        if(pageNumber<0){
            pageNumber = 0;
        }
        return "redirect:/product/page?pagenumber="+pageNumber;
    }

    @GetMapping("/next")
    public String next(Model model, @RequestParam(value = "pagenumber", defaultValue = "0") int pageNumber){
        pageNumber++;
        Page<Product> productData = service.getProducts(pageNumber, 5);
        if(pageNumber==productData.getTotalPages()){
            return "redirect:/product/page?pagenumber=0";
        }
        return "redirect:/product/page?pagenumber="+pageNumber;
    }

    @GetMapping("/searchbyprice")
    public String searchByPrice(@RequestParam(value = "pricemin", defaultValue = "0")BigDecimal priceMin,
                                @RequestParam(value = "pricemax", defaultValue = "1")BigDecimal priceMax,
                                Model model, RedirectAttributes redirectAttributes){
        Page<Product> products = service.getProductsbyPrice(priceMin, priceMax, 0, 10);
        List<Product> productList = products.getContent();
        redirectAttributes.addFlashAttribute("list", productList);
        return "redirect:/product/page";
    }

    @PostMapping("/create")
    public String create(@ModelAttribute("product") Product product, @RequestParam("imgUpload")MultipartFile file, Model model){
        if (!file.isEmpty()) {
            try {
                String fileName = file.getOriginalFilename();
                File dir = new File("src/main/resources/static/img/product");
                if (!dir.exists()) {
                    dir.mkdirs();
                }
                File serverFile = new File(dir.getAbsolutePath() + File.separator + fileName);
                file.transferTo(serverFile);
                product.setImg(dir.getAbsolutePath() + File.separator + fileName);
                service.save(product);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return "redirect:/product/page";
    }
    @PostMapping("/update")
    public String updateDB(@ModelAttribute("product") Product product, @RequestParam("id") UUID id, @RequestParam("imgUpload")MultipartFile file) throws ParseException {
        Product productOld = service.getOne(id);
        product.setID(id);
        if (!file.isEmpty()) {
            int index = productOld.getImg().lastIndexOf("\\");
            File fileDelete = new File("src/main/resources/static/img/product/"+productOld.getImg().substring(index+1));
            boolean check = fileDelete.delete();
            if(check)
            try {
                String fileName = file.getOriginalFilename();
                File dir = new File("src/main/resources/static/img/product");
                if (!dir.exists()) {
                    dir.mkdirs();
                }
                File serverFile = new File(dir.getAbsolutePath() + File.separator + fileName);
                file.transferTo(serverFile);
                product.setImg(dir.getAbsolutePath() + File.separator + fileName);
                service.save(product);
                return "redirect:/product/page";
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        product.setImg(productOld.getImg());
        service.save(product);
        return "redirect:/product/page";
    }

    @GetMapping("/update")
    public String update(Model model, @RequestParam("id") UUID id) throws ParseException {
        Product product = service.getOne(id);
        int index = product.getImg().lastIndexOf("\\");
        String src = "/img/product/" + product.getImg().substring(index + 1);
        model.addAttribute("url", "/product/update?id=" + product.getID());
        model.addAttribute("nameFunction", "Update");
        model.addAttribute("img", src);
        model.addAttribute("product", product);
        return "product/index";
    }

    @GetMapping("/delete")
    public String delete(@RequestParam("id") UUID id) throws ParseException {
        Product product = service.getOne(id);
        service.delete(product);
        return "redirect:/product/page";
    }


}
