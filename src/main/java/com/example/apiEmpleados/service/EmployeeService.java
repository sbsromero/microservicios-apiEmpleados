package com.example.apiEmpleados.service;

import java.util.List;

import com.example.apiEmpleados.domain.Employee;

public interface EmployeeService {

	public List<Employee> findAll();
	public Employee save(Employee employee);
	public Employee getEmployeeById(Long id);
	public Employee updateEmployee(Employee employee);
	public void deleteEmployee(Long id);
}
