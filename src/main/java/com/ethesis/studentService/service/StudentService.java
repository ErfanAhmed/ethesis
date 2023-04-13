package com.ethesis.studentService.service;

import com.ethesis.studentService.dao.StudentDao;
import com.ethesis.studentService.domain.Student;
import com.ethesis.studentService.domain.University;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 * @author erfan
 * @since 4/10/23
 */
@Service
public class StudentService {

    @Autowired
    private StudentDao studentDao;

    public Optional<Student> findById(long studentId) {
        Optional<Student> student = studentDao.findById(studentId);
        return student;
    }

    public List<Student> getAllByUniversity(University university) {
        return studentDao.getAllByUniversity(university);
    }
}
