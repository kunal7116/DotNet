package com.app.repository;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.app.entity.Department;
import com.app.entity.Employee;

@Repository
public interface EmpRepo extends JpaRepository<Employee, Long> {
	
	//finding emp by department
	List<Employee> findEmployeesByDepartment(Department dept);
	
	//sort by firstname
	List<Employee> findAllByOrderByFirstName();
	
	//delete by sal
	@Modifying
    @Transactional
	@Query("Delete from Employee e where e.Salary > :sal")
	void deleteBySal(@Param("sal")Double salary);
	
	@Modifying
	@Transactional
	@Query("Delete from Employee e where e.dateofJoining between :date1 and :date2")
	void deleteByDate(@Param("date1")LocalDate firstDate,@Param("date2") LocalDate secondDate);
}
