package com.nrt.tms.service.impl;

import com.nrt.tms.dto.ProjectRequest;
import com.nrt.tms.dto.ProjectResponse;
import com.nrt.tms.entity.Project;
import com.nrt.tms.repository.ProjectRepository;
import com.nrt.tms.service.ProjectService;
import com.nrt.tms.util.ProjectPriority;
import com.nrt.tms.util.ProjectStatus;
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
    public ProjectResponse updateProjectByProjectCode(String projectCode, ProjectRequest project) {
//        projectRepository.findProjectByProjectCode(projectCode).orElseThrow(()->)
        return null;
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
        response.setTotalResources(project.getTotalResources());
        return response;

    }

}
