package poly.java5.lab4.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import poly.java5.lab4.service.CookieService;
import poly.java5.lab4.service.ParamService;
import poly.java5.lab4.service.SessionService;

@Controller
@RequestMapping("/account")
public class AccountController {
    private CookieService cookieService;
    private SessionService sessionService;
    private ParamService paramService;

    @Autowired
    public AccountController(CookieService cookieService, SessionService sessionService, ParamService paramService) {
        this.cookieService = cookieService;
        this.sessionService = sessionService;
        this.paramService = paramService;
    }

    @GetMapping("/login")
    public String loginView(Model model){
        String account = cookieService.getValue("username");
        if(account!=null){
            String password = cookieService.getValue("password");
            model.addAttribute("username", account);
            model.addAttribute("password", password);
        }
        return "account/login";
    }

    @PostMapping("/login")
    public String login(){
        String account = paramService.getString("username", "");
        String password = paramService.getString("password", "");
        Boolean remeber = paramService.getBoolean("remember", false);
        if(account.equals("thuanncph26631") && password.equals("12345")){
            if(remeber){
                cookieService.add("username", account, 24*10);
                cookieService.add("password", password, 24*10);
            }else{
                cookieService.remove("username");
                cookieService.remove("password");
            }
            return "redirect:/shop/shopping";
        }
        return "account/login";
    }
}
