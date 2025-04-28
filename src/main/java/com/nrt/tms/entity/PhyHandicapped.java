package com.nrt.tms.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

import java.math.BigDecimal;

@Entity
@Data
@Table(name = "phy_handicapped")
public class PhyHandicapped {
	
	public PhyHandicapped() {
		super();
		// TODO Auto-generated constructor stub
	}

	public PhyHandicapped(Long phyHandicappedCode) {
		this.phyHandicappedCode = phyHandicappedCode;
	}
	
	@Id
//	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "phy_handicapped_code")
	private Long phyHandicappedCode;
	
	@Column(name="handicap_type")
	private String handicapType;
	
	@Column(name = "allowable_perc")
	private BigDecimal allowablePerc;
	
	@Column(name = "dscr")
	private String dscr;

}
