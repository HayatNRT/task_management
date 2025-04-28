package com.nrt.tms.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import jakarta.persistence.*;
import java.util.List;
//
//@AllArgsConstructor
//@NoArgsConstructor
//@Entity
//@Data
////@Table(name= "unit_data_hrms", uniqueConstraints = {@UniqueConstraint(name = "UniqueNameAndParent",columnNames = {"dataName","parent_data_id"})})
//public class UnitData {
//
//	public UnitData(Long r) {
//		this.dataId=r;
//	}
//
//	@Id
//	@GeneratedValue
//	private Long dataId;
//
//	private String dataName;
//
//	@OneToOne()
//	private ApplicationUser head;
//
//	private String DataDesc;
//
//	@ManyToOne
//	private Unit unit;
//
//	@JsonIgnore
//	@ManyToOne(fetch = FetchType.LAZY)
//	@JoinColumn(name = "parent_data_id")
//	private UnitData parentUnitData;
//
//	@JsonIgnore
//	@OneToMany(mappedBy = "unitData")
//	List<ApplicationUser> users;
//
//	@JsonIgnore
//	@OneToMany(mappedBy = "parentUnitData")
//	List<UnitData> childUnitDatas;
//
////	@ManyToMany
////	List<Role> roles;
//
//}

