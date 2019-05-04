package com.example.apiEmpleados.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.example.apiEmpleados.domain.Employee;

public interface EmployeeRepository extends CrudRepository<Employee, Long> {
	
	public List<Employee> findAll();
}
