package com.nrt.tms.entity;


import com.fasterxml.jackson.annotation.JsonFormat;
import com.nrt.tms.entity.id.PensionerAccountId;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "employee_account")
public class PensionerAccount{

	@EmbeddedId
    PensionerAccountId pensionerAccountId;
	
	@Column(name = "account_effective_to")
	@JsonFormat(pattern = "dd-MM-yyyy")
    private LocalDate accountEffectiveTo;

    @Column(name = "ifsc_code", length = 20)
    private String ifscCode;

    @Column(name = "branch_name", length = 30)
    private String branchName;

    @Column(name = "branch_city", length = 30)
    private String branchCity;

    @Column(name = "state", length = 20)
    private String state;
    
    @Column(name = "remarks")
    private String remarks;
	
    @UpdateTimestamp
    @Column(name = "updated_entry_on",insertable = false)
    private LocalDateTime updatedEntryOn;
    
    @Column(name = "bank_passbook")
    private String bankPassbook;
	
	 @PreUpdate
	    protected void onUpdate() {
	        updatedEntryOn = ZonedDateTime.now(ZoneId.of("Asia/Kolkata")).toLocalDateTime();
	    }

}
