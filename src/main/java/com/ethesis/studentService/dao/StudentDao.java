package com.ethesis.studentService.dao;

import com.ethesis.studentService.domain.Student;
import com.ethesis.studentService.domain.University;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * @author erfan
 * @since 4/10/23
 */
public interface StudentDao extends JpaRepository<Student, Long> {

    List<Student> getAllByUniversity(University university);
}
