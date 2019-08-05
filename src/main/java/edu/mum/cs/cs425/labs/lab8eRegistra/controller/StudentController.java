package edu.mum.cs.cs425.labs.lab8eRegistra.controller;



import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import edu.mum.cs.cs425.labs.lab8eRegistra.model.Student;
import edu.mum.cs.cs425.labs.lab8eRegistra.service.StudentService;

@Controller
public class StudentController {
	
	@Autowired
	private StudentService studentService;
	
	public StudentController() {
		
	}
	
	@GetMapping(value = {"/eregistra/student/list"})
	public ModelAndView listStudents() {
		ModelAndView model = new ModelAndView();
		model.addObject("students",studentService.getAllStudents());
		model.setViewName("student/list");
		return model;
	}
	
	@GetMapping(value= {"/eregistra/student/new"})
	public String addNewStudent(Model model) {
		model.addAttribute("student", new Student());
		return "student/new";
	}
	
	@PostMapping(value= {"/eregistra/student/new"})
	public String saveNewStudent(@Valid @ModelAttribute Student student,@RequestParam("isInternational") String intern,BindingResult bindingResult, Model model) {
		
		if(bindingResult.hasErrors()) {
			model.addAttribute("errors", bindingResult.getAllErrors());
			return "student/new";
		}
		
		studentService.saveStudent(student);
		return "redirect:/eregistra/student/list";
	}
	
	@GetMapping(value = {"/eregistra/student/edit/{studentId}"})
	public String  editStudent(@PathVariable Integer studentId, Model model) {
		Student student = studentService.getStudentById(studentId);
		if(student != null) {
		model.addAttribute("student", student);
		
		return "student/edit";
		}
		return "student/list";
		
	}
	
	@PostMapping(value = {"/eregistra/student/edit"})
	public String updateStudent(@Valid @ModelAttribute("student") Student student , BindingResult bindingResult, Model model) {
		
		 if (bindingResult.hasErrors()) {
	            model.addAttribute("errors", bindingResult.getAllErrors());
	            return "student/edit";
	        }
	        studentService.saveStudent(student);
	        return "redirect:/eregistra/student/list";
		
	}
	
    @GetMapping(value = {"/eregistra/student/delete/{studentId}"})
    public String deleteBook(@PathVariable Integer studentId, Model model) {
        studentService.deleteStudentById(studentId);
        return "redirect:/eregistra/student/list";
    }

}
