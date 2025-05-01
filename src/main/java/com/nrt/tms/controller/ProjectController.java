package com.nrt.tms.controller;

import com.nrt.tms.dto.ProjectRequest;
import com.nrt.tms.dto.ProjectResponse;
import com.nrt.tms.service.ProjectService;
import com.nrt.tms.util.ApiResponse;
import com.nrt.tms.util.ApiResponseBuilder;
import com.nrt.tms.util.MappingConstant;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static com.nrt.tms.util.ResponseKeys.RESOURCE_CREATED;
import static com.nrt.tms.util.ResponseKeys.SUCCESS;

@CrossOrigin("*")
@RestController
@RequiredArgsConstructor
@RequestMapping(MappingConstant.Project.BASE)
public class ProjectController {
    private final ProjectService projectService;
    private final ApiResponseBuilder response;

    @PostMapping(MappingConstant.Project.CREATE)
    public ResponseEntity<ApiResponse<ProjectResponse>> createProject(@RequestBody ProjectRequest project) {
        return response.ok(RESOURCE_CREATED, projectService.createProject(project));
    }

    @GetMapping(MappingConstant.Project.FIND_ALL)
    public ResponseEntity<ApiResponse<List<ProjectResponse>>> getProjects(@RequestParam(defaultValue = "0") int page, @RequestParam(defaultValue = "10") int size) {
        Page<ProjectResponse> projects = projectService.getAllProjects(page, size);
        return response.okWithPagination(SUCCESS, projects.getContent(), projects);
    }

    @PutMapping(MappingConstant.Project.UPDATE)
    public ResponseEntity<ApiResponse<ProjectResponse>> updateProject(@PathVariable String projectCode, @RequestBody ProjectRequest project) {
        return response.ok(SUCCESS, projectService.updateProjectByProjectCode(projectCode, project));
    }

    @DeleteMapping(MappingConstant.Project.DELETE)
    public ResponseEntity<ApiResponse<Void>> deleteProject(@PathVariable String projectCode) {
        projectService.deleteProjectByProjectCode(projectCode);
        return response.ok(SUCCESS);
    }
}
