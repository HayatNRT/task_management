package com.nrt.tms.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.nrt.tms.entity.id.PensionerDesignationId;
import jakarta.persistence.*;
import lombok.Data;



@Entity
@Data
@IdClass(PensionerDesignationId.class)
@Table(name="pensioner_designation")
public class PensionerDesignation {
	
		@Column(name = "designation_id", length = 5)
	   	private Long designationId;
	
	   	@Id
	    @Column(name = "pensioner_type_code", length = 5)
	    private String pensionerTypeCode;
	   	
	   	@Id
	    @Column(name = "grade_code", length = 5)
	    private String gradeCode;
	   	@Id
	    @Column(name = "desig_short_name", length = 15)
	    private String desigShortName;

	    @Column(name = "dscr", length = 50)
	    private String dscr;

	   
	    @JsonIgnore
	    @ManyToOne
	    @JoinColumns({
	        @JoinColumn(name = "pensioner_type_code", referencedColumnName = "pensioner_type_code", insertable = false, updatable = false),
	        @JoinColumn(name = "grade_code", referencedColumnName = "grade_code", insertable = false, updatable = false)
	    })
	    private PensionerGrade pensionerGrade;
	    
	    @ManyToOne
	    @JoinColumn(name="emp_type",referencedColumnName = "pensioner_type_code")
	    private PensionerType employeeType;
	    
	    private String departmentCode;
	
}
