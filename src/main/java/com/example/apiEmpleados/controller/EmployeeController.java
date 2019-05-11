package com.example.apiEmpleados.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.apiEmpleados.domain.Employee;
import com.example.apiEmpleados.service.EmployeeService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
@RequestMapping("/api")
@Api(value = "Employee Managment System")
public class EmployeeController {

	private EmployeeService employeeService;

	@Autowired
	public EmployeeController(final EmployeeService employeeService) {
		this.employeeService = employeeService;
	}

	@ApiOperation(value = "View a list of availables employees", response = List.class)
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Succesfully retrieved list"),
			@ApiResponse(code = 401, message = "You're not authorized to view the resource"),
			@ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden"),
			@ApiResponse(code = 404, message = "The resource you were trying to reach is not found") })
	@GetMapping("/v1/employees")
	public ResponseEntity<List<Employee>> findAllEmployees() {
		return ResponseEntity.ok(employeeService.findAll());
	}

	@ApiOperation(value = "Get an employee by id")
	@GetMapping("/v1/employees/{id}")
	public ResponseEntity<Employee> findEmployeeById(
			@ApiParam(value = "Employee id from which employee object will retrieve", required = true) @PathVariable(value = "id") Long id)
			throws ResourceNotFoundException {
//		Employee employee = employeeService.getEmployeeById(id).orElseThrow(() -> new ResourceNotFoundException("Employee not found"));
		return ResponseEntity.ok(employeeService.getEmployeeById(id));
	}

	@PostMapping("/v1/employees")
	public ResponseEntity<Employee> saveEmployee(@RequestBody Employee employee) {
		return ResponseEntity.ok(employeeService.createOrUpdate(employee));
	}

	@PutMapping("/v1/employees/{id}")
	public ResponseEntity<Employee> updateEmployeeById(@PathVariable(value = "id") Long id,
			@RequestBody Employee employeeDetails) {
		Employee employee = employeeService.getEmployeeById(id);
		employee.setLastname(employeeDetails.getLastname());
		employee.setName(employeeDetails.getName());
		employee.setDni(employeeDetails.getDni());
		return ResponseEntity.ok(employeeService.createOrUpdate(employee));
	}

	@DeleteMapping("/v1/employees/{id}")
	public ResponseEntity<String> removeEmployeeById(@PathVariable(value = "id") Long id) {
		employeeService.deleteEmployee(id);
		return ResponseEntity.ok("The employee has been removed");
	}
}
