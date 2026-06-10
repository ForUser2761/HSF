package com.hsf302.studentweb.controller;

import com.hsf302.studentweb.entity.Student;
import com.hsf302.studentweb.repository.StudentRepository;
//import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
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
    public String addStudent(@ModelAttribute Student student) {
        studentRepository.save(student);
        return "redirect:/students";
    }


    @GetMapping("/students/edit/{id}")
    public String showCreateForm( @PathVariable Long id ,Model model) {
//        Optional<Student> student = studentRepository.findById(id);
//
//        if (student.isEmpty()) {
//            throw new IllegalArgumentException("Khong tim thay id: " + id);
//        }

        Student student = studentRepository.findById(id).orElseThrow( () -> new IllegalArgumentException("Khong tim thay: " + id));
//        Student student = studentRepository.findById(id).orElseThrow( () -> new ResponseStatusException(HttpStatus.NOT_FOUND,
//                "Sinh viên không tồn tại"));


        //co du lieu hoac la khong
        // isPresent() isEmpty()


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
