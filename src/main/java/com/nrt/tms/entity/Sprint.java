package com.nrt.tms.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Entity
@Setter
@Getter
public class Sprint extends BaseEntity {
    private String name;
    private LocalDate startDate;
    private LocalDate endDate;
    private boolean active;
    @ManyToOne
    @JoinColumn(name = "project_id")
    private Project project;

}
