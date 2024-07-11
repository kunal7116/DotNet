package com.app.service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.entity.Department;
import com.app.entity.Employee;
import com.app.exception.CustomException;
import com.app.repository.EmpRepo;

@Service
@Transactional
public class EmpServiceImpl implements EmpService {

	@Autowired
	EmpRepo empRepo;
	
	@Override
	public void addEmp(Employee emp) {
		empRepo.save(emp);
	}

	@Override
	public List<Employee> display() {
		return empRepo.findAll();
		 
	}

	@Override
	public void delete(Long id) {
		if(!empRepo.existsById(id)) {
			throw new CustomException("Id Not found");
		}
		empRepo.deleteById(id);
	}

	@Override
	public void updateEmp(Employee emp) {
		Optional<Employee> existingEmp = empRepo.findById(emp.getId()); 
		if(existingEmp!=null) {
			empRepo.save(emp);
		}
	}

	@Override
	public List<Employee> findByDept(Department dept) {
		// TODO Auto-generated method stub
		return empRepo.findEmployeesByDepartment(dept);
	}

	@Override
	public List<Employee> sortByName() {
		// TODO Auto-generated method stub
		return empRepo.findAllByOrderByFirstName();
	}

	@Override
	public void deleteBySal(Double salary) {
		empRepo.deleteBySal(salary);
		
	}

	@Override
	public void deleteByDate(LocalDate date1, LocalDate date2) {
		empRepo.deleteByDate(date1, date2);
		
	}

}
