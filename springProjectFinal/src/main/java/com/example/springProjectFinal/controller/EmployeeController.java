package com.example.springProjectFinal.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.springProjectFinal.entity.Employee;
import com.example.springProjectFinal.service.EmployeeService;

import jakarta.validation.Valid;



@Controller
public class EmployeeController {
	@Autowired
	private EmployeeService empservice;
	
	//Create Operation
			@GetMapping("/create")
			public String saveEmployee(Model model) {
				model.addAttribute("employee", new Employee());
				return "addemp" ;	
			}
			
			@PostMapping("/saveemployee")
			public String getStatus(@Valid @ModelAttribute("employee") Employee employee, BindingResult bindResult) {
				if(bindResult.hasErrors()) {
					return "addemp";
				}
				empservice.saveEmp(employee);
				return "redirect:/read";
			}
			
			//Read Operation
			@GetMapping("/read")
			public String displayAllEmployee(Model model){
				List<Employee> employeelist =empservice.getAll();
				model.addAttribute("employee", employeelist );
				return "employees";
			}
			
			//Delete Operation
			@PostMapping("/employee/delete")
			public String deleteEmp(@RequestParam("id") int empID, Model model) {
				empservice.deleteEmp(empID);
				String deleteMessage ="Employee succesfully deleated with ID:"+empID;
				model.addAttribute("message", deleteMessage);
				return "redirect:/read";
			}
			
			//Update Operation
			@GetMapping("/employee/update")
			public String updateEmp(@RequestParam("id") int id, Model model) {
				Employee employee =empservice.findById(id);
				model.addAttribute("employee", employee);
				return "updateForm";		
			}
			
			@PostMapping("/saveupdate")
			public String getUpdate(@Valid @ModelAttribute("employee") Employee employee, BindingResult bindresult) {
				System.out.println(bindresult.getAllErrors());
				if(bindresult.hasErrors()) {
					return "updateForm";
				}
				empservice.updateEmp(employee);
				return "redirect:/read";
				
			
	
	

}
}
