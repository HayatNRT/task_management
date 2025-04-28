package com.nrt.tms.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "employee2")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Employee implements Serializable {
    public Employee(String employeeId) {
        this.employeeId = employeeId;
    }

    @Id
//	@GenericGenerator(name="emp_id_seq", strategy = "com.hrms.model.generator.EmpIdGenerator")
//	@GeneratedValue(generator = "emp_id_seq")
    @Column(name = "employee_id")
    private String employeeId;

    @Column(name = "pensioner_id")
    private String pensionerId;


    @Column(name = "ru_slno")
    private Double ruSlno;

    @Column(name = "prefix")
    private String prefix;

    @Column(name = "employee_name")
    private String employeeName;

    @Column(name = "sex")
    private String sex;

    @Column(name = "date_of_birth")
    @JsonFormat(pattern = "dd-MM-yyyy")
    @DateTimeFormat(pattern = "dd-MM-yyyy")
    private LocalDate dateOfBirth;

    @Column(name = "father_name")
    private String fatherName;

    @Column(name = "university_code")
    private String universityCode;

    @Column(name = "college_code")
    private String collegeCode;

    @Column(name = "department_code")
    private String departmentCode;

    @Column(name = "pensioner_type_code")
    private String pensionerTypeCode;

    @Column(name = "grade_code")
    private String gradeCode;

    @Column(name = "desig_short_name")
    private String desigShortName;

    @ManyToOne
    @JoinColumn(name = "subject_code", referencedColumnName = "subject_code")
    private Subject subjectCode;

    @Column(name = "date_of_last_appointment")
    @JsonFormat(pattern = "dd-MM-yyyy")
    private LocalDate dateOfLastAppointment;

    @Column(name = "date_of_regularisation")
    @JsonFormat(pattern = "dd-MM-yyyy")
    private LocalDate dateOfRegularisation;

    @Column(name = "pay_commission_code")
    private String payCommissionCode;

    @Column(name = "date_of_separation")
    @JsonFormat(pattern = "dd-MM-yyyy")
    private LocalDate dateOfSeparation;

    @Column(name = "pensioner_univ_id")
    private String pensionerUnivId;

    @Column(name = "pensioner_name")
    private String pensionerName;

    @Column(name = "pensioner_relation")
    private String pensionerRelation;

    @Column(name = "ppo_no")
    private String ppoNo;

    @Column(name = "aadhaar")
    private String aadhaar;

    @Column(name = "pan")
    private String pan;

    @Column(name = "pan_record")
    private String panRecord;

    @Column(name = "mobile_no")
    private String mobileNo;

    @Column(name = "whats_app_mobile_no")
    private String whatsAppMobileNo;

    @Column(name = "email_id")
    private String emailId;

    @Column(name = "date_of_death")
    @JsonFormat(pattern = "dd-MM-yyyy")
    private LocalDate dateOfDeath;

    @Column(name = "rate_of_pension")
    private Double rateOfPension;

    @Column(name = "pensioner_status_code")
    private Integer pensionerStatusCode;

    @Column(name = "status_from_date")
    @JsonFormat(pattern = "dd-MM-yyyy")
    private LocalDate statusFromDate;

    @Column(name = "inserted_on")
    @JsonFormat(pattern = "dd-MM-yyyy HH:mm:ss")
    private LocalDateTime insertedOn;

    @Column(name = "user_id_maker")
    private String userIdMaker;

    @Column(name = "verified_on")
    @JsonFormat(pattern = "dd-MM-yyyy HH:mm:ss")
    private LocalDateTime verifiedOn;

    @Column(name = "user_id_checker")
    private String userIdChecker;

    @Column(name = "updated_on")
    @JsonFormat(pattern = "dd-MM-yyyy HH:mm:ss")
    private LocalDateTime updatedOn;

    @Column(name = "user_id_updater")
    private String userIdUpdater;

    @Column(name = "remarks")
    private String remarks;

    @Column(name = "stopped_on")
    @JsonFormat(pattern = "dd-MM-yyyy HH:mm:ss")
    private LocalDateTime stoppedOn;

    @Column(name = "stopped_by")
    private String stoppedBy;

    @Column(name = "stop_remarks")
    private String stopRemarks;

    @Column(name = "religion_name")
    private String religionName;

    @Column(name = "addr1")
    private String addr1;

    @Column(name = "addr2")
    private String addr2;

    @Column(name = "addr3")
    private String addr3;

    @Column(name = "city")
    private String city;

    @Column(name = "state")
    private String state;

    @Column(name = "pin")
    private String pin;

    @Column(name = "country")
    private String country;


    @Column(name = "designation_id", length = 5)
    private Long designationId;

    @Column(name = "department_id", length = 5)
    private Long departmentIds;

    @Column(name = "staff_pensioner_id", length = 15)
    private String staffPensionerId;

    @Column(name = "dependent_slno", length = 2)
    private String dependentSlno;

    @Column(name = "dih_status", length = 2)
    private String dihStatus;

    @Column(name = "working_status", length = 2)
    private String workingStatus;

    @Column(name = "working_clg_dep_remark")
    private String workingClgDepRemark;

    @Column(name = "working_post_remark")
    private String workingPostRemark;

    @Column(name = "college_category")
    private String collegeCategory;

    private String nationality;

    private String corAddressLine1;
    private String corAddressLine2;
    private String corAddressLine3;
    private String corCity;
    private String corDistrict;
    private String corState;
    private Integer corPincode;
    private String perAddressLine1;
    private String perAddressLine2;
    private String perAddressLine3;
    private String perCity;
    private String perDistrict;
    private String perState;
    private Integer perPincode;
    private String identificationType;
    private String idNumber;
    private Long mobileNo2;
    private Long emergencyNo;
    private String departmentDscr;
    private String designationDscr;

    @ManyToOne
    @JoinColumn(name = "employee_type", referencedColumnName = "pensioner_type_code")
    private PensionerType employeeType;

    @ManyToOne
    @JoinColumn(name = "post_type", referencedColumnName = "postTypeCode")
    private EmployeePostType postType;

    @JsonFormat(pattern = "dd-MM-yyyy")
    private LocalDate joiningDate;
    private Integer joiningAge;


    private LocalDate retirementDate;
    private Integer retirementAge;
    @JsonFormat(pattern = "dd-MM-yyyy")
    private LocalDate lastWorkingDate;
    private String section;
    private String empRemark;
    private String empStatus;
    @Column(name = "employee_code", unique = true, nullable = false)
    private String employeeCode;
    private String motherName;
    private String bloodGroup;
    private String categoryCode;
    private String identificationMark;
    private String maritalStatus;
    private LocalDate nameChangeDate;
    private String nameChangeReason;
    private String prevFullName;
    private String spouseName;

    @ManyToOne(optional = true)
    @JoinColumn(name = "staff_no_reporting_officer", referencedColumnName = "employee_id")
    private Employee reportingOfficer;

    private String divyangStatus;
    private String divyangPercent;
    private String residentialOfState;
    private String residentialDoc;
    private String castDoc;
    private String profileImage;
    private String profileSignature;
    private String aadharDoc;
    private String panDoc;
    private String createdBy;
    private Boolean locationUpdatable;
    private String map_let;
    private String map_lng;
    private String tabTrack;
    private Boolean isManager;
    private String managerType;

    @ManyToOne
    @JoinColumn(name = "divyang_type", referencedColumnName = "phy_handicapped_code")
    private PhyHandicapped divyangType;

    //@OneToMany(mappedBy = "payDetailId.pensioner",cascade = CascadeType.ALL)
    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "employee_id")
    private List<EmployeeEducation> educations;


    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "employee_id")
    private List<EmployeeExperience> experiences;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "employee_id")
    private List<Dependents> dependents;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "employee_id")
    private List<PensionerAccount> bankDetails;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "employee_id")
    private List<PayDetail> payDetail;

    @ManyToOne
    @JoinColumn(name = "staff_type_code")
    private StaffType staffType;

    private LocalDate confirmationDate;
}
