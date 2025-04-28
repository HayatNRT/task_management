package com.nrt.tms.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@Table(name="education")
@AllArgsConstructor
@NoArgsConstructor
public class Education {

    public Education(Long id) {
        this.id=id;
    }

    @Id
    private Long id;
    private String name;
    private String description;
}