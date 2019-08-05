package edu.mum.cs.cs425.labs.lab8eRegistra.model;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name = "students")
public class Student {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer studentId;
	
	@NotBlank(message = "Student Number Required" )
	private String studentNumber; // required
	
	@NotBlank(message = "First Name Required" )
	private String firstName; // required
	

	private String middleName;
	
	@NotBlank(message = "Last Name Required")
	private String LastName; // required
	private Double cgpa;
	
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private LocalDate enrollmentDate;  // required
	@NotNull(message = "International Status Required")
	private Boolean isInternational; // required
	
	public Student() {
		super();
	}

	public Student(Integer studentId, String studentNumber, String firstName, String middleName, String lastName,
			Double cgpa, LocalDate enrollmentDate, Boolean isInternational) {
		super();
		this.studentId = studentId;
		this.studentNumber = studentNumber;
		this.firstName = firstName;
		this.middleName = middleName;
		LastName = lastName;
		this.cgpa = cgpa;
		this.enrollmentDate = enrollmentDate;
		this.isInternational = isInternational;
	}
	
	public Student(String studentNumber, String firstName, String middleName, String lastName,
			Double cgpa, LocalDate enrollmentDate, Boolean isInternational) {
		super();

		this.studentNumber = studentNumber;
		this.firstName = firstName;
		this.middleName = middleName;
		LastName = lastName;
		this.cgpa = cgpa;
		this.enrollmentDate = enrollmentDate;
		this.isInternational = isInternational;
	}

	public Integer getStudentId() {
		return studentId;
	}

	public void setStudentId(Integer studentId) {
		this.studentId = studentId;
	}

	public String getStudentNumber() {
		return studentNumber;
	}

	public void setStudentNumber(String studentNumber) {
		this.studentNumber = studentNumber;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getMiddleName() {
		return middleName;
	}

	public void setMiddleName(String middleName) {
		this.middleName = middleName;
	}

	public String getLastName() {
		return LastName;
	}

	public void setLastName(String lastName) {
		LastName = lastName;
	}

	public Double getCgpa() {
		return cgpa;
	}

	public void setCgpa(Double cgpa) {
		this.cgpa = cgpa;
	}

	public LocalDate getEnrollmentDate() {
		return enrollmentDate;
	}

	public void setEnrollmentDate(LocalDate enrollmentDate) {
		this.enrollmentDate = enrollmentDate;
	}

	public Boolean getIsInternational() {
		return isInternational;
	}

	public void setIsInternational(Boolean isInternational) {
		this.isInternational = isInternational;
	}

	@Override
	public String toString() {
		return "Student [studentId=" + studentId + ", studentNumber=" + studentNumber + ", firstName=" + firstName
				+ ", middleName=" + middleName + ", LastName=" + LastName + ", cgpa=" + cgpa + ", enrollmentDate="
				+ enrollmentDate + ", isInternational=" + isInternational + "]";
	}
	
	
	

}
