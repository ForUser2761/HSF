package com.hsf302.studentweb.controller;

import com.hsf302.studentweb.repository.StudentRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class StudentController {

    private final StudentRepository studentRepository;

    public StudentController(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    //localhost:8080/students =>

    @GetMapping("/students")
    public String listStudent(Model model) {
        model.addAttribute("students", studentRepository.findAll());
        return "student-list";
    }

}
