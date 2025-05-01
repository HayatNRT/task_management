package com.nrt.tms.controller;

import com.nrt.tms.dto.TeamRequest;
import com.nrt.tms.dto.TeamResponse;
import com.nrt.tms.entity.Team;
import com.nrt.tms.service.TeamService;
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
@RequiredArgsConstructor
@RestController
@RequestMapping(MappingConstant.Team.BASE)
public class TeamController {
    private final ApiResponseBuilder response;
    private final TeamService teamService;

    @PostMapping(MappingConstant.Team.CREATE)
    public ResponseEntity<ApiResponse<TeamResponse>> createTeam(@RequestBody TeamRequest teamRequest) {
        return response.ok(RESOURCE_CREATED, teamService.createTeam(teamRequest));
    }

    @GetMapping(MappingConstant.Team.FETCH_TEAM_WITH_MEMBERS)
    public ResponseEntity<ApiResponse<TeamResponse>> fetchTeamsWithMembers(@PathVariable int teamId) {
        return response.ok(SUCCESS, teamService.fetchTeamWitMember(teamId));
    }


    @GetMapping(MappingConstant.Team.FETCH_ALL_TEAMS)
    public ResponseEntity<ApiResponse<List<Team>>> fetchAllTeams(@RequestParam(defaultValue = "0") int page,
                                                                 @RequestParam(defaultValue = "10") int size) {
        Page<Team> p = teamService.fetchAllTeams(page, size);
        return response.okWithPagination(SUCCESS, p.getContent(), p);
    }
}
