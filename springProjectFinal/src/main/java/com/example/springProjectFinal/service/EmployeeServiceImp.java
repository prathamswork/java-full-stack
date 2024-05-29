package com.example.springProjectFinal.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.springProjectFinal.entity.Employee;
import com.example.springProjectFinal.repository.EmployeeRepository;


@Service
public class EmployeeServiceImp implements EmployeeService{


	@Autowired
	private EmployeeRepository emprepo;
	
	@Override
	public List<Employee> getAll() {
		List<Employee> findAll=emprepo.findAll();
		// TODO Auto-generated method stub
		return findAll;
	}

	@Override
	public Employee saveEmp(Employee emp) {
		// TODO Auto-generated method stub
		return emprepo.save(emp);
	}

	@Override
	public Employee updateEmp(Employee emp) {
		// TODO Auto-generated method stub
		return emprepo.save(emp);
	}

	@Override
	public void deleteEmp(long id) {
		// TODO Auto-generated method stub
		emprepo.deleteById(id);
	}

	@Override
	public Employee findById(long id) {
		Optional<Employee> findbyid=emprepo.findById(id);
		Employee employee=findbyid.get();
		// TODO Auto-generated method stub
		return employee;
	}

}
