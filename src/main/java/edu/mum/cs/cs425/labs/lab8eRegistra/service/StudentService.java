package edu.mum.cs.cs425.labs.lab8eRegistra.service;


import edu.mum.cs.cs425.labs.lab8eRegistra.model.Student;

public interface StudentService {

	public abstract Iterable<Student> getAllStudents();
	public abstract Student saveStudent(Student student);
	public abstract Student getStudentById(Integer studentId);
	public abstract Iterable<Student> searchStudent(String s);
	public abstract void deleteStudentById(Integer studentId);




}
