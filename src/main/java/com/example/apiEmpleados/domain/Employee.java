package com.example.apiEmpleados.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Entity
@Getter
@Setter
@ToString
@ApiModel(description="All details about the Employee. ")
public class Employee {
	
	@Id
	@GeneratedValue
	@ApiModelProperty(notes="The database generated employee ID")
	private long id;

	@ApiModelProperty(notes="The employee first name")
	private String name;
	
	@ApiModelProperty(notes="The employee last name")
	private String lastname;
	
	@ApiModelProperty(notes="The employee dni")
	private int dni;
	
	@ApiModelProperty(notes="The employee's company")
	private String company;
	
//	@ManyToOne
//	@JoinColumn(name="COMPANY_ID")
//	private Company company;
}
