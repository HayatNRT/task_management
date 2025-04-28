package com.nrt.tms.entity.id;


import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@AllArgsConstructor
@NoArgsConstructor
@Embeddable
@Data
public class PensionerGradeId implements Serializable {
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@Column(name = "pensioner_type_code", length = 5)
    private String pensionerTypeCode;

	@Id
    @Column(name = "grade_code", length = 5)
    private String gradeCode;

   
}
