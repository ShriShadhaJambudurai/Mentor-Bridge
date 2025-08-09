package com.ssm.StudentMgnt.controller;

import com.ssm.StudentMgnt.controller.dto.StudentDTO;
import com.ssm.StudentMgnt.services.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/student")
public class StudentController {

    @Autowired
    private StudentService studentService;


    @GetMapping
    public ResponseEntity<List<StudentDTO>> getAllStudents() {
        List<StudentDTO> students = studentService.getAll();
        return ResponseEntity.ok(students);
    }


    @GetMapping("/{id}")
    public ResponseEntity<StudentDTO> getStudentById(@PathVariable Long id) {
        Optional<StudentDTO> studentOpt = studentService.getById(id);
        return studentOpt
                .map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }


    @PostMapping
    public ResponseEntity<String> addStudent(@RequestBody StudentDTO studentDTO) {
        studentService.add(studentDTO);
        return ResponseEntity.ok("Student added successfully");
    }


    @PutMapping("/{id}")
    public ResponseEntity<String> updateStudent(@PathVariable Long id, @RequestBody StudentDTO studentDTO) {
        Optional<StudentDTO> existingStudent = studentService.getById(id);
        if (existingStudent.isPresent()) {
            studentService.update(id, studentDTO);
            return ResponseEntity.ok("Student updated successfully");
        } else {
            return ResponseEntity.notFound().build();
        }
    }


    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteStudent(@PathVariable Long id) {
        Optional<StudentDTO> existingStudent = studentService.getById(id);
        if (existingStudent.isPresent()) {
            studentService.delete(id);
            return ResponseEntity.ok("Student deleted successfully");
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
