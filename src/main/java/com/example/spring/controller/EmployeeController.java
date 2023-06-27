package com.example.spring.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.spring.model.Employee;
import com.example.spring.service.EmployeeServiceImplementation;

@Controller
public class EmployeeController {
	@Autowired
	EmployeeServiceImplementation employeeServiceImplementation;
	@GetMapping("/index")
	public String viewHomepage(Model model) {
		model.addAttribute("allemplist", employeeServiceImplementation.getAllEmp());
		return "index";
	}
	@GetMapping("/addnew")
	public String addnewEmployee(Model model) {
		Employee employee = new Employee();
		model.addAttribute("employee", employee);
		return "newemployee";
	}
	@PostMapping("/save")
	public String saveEmployee(@ModelAttribute("employee") Employee employee) {
		employeeServiceImplementation.save(employee);
		return "redirect:/index";
	}
	 @GetMapping("/showFormForUpdate/{id}")
	public String updateform(@PathVariable(value="id") long id,Model model) {
		//Employee employee = employeeServiceImpl.getById(id);
		model.addAttribute("employee", employeeServiceImplementation.getById(id));
		return "update";
	}
	 @GetMapping("/deleteEmployee/{id}")
	public String delete(@PathVariable(value="id") long id) {
		employeeServiceImplementation.deleteById(id);
		return "redirect:/index";
	}
}
