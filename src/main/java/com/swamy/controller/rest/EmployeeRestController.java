package com.swamy.controller.rest;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
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

import com.swamy.model.Employee;
import com.swamy.service.IEmployeeService;

@RestController
@RequestMapping("/employee")
public class EmployeeRestController {

	private static final Logger LOG = LoggerFactory.getLogger(EmployeeRestController.class);

	@Autowired
	private IEmployeeService employeeService;

	//*******************SAVE EMPLOYEE*********************//
	@PostMapping
	public ResponseEntity<String>saveEmployee(@RequestBody Employee employee){
		ResponseEntity<String>resp = null;
		String message = null;
		try {
			LOG.info("ENTERED INTO SAVE EMPLOYEE METHOD");
			Integer id = employeeService.saveEmployee(employee);
			if(id!=null) {
				message = "Employee '"+id+"' Data Saved";
				LOG.info("EMPLOYEE '"+id+"' DATA SAVED");
				resp = new ResponseEntity<String>(message, HttpStatus.CREATED);
			}
			else {
				message = "Employee Data Not Saved";
				LOG.info("EMPLOYEE DATA NOT SAVED");
				resp = new ResponseEntity<String>(message, HttpStatus.BAD_REQUEST);
			}
		} catch (Exception e) {
			message = "Unable to Save Employee Data";
			LOG.error("UNABLE TO SAVE EMPLOYEE DATA");
			resp = new ResponseEntity<String>(message, HttpStatus.INTERNAL_SERVER_ERROR);
			e.printStackTrace();
		}
		LOG.info("RETURNING BACK FROM SAVE EMPLOYEE METHOD");
		return resp;
	}

	//*******************FETCH ALL EMPLOYEES*********************//
	@GetMapping
	public ResponseEntity<?>getAllEmployees(){
		ResponseEntity<?>resp = null;
		String message = null;
		try {
			LOG.info("ENTERED INTO GET ALL EMPLOYEES METHOD");
			List<Employee> list = employeeService.getAllEmployees();
			if(list!=null) {
				LOG.info("EMPLOYEE OBJECTS HAS BEEN SELECTED");
				resp = new ResponseEntity<List<Employee>>(list, HttpStatus.OK);
			}
			else {
				message = "Employees Data Not Found";
				LOG.info("EMPLOYEES DATA NOT FOUND");
				resp = new ResponseEntity<String>(message, HttpStatus.BAD_REQUEST);
			}
		} catch (Exception e) {
			message = "Unable to Fetch Employees Data";
			LOG.error("UNABLE TO FETCH EMPLOYEES DATA");
			resp = new ResponseEntity<String>(message, HttpStatus.INTERNAL_SERVER_ERROR);
			e.printStackTrace();
		}
		LOG.info("RETURNING BACK FROM GET ALL EMPLOYEES METHOD");
		return resp;
	}

	//*******************GET ONE EMPLOYEE*********************//
	@GetMapping("/{id}")
	public ResponseEntity<?>getOneEmployee(@PathVariable Integer id){
		ResponseEntity<?>resp = null;
		String message = null;
		try {
			LOG.info("ENTERED INTO GET ONE EMPLOYEE METHOD");
			Employee empObj = employeeService.getOneEmployee(id);
			if(empObj!=null) {
				LOG.info("EMPLOYEE OBJECT HAS BEEN SELECTED");
				resp = new ResponseEntity<Employee>(empObj, HttpStatus.OK);
			}
			else {
				message = "Employee Data Not Found";
				LOG.info("EMPLOYEE DATA NOT FOUND");
				resp = new ResponseEntity<String>(message, HttpStatus.BAD_REQUEST);
			}
		} catch (Exception e) {
			message = "Unable to Fetch Employee Data";
			LOG.error("UNABLE TO FETCH EMPLOYEE DATA");
			resp = new ResponseEntity<String>(message, HttpStatus.INTERNAL_SERVER_ERROR);
			e.printStackTrace();
		}
		LOG.info("RETURNING BACK FROM GET ONE EMPLOYEE METHOD");
		return resp;
	}


	//*******************DELETE ONE EMPLOYEE*********************//
	@DeleteMapping("/{id}")
	public ResponseEntity<String>deleteOneEmployee(@PathVariable Integer id){
		ResponseEntity<String>resp = null;
		String message = null;
		try {
			LOG.info("ENTERED INTO DELETE EMPLOYEE METHOD");
			Employee empObj = employeeService.getOneEmployee(id);
			if(empObj!=null) {
				employeeService.deleteEmployee(id);
				message = "Employee Data '"+id+"' Deleted Successfully";
				LOG.info("EMPLOYEE DATA '"+id+"' DELETED SUCCESSFULLY");
				resp = new ResponseEntity<String>(message, HttpStatus.OK);
			}
			else {
				message = "Employee Data Not Found to Delete";
				LOG.info("EMPLOYEE DATA NOT FOUND TO DELETE");
				resp = new ResponseEntity<String>(message, HttpStatus.BAD_REQUEST);
			}
		} catch (Exception e) {
			message = "Unable to Delete Employee Data";
			LOG.error("UNABLE TO DELETE EMPLOYEE DATA");
			resp = new ResponseEntity<String>(message, HttpStatus.INTERNAL_SERVER_ERROR);
			e.printStackTrace();
		}
		LOG.info("RETURNING BACK FROM DELETE EMPLOYEE METHOD");
		return resp;
	}


	//*******************UPDATE EMPLOYEE *********************//
	@PutMapping
	public ResponseEntity<String>updateEmployee(@RequestBody Employee employee){
		ResponseEntity<String>resp = null;
		String message = null;
		try {
			LOG.info("ENTERED INTO UPDATE EMPLOYEE METHOD");
			boolean flag = employeeService.isEmployeeExistsById(employee.getEmpId());	
			if(flag) {
				employeeService.updateEmployee(employee);
				message = "Employee Data '"+employee.getEmpId()+"' Updated Successfully";
				LOG.info("EMPLOYEE DATA '"+employee.getEmpId()+"' UPDATED SUCCESSFULLY");
				resp = new ResponseEntity<String>(message, HttpStatus.OK);
			}
			else {
				message = "Employee Data Not Found to Update";
				LOG.info("EMPLOYEE DATA NOT FOUND TO UPDATE");
				resp = new ResponseEntity<String>(message, HttpStatus.BAD_REQUEST);
			}
		} catch (Exception e) {
			message = "Unable to Update Employee Data";
			LOG.error("UNABLE TO UPDATE EMPLOYEE DATA");
			resp = new ResponseEntity<String>(message, HttpStatus.INTERNAL_SERVER_ERROR);
			e.printStackTrace();
		}
		LOG.info("RETURNING BACK FROM UPDATE EMPLOYEE BY ID METHOD");
		return resp;
	}


	//*******************UPDATE EMPLOYEE BY ID*********************//
	@PutMapping("/{id}")
	public ResponseEntity<String>updateOneEmployee(@PathVariable Integer id, @RequestBody Employee employee){
		ResponseEntity<String>resp = null;
		String message = null;
		try {
			LOG.info("ENTERED INTO UPDATE EMPLOYEE METHOD");
			boolean flag = employeeService.isEmployeeExistsById(id);	
			if(flag) {
				employeeService.updateEmployee(employee);
				message = "Employee Data '"+id+"' Updated Successfully";
				LOG.info("EMPLOYEE DATA '"+id+"' UPDATED SUCCESSFULLY");
				resp = new ResponseEntity<String>(message, HttpStatus.OK);
			}
			else {
				message = "Employee Data Not Found to Update";
				LOG.info("EMPLOYEE DATA NOT FOUND TO UPDATE");
				resp = new ResponseEntity<String>(message, HttpStatus.BAD_REQUEST);
			}
		} catch (Exception e) {
			message = "Unable to Update Employee Data";
			LOG.error("UNABLE TO UPDATE EMPLOYEE DATA");
			resp = new ResponseEntity<String>(message, HttpStatus.INTERNAL_SERVER_ERROR);
			e.printStackTrace();
		}
		LOG.info("RETURNING BACK FROM UPDATE EMPLOYEE BY ID METHOD");
		return resp;
	}
}

