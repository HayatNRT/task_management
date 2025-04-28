package com.nrt.tms.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.nrt.tms.entity.id.PensionerGradeId;
import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Entity
@Data
@IdClass(PensionerGradeId.class)
public class PensionerGrade {
	@Id
    @Column(name = "pensioner_type_code", length = 5)
    private String pensionerTypeCode;
	@Id
    @Column(name = "grade_code", length = 5)
    private String gradeCode;

    @Column(name = "dscr", length = 50)
    private String dscr;
    
    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "pensioner_type_code", insertable = false, updatable = false)
    private PensionerType pensionerType;

    @JsonIgnore
    @OneToMany(mappedBy = "pensionerGrade", cascade = CascadeType.ALL)
    private List<PensionerDesignation> pensionerDesignations;
}
