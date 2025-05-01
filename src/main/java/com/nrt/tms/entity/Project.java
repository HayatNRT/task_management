package com.nrt.tms.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.nrt.tms.util.ProjectPriority;
import com.nrt.tms.util.ProjectStatus;
import com.nrt.tms.util.ProjectVisibility;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Entity
@Table(name = "project")
@Getter
@Setter
public class Project extends BaseEntity {

    @Column(nullable = false)
    private String projectName;
    @Column(unique = true, nullable = false)
    private String projectCode;
    private String description;
    @Enumerated(EnumType.STRING)
    private ProjectPriority priority;
    @Enumerated(EnumType.STRING)
    private ProjectStatus status;
    @JsonFormat(pattern = "yyyy-MM-dd")
    private LocalDate startDate;
    @JsonFormat(pattern = "yyyy-MM-dd")
    private LocalDate endDate;
    private Integer totalResources;
    private String clientName;
    private Boolean active = true;
    @ManyToOne
    @JoinColumn(name = "team_id")
    private Team team;
    @Enumerated(EnumType.STRING)
    private ProjectVisibility visibility = ProjectVisibility.PUBLIC_ACCESSIBLE;

}


