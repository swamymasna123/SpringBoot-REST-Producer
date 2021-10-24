package com.swamy.service;

import java.util.List;

import com.swamy.model.Employee;

public interface IEmployeeService {

	public Integer saveEmployee(Employee employee);
	public List<Employee> getAllEmployees();
	public Employee getOneEmployee(Integer id);
	public void updateEmployee(Employee employee);
	public void deleteEmployee(Integer id);
	public boolean isEmployeeExistsById(Integer id);
}

