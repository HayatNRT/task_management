package com.nrt.tms.service.impl;

import com.nrt.tms.dto.ProjectRequest;
import com.nrt.tms.dto.ProjectResponse;
import com.nrt.tms.entity.Project;
import com.nrt.tms.exception.ServiceException;
import com.nrt.tms.repository.ProjectRepository;
import com.nrt.tms.service.ProjectService;
import com.nrt.tms.util.ProjectPriority;
import com.nrt.tms.util.ProjectStatus;
import com.nrt.tms.util.ProjectVisibility;
import com.nrt.tms.util.ResponseKeys;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import static com.nrt.tms.util.ProjectCodeGenerator.generateProjectCode;

@Service
@RequiredArgsConstructor
public class ProjectServiceImpl implements ProjectService {
    private final ProjectRepository projectRepository;

    @Transactional
    @Override
    public ProjectResponse createProject(ProjectRequest projectRequest) {
        Project project = build(projectRequest);
        projectRepository.save(project);
        return buildResponse(project);
    }

    @Override
    @Transactional(readOnly = true)
    public Page<ProjectResponse> getAllProjects(int page, int size) {
        Pageable pageRequest = PageRequest.of(page, size);

        Page<Project> projects = projectRepository.findAll(pageRequest);

        return projects.map(this::buildResponse);
    }

    @Override
    @Transactional
    public ProjectResponse updateProjectByProjectCode(String projectCode, ProjectRequest projectRequest) {
        Project project = projectRepository.findProjectByProjectCode(projectCode)
                .orElseThrow(() -> new ServiceException(ResponseKeys.CLIENT_RESOURCE_NOT_FOUND, "Project with code " + projectCode + " not found"));
        project.setProjectName(projectRequest.getProjectName());
        project.setStatus(projectRequest.getStatus().equalsIgnoreCase("ACTIVE") ? ProjectStatus.ACTIVE : projectRequest.getStatus().equalsIgnoreCase("DRAFT") ? ProjectStatus.DRAFT : ProjectStatus.ON_HOLD);
        project.setPriority(projectRequest.getPriority().equalsIgnoreCase("LOW") ? ProjectPriority.LOW : projectRequest.getPriority().equalsIgnoreCase("MEDIUM") ? ProjectPriority.MEDIUM : ProjectPriority.HIGH);
        project.setDescription(projectRequest.getDescription());
        project.setStartDate(projectRequest.getStartDate());
        project.setEndDate(projectRequest.getEndDate());
        project.setClientName(projectRequest.getClientName());
        project.setDescription(projectRequest.getDescription());
        project.setVisibility(ProjectVisibility.TEAM_ASSIGNED);
        return buildResponse(projectRepository.save(project));
    }

    @Override
    @Transactional
    public void deleteProjectByProjectCode(String projectCode) {
        Project project = projectRepository.findProjectByProjectCode(projectCode)
                .orElseThrow(() -> new ServiceException(ResponseKeys.CLIENT_RESOURCE_NOT_FOUND, "Project with code " + projectCode + " not found"));
        project.setActive(false);
        projectRepository.save(project);

    }


    private Project build(ProjectRequest request) {
        ProjectPriority priority = request.getPriority().equalsIgnoreCase("LOW") ? ProjectPriority.LOW : request.getPriority().equalsIgnoreCase("MEDIUM") ? ProjectPriority.MEDIUM : ProjectPriority.HIGH;
        ProjectStatus status = request.getStatus().equalsIgnoreCase("ACTIVE") ? ProjectStatus.ACTIVE : request.getStatus().equalsIgnoreCase("DRAFT") ? ProjectStatus.DRAFT : ProjectStatus.ON_HOLD;
        Project project = new Project();
        project.setProjectCode(generateProjectCode(request.getProjectName()));
        project.setPriority(priority);
        project.setProjectName(request.getProjectName());
        project.setStartDate(request.getStartDate());
        project.setEndDate(request.getEndDate());
        project.setDescription(request.getDescription());
        project.setStatus(status);
        project.setClientName(request.getClientName());
        return project;
    }

    private ProjectResponse buildResponse(Project project) {
        ProjectResponse response = new ProjectResponse();
        response.setProjectCode(project.getProjectCode());
        response.setProjectName(project.getProjectName());
        response.setStartDate(project.getStartDate());
        response.setEndDate(project.getEndDate());
        response.setDescription(project.getDescription());
        response.setStatus(project.getStatus().name());
        response.setPriority(project.getPriority().name());
        response.setClientName(project.getClientName());
        response.setActive(project.getActive());
        response.setCreatedOn(project.getCreatedDate());
        response.setTotalResources(project.getTotalResources());
        response.setCreatedBy(project.getCreatedBy());
        return response;

    }

}
