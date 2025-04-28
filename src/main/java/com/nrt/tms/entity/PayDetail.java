package com.nrt.tms.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.nrt.tms.entity.id.PayDetailId;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;

@Data
@Entity
@Table(name = "employee_pay_details")
@AllArgsConstructor
@NoArgsConstructor
public class PayDetail {

	@EmbeddedId
	PayDetailId payDetailId;
	
	@Column(name = "date_to")
	@JsonFormat(pattern = "dd-MM-yyyy")
	private LocalDate dateTo;
	
	@Column(name = "pension_basic",precision = 10,scale = 2)
	private BigDecimal pensionBasic;
	
	@Column(name = "medical_allowance",precision = 10,scale = 2)
	private BigDecimal medicalAllowance;
	
	@Column(name = "hra",precision = 10,scale = 2)
	private BigDecimal hra;
	
	@Column(name = "reason_code")
    private String reasonCode;
	
	@Column(name = "remarks")
    private String remarks;

	@Column(name = "dml_user_id")
    private String dmlUserId;
	
	@Column(name = "others_allowance",precision = 10,scale = 2)
	private BigDecimal othersAllowance;
	
	@Column(name = "oa_status",length=2)
	private String oaStatus;
	
	@Column(name = "oa_remarks",length=200)
	private String oaRemarks;
	
	@JsonFormat(pattern = "dd-MM-yyyy")
	@Column(name = "oa_effective_till")
	private LocalDate oaEffectiveTill;
	
	@Column(name = "tds",precision = 10,scale = 2)
	private BigDecimal tds;
	
	@Column(name = "tds_status",length=2)
	private String tdsStatus;
	
	@Column(name = "tds_remarks",length=200)
	private String tdsRemarks;
	
	@JsonFormat(pattern = "dd-MM-yyyy")
	@Column(name = "tds_effective_till")
	private LocalDate tdsEffectiveTill;
	
	@Column(name = "f_pen",precision = 10,scale = 2)
	private BigDecimal fPen;
	
	@Column(name = "updated_entry_on")
    private LocalDateTime updatedEntryOn;
	
	
	 @PreUpdate
	    protected void onUpdate() {
	        updatedEntryOn = ZonedDateTime.now(ZoneId.of("Asia/Kolkata")).toLocalDateTime();
	    }
}
