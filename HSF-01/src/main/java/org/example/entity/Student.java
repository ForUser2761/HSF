package org.example.entity;


import jakarta.persistence.*;

import java.math.BigDecimal;
import java.time.LocalDate;


@Entity
@Table(name = "students")
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "full_name", nullable = false, length = 100)
    private String name;

    @Column(unique = true, nullable = false, length = 50)
    private String email;

    @Column(name = "date_of_birth")
    private LocalDate dob;

    @Enumerated(EnumType.STRING)
    @Column(length = 30)
    private Major major;

    @Column(precision = 3, scale = 2)
    private BigDecimal gpa;


    @Transient
    private int age;

    // Constructor không tham số — BẮT BUỘC
    public Student() {
    }

    public Student(String name, String email, LocalDate dob, Major major, BigDecimal gpa) {
        this.name = name;
        this.email = email;
        this.dob = dob;
        this.major = major;
        this.gpa = gpa;
    }

    // Getters và Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public LocalDate getDob() {
        return dob;
    }

    public void setDob(LocalDate dob) {
        this.dob = dob;
    }

    public Major getMajor() {
        return major;
    }

    public void setMajor(Major major) {
        this.major = major;
    }

    public BigDecimal getGpa() {
        return gpa;
    }

    public void setGpa(BigDecimal gpa) {
        this.gpa = gpa;
    }

    @Override
    public String toString() {
        return "Student{id=" + id + ", name='" + name + "', email='" + email +
                "', major=" + major + ", gpa=" + gpa + "}";
    }
}

