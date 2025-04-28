package com.nrt.tms.dto;


import lombok.*;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ProjectResponse {

    private String projectCode;

    private String projectName;

    private String description;

    private String priority;

    private String status;

    private LocalDate startDate;

    private LocalDate endDate;

    private Integer totalResources;

    private String clientName;
    private String createdBy;
    private LocalDateTime createdOn;
    private Boolean active;
}

