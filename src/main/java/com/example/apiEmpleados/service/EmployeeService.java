package com.example.apiEmpleados.service;

import java.util.List;

import com.example.apiEmpleados.domain.Employee;

public interface EmployeeService {

	public List<Employee> findAll();
	public Employee createOrUpdate(Employee employee);
	public Employee getEmployeeById(Long id);
	public void deleteEmployee(Long id);
}
