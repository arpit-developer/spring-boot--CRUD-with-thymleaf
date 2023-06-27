package com.example.spring.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.spring.model.Employee;
import com.example.spring.repository.EmployeeRepository;
@Service
public class EmployeeServiceImplementation implements EmployeeServiceInterface{

	@Autowired
	EmployeeRepository employeeRepository;
	@Override
	public List<Employee> getAllEmp() {
		
		return employeeRepository.findAll();
	}

	@Override
	public void save(Employee employee) {
		employeeRepository.save(employee);
	}

	@Override
	public Employee getById(long id) {
		Optional<Employee> opt = employeeRepository.findById(id);
		Employee employee = null;
		if(opt.isPresent()) {
			employee = opt.get();
		}
		else {
			throw new RuntimeException("Employee not found for id"+id);
		}
		return employee;
	}

	@Override
	public void deleteById(long id) {
		employeeRepository.deleteById(id);
	}

}
