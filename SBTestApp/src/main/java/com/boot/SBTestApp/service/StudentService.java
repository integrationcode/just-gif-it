package com.boot.SBTestApp.service;

import java.util.List;
import java.util.Optional;

import javax.swing.Spring;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.boot.SBTestApp.model.Student;
import com.boot.SBTestApp.repository.StudentRepository;

@Service(value = "myStudentService")
public class StudentService {
	
	@Autowired
	private StudentRepository studentRepository;
	
	public List<Student> getAllStudents(){
		System.out.println("[StudentService][getAllStudents] Get all students.");
		return studentRepository.findAll();
	}
	
	public Student getStudentById(Long id){
		System.out.println("[StudentService][getStudentById] Get a student record with Id: " + id);
		Optional<Student> student = studentRepository.findById(id);
		if(student.isPresent())
			return student.get();
		else
			return new Student();		
	}
	
	public Student create(Student student) {
		System.out.println("[StudentService][create] Creating student record. " + student);
		return studentRepository.save(student);
	}
	
	public Student update(Student student) {
		Student existingStudent = getStudentById(student.getId());
		if(existingStudent.getId()!=null) {
			BeanUtils.copyProperties(student, existingStudent);
			studentRepository.save(existingStudent);
			return existingStudent;
		}else {
			System.out.println("[StudentService][update] Student Not Found!");
			return student;
		}
	}
	
	public void delete(Long id) {
		System.out.println("[StudentService][delete] Deleting record with id: " + id);
		studentRepository.delete(getStudentById(id));
	}

}
