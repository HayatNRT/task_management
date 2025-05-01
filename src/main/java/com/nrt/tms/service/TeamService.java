package com.nrt.tms.service;

import com.nrt.tms.dto.TeamRequest;
import com.nrt.tms.dto.TeamResponse;
import com.nrt.tms.entity.Team;
import org.springframework.data.domain.Page;

import java.util.List;

public interface TeamService {

    TeamResponse createTeam(TeamRequest teamRequest);

    TeamResponse fetchTeamWitMember(long teamId);
    Page<Team> fetchAllTeams(int page, int size);
}
