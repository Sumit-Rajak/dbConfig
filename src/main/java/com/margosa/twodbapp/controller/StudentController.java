package com.margosa.twodbapp.controller;


import com.margosa.twodbapp.model.Student;
import com.margosa.twodbapp.service.StudentService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
@Slf4j
@RequiredArgsConstructor
public class StudentController {

    private final StudentService studentService;

    @PostMapping("/save")
    public ResponseEntity<String> createTutorial(@RequestBody Student student) {

            studentService.save(new Student(student.getId(), student.getName(), student.getAddress()));
            return new ResponseEntity<>(" student was created successfully.", HttpStatus.CREATED);

        }
    }






