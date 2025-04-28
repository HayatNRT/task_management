package com.nrt.tms.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Data
@Table(name = "pensioner_type")
@NoArgsConstructor
public class PensionerType {
	
    @Id
    @Column(name = "pensioner_type_code", length = 5, nullable = false)
    private String pensionerTypeCode;

    @Column(name = "dscr", length = 20, nullable = false)
    private String dscr;
    
    @JsonIgnore
    @OneToMany(mappedBy = "pensionerType", cascade = CascadeType.ALL)
    private List<PensionerGrade> pensionerGrades;
    
    @Column(name = "module", length = 20)
    private String module;
    
    public PensionerType(String pensionerTypeCode) {
    	this.pensionerTypeCode=pensionerTypeCode;
    }

}
