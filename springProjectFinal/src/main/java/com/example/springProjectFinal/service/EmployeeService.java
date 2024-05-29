package com.example.springProjectFinal.service;

import java.util.List;

import com.example.springProjectFinal.entity.Employee;



public interface EmployeeService {
	
	public List<Employee> getAll();
	public Employee saveEmp(Employee emp);
	public Employee updateEmp(Employee emp);
	public Employee findById(long id);
	public void deleteEmp(long id);

}
