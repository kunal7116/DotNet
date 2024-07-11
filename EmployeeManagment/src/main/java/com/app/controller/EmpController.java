package com.app.controller;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.entity.Department;
import com.app.entity.Employee;
import com.app.exception.CustomException;
import com.app.service.EmpService;


@RestController
@RequestMapping("/employee")
public class EmpController {

	@Autowired
	EmpService empService;
	
	//add emp
	@PostMapping
	public ResponseEntity<?> addEmployee(@RequestBody Employee emp)
	{
		if(emp!= null) {
			empService.addEmp(emp);
			return ResponseEntity.status(200).body("Successfully added");
		}
		return ResponseEntity.status(402).body("Employee not added");
	}
	
	//display emp details
	@GetMapping
	public ResponseEntity<?> displayAll(){
		List<Employee> emp = empService.display();
		if(emp!=null) {
			return ResponseEntity.ok(emp);
		}
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Not found");
	}
	
	//delete emp by id
	@DeleteMapping("{id}")
	public ResponseEntity<?> deleteById(@PathVariable Long id){
		try {
		empService.delete(id);
		return ResponseEntity.status(200).body("Successfully deleted");
		}
		catch(CustomException customException){
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(customException.getMessage());
		}
	}
	
	//update emp
	@PutMapping
	public ResponseEntity<?> updateEmployee(@RequestBody Employee emp){
		if(emp!=null) {
			empService.updateEmp(emp);
			return ResponseEntity.status(200).body("Successfully Updated");
		}
		return ResponseEntity.status(402).body("Unable to update");
	}

	//search emp by dept
	@GetMapping("search/{dept}")
	public ResponseEntity<?> findByDepartment(@PathVariable Department dept){
		List<Employee> emp = empService.findByDept(dept);
		if(emp!=null) {
			return ResponseEntity.ok(emp);
		}
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Not found");
	}
	
	//sort emp by fname
	@GetMapping("/sort")
	public ResponseEntity<?> sortByFname(){
		List <Employee> emp = empService.sortByName();
		if(emp!=null) {
		return	ResponseEntity.ok(emp);
		}
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Not found");
	}
	
	//delete By sal
	@DeleteMapping("deleteBySal/{sal}")
	public void deleteBySal(Double sal) {
		empService.deleteBySal(sal);
	}
	
	//delete By date
	@DeleteMapping("deleteByDate/{date1}/{date2}")
	public void deleteByDate(@PathVariable("date1")@DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate date1, @PathVariable("date2") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate date2)
	{
		empService.deleteByDate(date1, date2);
	}
}
