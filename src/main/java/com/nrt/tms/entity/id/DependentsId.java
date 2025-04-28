package com.nrt.tms.entity.id;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.Data;

import java.io.Serializable;

@Data
@Embeddable
public class DependentsId implements Serializable {

    private static final long serialVersionUID = 1L;

    @Column(name = "employee_id")
    private String employeeId;


    @Column(name = "dependent_slno", length = 2)
    private Integer dependentSlno;

}
