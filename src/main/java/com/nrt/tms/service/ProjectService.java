package com.nrt.tms.service;

import com.nrt.tms.dto.ProjectRequest;
import com.nrt.tms.dto.ProjectResponse;
import org.springframework.data.domain.Page;

public interface ProjectService {

    ProjectResponse createProject(ProjectRequest project);

    Page<ProjectResponse> getAllProjects(int page, int size);

    ProjectResponse updateProjectByProjectCode(String projectCode, ProjectRequest project);
}
