package com.ethesis.studentService.controller;

import com.ethesis.studentService.domain.Student;
import com.ethesis.studentService.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.support.MessageSourceAccessor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

import static org.springframework.http.HttpStatus.NOT_FOUND;
import static org.springframework.http.HttpStatus.OK;

/**
 * @author erfan
 * @since 4/6/23
 */
@CrossOrigin
@RestController
@RequestMapping(value = "/students")
public class StudentController {

    @Autowired
    private StudentService studentService;

    @Autowired
    private MessageSourceAccessor msa;

//    @GetMapping
//    public ResponseEntity<List<Student>> getAll() {
////        return studentService.getAllByUniversity()
//    }

    @GetMapping(value = "/{studentID}")
    public ResponseEntity<Student> show(@PathVariable long studentID) {
        //todo: check if studentID is null

        return studentService.findById(studentID)
                .map(student -> new ResponseEntity<>(student, OK))
                .orElseThrow(() -> new ResponseStatusException(
                        NOT_FOUND,
                        msa.getMessage("student.not.found", new Object[]{studentID})));
    }
}
