package com.swamy.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "employee_table")
public class Employee {

	@Id
	@Column(name = "employee_id_col")
	@GeneratedValue(generator = "mygen")
	@GenericGenerator(name = "mygen" , strategy = "com.swamy.generator.EmpIdGenerator")
	private Integer empId;

	@Column(name = "employee_name_col")
	private String empName;
	
	@Column(name = "employee_sal_col")
	private Double empSal;
	
	@Column(name = "employee_pf_col")
	private Double pf;
	
	@Column(name = "employee_esi_col")
	private Double esi;
}
