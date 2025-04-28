package com.nrt.tms.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import jakarta.persistence.*;
import java.util.List;

//
//@AllArgsConstructor
//@Data
//@Entity
//@NoArgsConstructor
//@Table(name="unit_hrms")
//public class Unit {
//
//	public Unit(Long unitId) {
//		this.unitId=unitId;
//	}
//
//
//	@Id
//	@GeneratedValue
//	private Long unitId;
//
//	@Column(nullable = false,unique = true)
//	private String unitName;
//
//	private String unitDesc;
//
//	@JsonIgnore
//	@ManyToOne(fetch =FetchType.LAZY,cascade = CascadeType.ALL)
//	@JoinColumn(name = "parent_unit_id")
//	private Unit parentUnit;
//
//
//	@JsonIgnore
//	@OneToMany(mappedBy = "unit")
//	private List<UnitData> unitDatas;
//
//	@JsonIgnore
//	@OneToMany(mappedBy = "parentUnit")
//	private List<Unit> childUnits;
//
//
//
//
//
//}
