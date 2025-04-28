package com.nrt.tms.controller;

import com.nrt.tms.dto.ProjectRequest;
import com.nrt.tms.dto.ProjectResponse;
import com.nrt.tms.service.ProjectService;
import com.nrt.tms.util.ApiResponse;
import com.nrt.tms.util.ApiResponseBuilder;
import com.nrt.tms.util.ResponseKeys;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin("*")
@RestController
@RequiredArgsConstructor
@RequestMapping("/api/tms/project")
public class ProjectController {
    private final ProjectService projectService;
    private final ApiResponseBuilder response;

    @PostMapping("/create")
    public ResponseEntity<ApiResponse<ProjectResponse>> createProject(@RequestBody ProjectRequest project) {
        return response.ok(ResponseKeys.RESOURCE_CREATED, projectService.createProject(project));
    }

    @GetMapping("/find-all")
    public ResponseEntity<ApiResponse<List<ProjectResponse>>> getProjects(@RequestParam(defaultValue = "0") int page,
                                                                          @RequestParam(defaultValue = "10") int size) {
        Page<ProjectResponse> projects = projectService.getAllProjects(page, size);

        return response.okWithPagination(ResponseKeys.SUCCESS, projects.getContent(), projects);
    }
}
