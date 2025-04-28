package com.nrt.tms.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;



@Entity
@Table(name = "pensioner_type")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class StaffType {
	
	public StaffType(String staffTypeCode) {
		super();
		this.staffTypeCode = staffTypeCode;
	}

	@Id
	@Column(name="pensioner_type_code", length = 3)
	private String staffTypeCode;
	
	@Column(length = 20)
	private String dscr;
}
