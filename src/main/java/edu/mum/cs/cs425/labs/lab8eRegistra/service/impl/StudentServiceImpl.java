package edu.mum.cs.cs425.labs.lab8eRegistra.service.impl;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.mum.cs.cs425.labs.lab8eRegistra.model.Student;
import edu.mum.cs.cs425.labs.lab8eRegistra.repository.StudentRepository;
import edu.mum.cs.cs425.labs.lab8eRegistra.service.StudentService;

@Service
public class  StudentServiceImpl implements StudentService {
	
	@Autowired
	private StudentRepository studentRepository;
	@Override
	public Iterable<Student> getAllStudents() {
		
		return studentRepository.findAll();
	}

	@Override
	public Student saveStudent(Student student) {
		
		return studentRepository.save(student);
	}

	@Override
	public Student getStudentById(Integer studentId) {
	
		return studentRepository.findById(studentId).orElse(null);
	}

	@Override
	public Iterable<Student> searchStudent(String s) {
	
		return studentRepository.findByStudentNumber(s);
	}

	@Override
	public void deleteStudentById(Integer studentId) {
		studentRepository.deleteById(studentId);
		
	}
	
	
	
}
