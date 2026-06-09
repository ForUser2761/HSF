package com.hsf302.studentweb.repository;

import com.hsf302.studentweb.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepository extends JpaRepository<Student, Long> {
    //persist => save()

    //find => findById()

        //findAll()

    //remove
        //deleteById

}
