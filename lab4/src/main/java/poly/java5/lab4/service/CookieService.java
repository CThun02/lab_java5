package poly.java5.lab4.service;

import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CookieService {
    private final HttpServletRequest req;
    private final HttpServletResponse res;

    @Autowired
    public CookieService(HttpServletRequest req, HttpServletResponse res) {
        this.req = req;
        this.res = res;
    }

    public Cookie get(String name){
        Cookie[] cookies = req.getCookies();
        for (Cookie cookie: cookies) {
            if(cookie.getName().equals(name)){
                return cookie;
            }
        }
        return null;
    }

    public String getValue(String name){
        Cookie cookie = get(name);
        return cookie==null?null:cookie.getValue();
    }

    public Cookie add(String name, String value, int hours){
        Cookie cookie = new Cookie(name, value);
        cookie.setMaxAge(hours * 60 *60);
        res.addCookie(cookie);
        return cookie;
    }

    public void remove(String name){
        Cookie cookie = new Cookie(name, null);
        cookie.setMaxAge(0);
        res.addCookie(cookie);
    }
}
