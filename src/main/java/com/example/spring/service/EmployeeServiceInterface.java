package com.example.spring.service;

import java.util.List;

import com.example.spring.model.Employee;

public interface EmployeeServiceInterface {
	List<Employee> getAllEmp();
	void save(Employee employee);
	Employee getById(long id);
	void deleteById(long id);
}
