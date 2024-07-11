package com.app.service;

import java.time.LocalDate;
import java.util.List;

import com.app.entity.Department;
import com.app.entity.Employee;

public interface EmpService {
	//add emp
	void addEmp(Employee emp);
	
	//display emp
	List<Employee> display();
	
	//delete by id
	void delete(Long id);
	
	//update emp
	void updateEmp(Employee emp);
	
	//get by dept
	List<Employee> findByDept(Department dept);
	
	//sort by name
	List<Employee> sortByName();
	
	//delete by sal greater than sal given by user
	void deleteBySal(Double salary);
	
	//delete By Date
	void deleteByDate(LocalDate date1,LocalDate date2);

}


