package com.app.dao;

import com.app.pojos.Employee;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface IEmpDao extends JpaRepository<Employee, Integer> {

	@Query("select e from Employee e")
	List<Employee> findAllEmps();
}
