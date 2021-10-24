package com.swamy.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.swamy.model.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Integer> {

}
