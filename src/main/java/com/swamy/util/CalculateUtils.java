package com.swamy.util;

import org.springframework.stereotype.Component;

import com.swamy.model.Employee;

@Component
public class CalculateUtils {

	public void calculateDataDynamically(Employee employee) {
		Double sal = employee.getEmpSal();
		Double pf = sal * 12.0/100;
		Double esi = sal * 14.0/100;
		employee.setPf(pf);
		employee.setEsi(esi);
	}

	
}
