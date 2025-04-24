package com.nrt.tms.entity;

import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Entity
@Setter
@Getter
public class Project extends BaseEntity {

    private String title;
    private String description;
    private LocalDate deadline;
}
