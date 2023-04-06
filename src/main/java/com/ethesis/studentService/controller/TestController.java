package com.ethesis.studentService.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author erfan
 * @since 4/6/23
 */
@RestController
public class TestController {

    @GetMapping(value = "test")
    public String welcome() {
        return "welcome to e-thesis 1.0";
    }
}
