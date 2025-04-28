package com.nrt.tms.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Entity
@Table(name="employee_experience")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class EmployeeExperience {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Column(name="employee_id")
	private String employeeId;
	private String organizationName;
	private String jobDesignation;
	private Boolean presentlyWorking;
	@JsonFormat(pattern="dd-MM-yyyy")
	private LocalDate startDate;
	@JsonFormat(pattern="dd-MM-yyyy")
	private LocalDate endDate;
	private String salary;
	private String payLevel;
	private String doc;
}
