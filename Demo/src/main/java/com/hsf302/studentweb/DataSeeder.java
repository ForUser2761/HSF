package com.hsf302.studentweb;

import com.hsf302.studentweb.entity.Student;
import com.hsf302.studentweb.repository.StudentRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import java.time.LocalDate;

@Component
public class DataSeeder implements CommandLineRunner {

    private final StudentRepository repo;

    public DataSeeder(StudentRepository repo) {
        this.repo = repo;
    }

    @Override
    public void run(String... args) {
        if (repo.count() == 0) {
            Student s1 = new Student();
            s1.setName("Nguyễn Văn A");
            s1.setEmail("anv@fpt.edu.vn");
            s1.setDob(LocalDate.of(2003, 5, 15));
            s1.setMajor("Software Engineering");
            s1.setGpa(3.5);
            repo.save(s1);

            Student s2 = new Student();
            s2.setName("Trần Thị B");
            s2.setEmail("btt@fpt.edu.vn");
            s2.setDob(LocalDate.of(2002, 8, 20));
            s2.setMajor("Information Assurance");
            s2.setGpa(3.8);
            repo.save(s2);

            Student s3 = new Student();
            s3.setName("Lê Văn C");
            s3.setEmail("clv@fpt.edu.vn");
            s3.setDob(LocalDate.of(2003, 1, 10));
            s3.setMajor("Artificial Intelligence");
            s3.setGpa(3.2);
            repo.save(s3);

            System.out.println("==> Đã thêm 3 sinh viên mẫu");
        }
    }
}