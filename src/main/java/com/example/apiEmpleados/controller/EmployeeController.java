package com.example.apiEmpleados.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.apiEmpleados.domain.Employee;
import com.example.apiEmpleados.service.EmployeeService;

@RestController
@RequestMapping("/api")
public class EmployeeController {

	private EmployeeService employeeService;

	@Autowired
	public EmployeeController(final EmployeeService employeeService) {
		this.employeeService = employeeService;
	}

	@GetMapping
	public ResponseEntity<List<Employee>> findAllEmployees() {
		return ResponseEntity.ok(employeeService.findAll());
	}

	@PostMapping("/v1/employees")
	public ResponseEntity<Employee> saveEmployee(@RequestBody Employee employee) {
		return ResponseEntity.ok(employeeService.save(employee));
	}
	
	@GetMapping("/v1/employees/{id}")
	public ResponseEntity<Employee> findEmployeeById(@PathVariable( value = "id") Long id) {
		return ResponseEntity.ok(employeeService.getEmployeeById(id));
	}
	
	@DeleteMapping("/v1/employees/{id}")
	public ResponseEntity<String> removeEmployeeById(@PathVariable(value="id") Long id){
		employeeService.deleteEmployee(id);
		return ResponseEntity.ok("The employee has been removed");
	}
}
