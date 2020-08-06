package com.angular.springboot.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.angular.springboot.exception.UserNotFoundException;
import com.angular.springboot.model.Employee;
import com.angular.springboot.repository.EmployeeRepository;

@Service
public class EmployeeService {
	
	@Autowired
	private EmployeeRepository empRepo;

	public Employee addEmployee(Employee employee)
	{
		return empRepo.save(employee);
	}
	
	public List<Employee> findAllEmployees(){
		return empRepo.findAll();
	}
	
	public Employee updateEmployee(Employee employee)
	{
		return empRepo.save(employee);
	}
	
	public Employee findEmployeeById(Long id)
	{
		return empRepo.findEmployeeById(id).orElseThrow(() -> new UserNotFoundException("user by id"+id+ "was not found"));
	}
	
	public void deleteEmploye(Long id) {
		empRepo.deleteById(id);
	}
}
