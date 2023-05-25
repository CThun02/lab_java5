package com.example.lab1.controller;


import com.example.lab1.model.Student;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.time.LocalDate;
import java.time.Month;
import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/students")
public class StudentController {
    private final List<Student> students;

    public StudentController() {
        this.students = new ArrayList<>();
        students.add(new Student(1L, "PH26631", "Nguyễn Công Thuần", LocalDate.of(2002, Month.AUGUST, 13)));
        students.add(new Student(1L, "PH26632", "Nguyễn Văn Quân", LocalDate.of(1991, Month.AUGUST, 16)));
    }

    @GetMapping("/index")
    public String index(Model model){
        model.addAttribute("students", students);
        return "/webapp/WEB-INF/views/student/index";
    }
}
