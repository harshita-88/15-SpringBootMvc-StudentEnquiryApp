package in.harshita.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import in.harshita.binding.Student;
import in.harshita.service.StudentService;

@Controller
public class StudentController {
	@Autowired
	private StudentService service;

	@GetMapping("/")
	public String getStudent(Model model) {
		formInitBinding(model);
		return "index";
	}

	public void formInitBinding(Model model) {
		model.addAttribute("student", new Student());
		model.addAttribute("courses", service.getCourses());
		model.addAttribute("preftimings", service.getTimings());
	}

	@PostMapping("/save")
	public String saveStudent(Student s, Model model) {
		System.out.println(s);
		boolean isSaved = service.saveStudent(s);
		if(isSaved) {
		model.addAttribute("msg", "Data Saved..");
		}
		formInitBinding(model);
		return "index";
	}

}
