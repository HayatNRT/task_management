package com.nrt.tms.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;



@Entity
@Data
@Table(name = "subject")
@NoArgsConstructor
public class Subject {
	
	public Subject(String subjectCode) {
		this.subjectCode = subjectCode;
	}

	@Id
 	@Column(name = "subject_code", length = 15,nullable=false)
	private String subjectCode;
	
	@Column(name = "dscr", length = 15,nullable=false)
	private String dscr;
}
