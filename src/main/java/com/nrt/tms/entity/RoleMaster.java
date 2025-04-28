package com.nrt.tms.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;



@Entity
@Data
@Table(name = "role_master")
@NoArgsConstructor
@AllArgsConstructor
public class RoleMaster {

	@Id
	@Column(name = "role_code")
    private String roleCode;

	@Column(name = "dscr")
    private String dscr;

}
