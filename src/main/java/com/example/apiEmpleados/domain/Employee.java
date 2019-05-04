package com.example.apiEmpleados.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import lombok.Getter;
import lombok.ToString;

@Entity
@Getter
@ToString
public class Employee {
	
	@Id
	@GeneratedValue
	private long id;

	private String name;
	private String lastname;
	private int dni;
	private String company;
	
//	@ManyToOne
//	@JoinColumn(name="COMPANY_ID")
//	private Company company;
}
