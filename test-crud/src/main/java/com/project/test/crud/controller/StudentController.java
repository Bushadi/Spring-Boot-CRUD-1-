package com.project.test.crud.controller;

import com.project.test.crud.model.Student;
import com.project.test.crud.service.StudentService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/student")
public class StudentController {

    private final StudentService studentService;

    /*public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }*/
    @PostMapping
    public ResponseEntity<Student> saveStudent(@RequestBody Student student){
        return studentService.saveStudent(student);
    }
    @GetMapping
    public ResponseEntity<List<Student>> getAllStudents(){
        return studentService.getAllStudents();
    }
    @GetMapping("/{studentId}")
    public  ResponseEntity<Student> getStudentById(@PathVariable Long studentId){
        return studentService.getStudentById(studentId);
    }
    @PutMapping("/{studentId}")
    public ResponseEntity<Student> updateStudent(@PathVariable Long studentId, @RequestBody Student student){
        return studentService.updateStudent(studentId,student);
    }
    @DeleteMapping("/{studentId}")
    public ResponseEntity<String> deleteStudent(@PathVariable Long studentId){
        return studentService.deleteStudent(studentId);
    }

}
