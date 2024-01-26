package com.student.controller;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.*;

import com.student.model.Student;
import com.student.repository.StudentRepository;

import java.util.List;

@RestController
@RequestMapping("/students")
public class StudentController {

    @Autowired
    private StudentRepository studentRepository;

   
	@GetMapping
    public List<Student> getAllStudents() {
		return studentRepository.findAll();
    }

    @PostMapping
    public Student addStudent(@RequestBody Student student) {
        return studentRepository.save(student);
    }

    @DeleteMapping("/{id}")
    public void deleteStudent(@PathVariable Long id) {
    	if(this.studentRepository.findById(id).isPresent())
		{
			this.studentRepository.delete(this.studentRepository.findById(id).get());
			
		}
		
    }

    @PutMapping("/{id}")
    public Student updateStudent(@PathVariable Long id, @RequestBody Student updatedStudent) {
        
    	if(this.studentRepository.findById(id).isPresent()) {
    	updatedStudent.setStudentId(id);
       
    	}
    	 return studentRepository.save(updatedStudent);
    }
}
