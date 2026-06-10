package com.hsf302.studentweb.controller;

import com.hsf302.studentweb.entity.Student;
import com.hsf302.studentweb.repository.StudentRepository;
//import org.springframework.http.HttpStatus;
import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.server.ResponseStatusException;

import java.util.Optional;

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

    @GetMapping("/students/new")
    public String showCreateForm(Model model) {
        model.addAttribute("student", new Student());
        return "student-form";
    }

    @PostMapping("/students/add")
    public String addStudent(@Valid @ModelAttribute Student student, BindingResult result) {
        if (result.hasErrors()) {
            return "student-form";
        }

        studentRepository.save(student);
        return "redirect:/students";
    }


    @GetMapping("/students/edit/{id}")
    public String showCreateForm( @PathVariable Long id ,Model model) {
        Student student = studentRepository.findById(id).orElseThrow( () -> new IllegalArgumentException("Khong tim thay: " + id));
        model.addAttribute("student", student);
        return "student-form";
    }

    @PostMapping("/students/edit/{id}")
    public String addStudent( @PathVariable Long id ,@ModelAttribute Student student) {
        student.setId(id);
        studentRepository.save(student);
        return "redirect:/students";
    }

    @GetMapping("/students/delete/{id}")
    public String deleteStudent(@PathVariable Long id) {
        studentRepository.deleteById(id);
        return "redirect:/students";
    }


}
