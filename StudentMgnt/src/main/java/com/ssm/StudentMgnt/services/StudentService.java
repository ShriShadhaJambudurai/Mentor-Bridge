package com.ssm.StudentMgnt.services;

import com.ssm.StudentMgnt.controller.dto.StudentDTO;
import com.ssm.StudentMgnt.repository.StudentRepository;
import com.ssm.StudentMgnt.repository.entities.StudentEntities;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.*;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class StudentService {

    @Autowired
    private StudentRepository studentRepository;

    @CacheEvict(value = "allStudents", allEntries = true)
    public void add(StudentDTO studentDTO) {
        StudentEntities student = new StudentEntities(
                null,
                studentDTO.getName(),
                studentDTO.getAge(),
                studentDTO.getDept()
        );
        studentRepository.save(student);
        System.out.println("Added Student: " + student);
    }

    @Cacheable("allStudents")
    public List<StudentDTO> getAll() {
        List<StudentEntities> students = studentRepository.findAll();
        return students.stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }

    @Cacheable(value = "studentById", key = "#id")
    public Optional<StudentDTO> getById(Long id) {
        Optional<StudentEntities> studentOpt = studentRepository.findById(id);
        return studentOpt.map(this::convertToDTO);
    }

    @CacheEvict(value = {"studentById", "allStudents"}, allEntries = true)
    public void update(Long id, StudentDTO studentDTO) {
        Optional<StudentEntities> optionalStudent = studentRepository.findById(id);
        if (optionalStudent.isPresent()) {
            StudentEntities student = optionalStudent.get();
            student.setName(studentDTO.getName());
            student.setAge(studentDTO.getAge());
            student.setDept(studentDTO.getDept());
            studentRepository.save(student);
            System.out.println("Updated Student: " + student);
        } else {
            System.out.println("Student not found with id: " + id);
        }
    }

    @CacheEvict(value = {"studentById", "allStudents"}, allEntries = true)
    public void delete(Long id) {
        studentRepository.deleteById(id);
        System.out.println("Deleted Student with id: " + id);
    }

    private StudentDTO convertToDTO(StudentEntities entity) {
        return new StudentDTO(
                entity.getId(),
                entity.getName(),
                entity.getAge(),
                entity.getDept()
        );
    }
}
