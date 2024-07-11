package com.app.entity;

import java.time.LocalDate;
import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
@Table(name = "employee")
public class Employee {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@NotBlank
	private String firstName;
	
	@NotBlank
	private String lastName;
	
	@Enumerated(EnumType.STRING)
	private Department department;
	
	@NotNull(message = "Time cannot be null")
	private LocalDateTime timeOfJoining;
	
	@NotNull(message="Date cannot be null")
	private LocalDate dateofJoining;
	
	@NotBlank
	private String email;
	
	@NotBlank
	private String mobNum;
	
	@NotBlank
	private String Address;
	
	@NotNull
	private Double Salary;
	

}
