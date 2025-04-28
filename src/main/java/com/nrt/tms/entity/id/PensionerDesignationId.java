package com.nrt.tms.entity.id;

import jakarta.persistence.Column;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PensionerDesignationId implements Serializable {
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
    @Id
    @Column(name = "desig_short_name", length = 15)
    private String desigShortName;

}
