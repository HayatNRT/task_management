package com.nrt.tms.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@Entity
@Table(name = "employee_post_type")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class EmployeePostType {
	public EmployeePostType(String postTypeCode) {
		this.postTypeCode=postTypeCode;
	}
	
	@Id
	@Column(length = 3)
	private String postTypeCode;
	
	@Column(length = 20)
	private String postTypeDscr;
}
