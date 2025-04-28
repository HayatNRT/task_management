package com.nrt.tms.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.nrt.tms.entity.id.DependentsId;
import jakarta.persistence.Column;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDate;

@Data
@Entity
@Table(name = "employee_dependents")
//@IdClass(DependentsId.class)
public class Dependents {

//		@Id
    // @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "pensioner_seq")
    //@GeneratedValue(strategy = GenerationType.AUTO)
//		@Column(name = "employee_id" )
//		private String employeeId;

    //@GeneratedValue(strategy = GenerationType.AUTO)
//		@Column(name="dependent_slno",length = 2)
//		private Integer dependentSlNo;

    @EmbeddedId
    private DependentsId dependentsId;

    @Column(name = "dependent_name", length = 50, nullable = false)
    private String dependentName;

    @Column(name = "pension_nominee", length = 1, nullable = false)
    private String pensionNominee;

    @Column(name = "pension_perc", precision = 6, scale = 2)
    private BigDecimal pensionPerc;

    @Column(name = "date_of_birth", nullable = false)
    @JsonFormat(pattern = "dd-MM-yyyy")
    private LocalDate dateOfBirth;

    @Column(name = "pensioner_relation", length = 20, nullable = false)
    private String pensionerRelation;

    @Column(name = "married", length = 1, nullable = false)
    private String married;

    @Column(name = "date_of_marriage")
    @JsonFormat(pattern = "dd-MM-yyyy")
    private LocalDate dateOfMarriage;

    @Column(name = "phy_handicapped_code", length = 2, nullable = false)
    private Integer phyHandicappedCode;

    @Column(name = "dependent_address", length = 100, nullable = false)
    private String dependentAddress;

    @Column(name = "dependent_po", length = 30)
    private String dependentPo;

    @Column(name = "dependent_ps", length = 30)
    private String dependentPs;

    @Column(name = "dependent_city", length = 20, nullable = false)
    private String dependentCity;

    @Column(name = "dependent_state", length = 20, nullable = false)
    private String dependentState;

    @Column(name = "dependent_country", length = 20, nullable = false)
    private String dependentCountry;

    @Column(name = "dependent_pin", length = 6, nullable = false)
    private String dependentPin;

    @Column(name = "minor_dependent", length = 1, nullable = false)
    private String minorDependent;

    @Column(name = "minor_guardian_name", length = 50)
    private String minorGuardianName;

    @Column(name = "minor_guardian_dob")
    @JsonFormat(pattern = "dd-MM-yyyy")
    private LocalDate minorGuardianDob;

    @Column(name = "minor_guardian_address", length = 100)
    private String minorGuardianAddress;

    @Column(name = "minor_guardian_po", length = 30)
    private String minorGuardianPo;

    @Column(name = "minor_guardian_ps", length = 30)
    private String minorGuardianPs;

    @Column(name = "minor_guardian_city", length = 20)
    private String minorGuardianCity;

    @Column(name = "minor_guardian_state", length = 20)
    private String minorGuardianState;

    @Column(name = "minor_guardian_country", length = 20)
    private String minorGuardianCountry;

    @Column(name = "minor_guardian_pin", length = 6)
    private String minorGuardianPin;

    @Column(name = "alternate_nominee_name", length = 50)
    private String alternateNomineeName;

    @Column(name = "alternate_pension_perc", precision = 6, scale = 2)
    private BigDecimal alternatePensionPerc;

    @Column(name = "alternate_nominee_dob")
    @JsonFormat(pattern = "dd-MM-yyyy")
    private LocalDate alternateNomineeDob;

    @Column(name = "alternate_nominee_relation", length = 20)
    private String alternateNomineeRelation;

    @Column(name = "alternate_nominee_address", length = 100)
    private String alternateNomineeAddress;

    @Column(name = "alternate_nominee_po", length = 30)
    private String alternateNomineePo;

    @Column(name = "alternate_nominee_ps", length = 30)
    private String alternateNomineePs;

    @Column(name = "alternate_nominee_city", length = 20)
    private String alternateNomineeCity;

    @Column(name = "alternate_nominee_state", length = 20)
    private String alternateNomineeState;

    @Column(name = "alternate_nominee_country", length = 20)
    private String alternateNomineeCountry;

    @Column(name = "alternate_nominee_pin", length = 6)
    private String alternateNomineePin;

    @Column(name = "alternate_nominee_minor", length = 1)
    private String alternateNomineeMinor;

    @Column(name = "alternate_nom_guardian_name", length = 50)
    private String alternateNomGuardianName;

    @Column(name = "alternate_nom_guard_dob")
    @JsonFormat(pattern = "dd-MM-yyyy")
    private LocalDate alternateNomGuardDob;

    @Column(name = "alternate_nom_guard_address", length = 100)
    private String alternateNomGuardAddress;

    @Column(name = "alternate_nom_guard_po", length = 30)
    private String alternateNomGuardPo;

    @Column(name = "alternate_nom_guard_ps", length = 30)
    private String alternateNomGuardPs;

    @Column(name = "alternate_nom_guard_city", length = 20)
    private String alternateNomGuardCity;

    @Column(name = "alternate_name_guard_state", length = 20)
    private String alternateNameGuardState;

    @Column(name = "alternate_name_guard_country", length = 20)
    private String alternateNameGuardCountry;

    @Column(name = "alternate_name_guard_pin", length = 6)
    private String alternateNameGuardPin;

    @Column(name = "dependent_valid", length = 1, nullable = false)
    private String dependentValid;

    @Column(name = "dml_user_id", length = 10, nullable = false)
    private String dmlUserId;
}
