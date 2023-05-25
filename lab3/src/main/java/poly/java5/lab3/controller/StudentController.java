package poly.java5.lab3.controller;

import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import poly.java5.lab3.model.Student;

import java.util.HashMap;
import java.util.Map;

@Controller
@RequestMapping("/student")
public class StudentController {

    @ModelAttribute("st")
    public Student getStudent(){
        return new Student();
    }

    @ModelAttribute("faculties")
    public Map<String, String> getFaculties(){
        Map<String, String> faculties = new HashMap<>();
        faculties.put("CNTT", "Công nghệ thông tin");
        faculties.put("DLNHKS", "Du lịch");
        faculties.put("QTDN", "Quản trị doanh nghiệp");
        return faculties;
    }

    @ModelAttribute("hobbies")
    public Map<String, String> getGender(){
        Map<String, String> hobbies = new HashMap<>();
        hobbies.put("T", "Traveling");
        hobbies.put("M", "Music");
        hobbies.put("F", "Food");
        hobbies.put("O", "Other");
        return hobbies;
    }


    @GetMapping("/form")
    public String getForm(){
        return "student/form";
    }

    @PostMapping("/save")
    public String save(@Valid @ModelAttribute("st") Student st, BindingResult result, Model model){
        if(result.hasErrors()){
            model.addAttribute("mess", "Vui lòng sửa tất cả các lỗi để tiếp tục");
        }
        return "student/form";
    }
}
