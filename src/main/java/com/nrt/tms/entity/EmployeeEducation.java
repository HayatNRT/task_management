package com.nrt.tms.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Entity
@Table(name="employee_education")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class EmployeeEducation {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@ManyToOne
	@JoinColumn(name="education_id",referencedColumnName = "id")
	private Education educationId;
	
	@Column(name="employee_id")
	private String employeeId;
	
	private String coursename;
	private String subjects;
	private String passingYear;
	private String percentage;
	private String division;
	private String totalMarks;
	private String board;
	private String institute;
	private String doc;
	
}
