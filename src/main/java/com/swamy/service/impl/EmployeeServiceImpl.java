package com.swamy.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.swamy.exception.EmployeeNotFoundException;
import com.swamy.model.Employee;
import com.swamy.repo.EmployeeRepository;
import com.swamy.service.IEmployeeService;
import com.swamy.util.CalculateUtils;

@Service
@Transactional
public class EmployeeServiceImpl implements IEmployeeService {

	@Autowired
	private EmployeeRepository employeeRepository;
	
	@Autowired
	private CalculateUtils calculateUtils;
	
	@Override
	public Integer saveEmployee(Employee employee) {
		calculateUtils.calculateDataDynamically(employee);
		
		Integer empId = employeeRepository.save(employee).getEmpId();
		return empId;
	}

	@Override
	public List<Employee> getAllEmployees() {
		return employeeRepository.findAll();
	}

	@Override
	public Employee getOneEmployee(Integer id) {
		Employee employee = null;
//		return employeeRepository.findById(id).get();
		Optional<Employee> opt = employeeRepository.findById(id);
		if(!opt.isPresent()) {
			throw new EmployeeNotFoundException("Employee '"+id+"' Not Exists");
		}
		return opt.get();
	}

	@Override
	public void deleteEmployee(Integer id) {
		employeeRepository.deleteById(id);
	}
	
	@Override
	public void updateEmployee(Employee employee) {
		calculateUtils.calculateDataDynamically(employee);
		employeeRepository.save(employee);
	}

	@Override
	public boolean isEmployeeExistsById(Integer id) {
		return employeeRepository.existsById(id);
	}

}

