package com.nrt.tms.entity.id;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.time.LocalDate;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Embeddable
public class PensionerAccountId implements Serializable{
	
	private static final long serialVersionUID = 1L;

//	@ManyToOne
//	@JoinColumn(name = "pensioner_id")
//	private Pensioner pensioner;
	
	@Column(name="employee_id", nullable=false)
	private String employeeId;
	
	@Column(name = "bank_code", length = 10)
    private String bankCode;
	
	@Column(name = "account_effective_from")
	@JsonFormat(pattern = "dd-MM-yyyy")
    private LocalDate accountEffectiveFrom;

    @Column(name = "account_no", length = 20)
    private String accountNo;
}
