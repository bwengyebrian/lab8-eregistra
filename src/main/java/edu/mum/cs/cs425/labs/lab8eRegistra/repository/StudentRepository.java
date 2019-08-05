package edu.mum.cs.cs425.labs.lab8eRegistra.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import edu.mum.cs.cs425.labs.lab8eRegistra.model.Student;

@Repository
public interface StudentRepository extends CrudRepository<Student, Integer> {
	
	
	 Iterable<Student> findByStudentNumber(String s);
	

}
