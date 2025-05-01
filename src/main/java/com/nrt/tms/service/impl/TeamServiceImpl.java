package com.nrt.tms.service.impl;

import com.nrt.tms.dto.TeamRequest;
import com.nrt.tms.dto.TeamResponse;
import com.nrt.tms.entity.Employee;
import com.nrt.tms.entity.Team;
import com.nrt.tms.entity.TeamMemberShip;
import com.nrt.tms.exception.ServiceException;
import com.nrt.tms.repository.EmployeeRepository;
import com.nrt.tms.repository.TeamMemberShipRepository;
import com.nrt.tms.repository.TeamRepository;
import com.nrt.tms.service.TeamService;
import com.nrt.tms.util.ResponseKeys;
import com.nrt.tms.util.RoleEnum;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class TeamServiceImpl implements TeamService {
    private final TeamRepository teamRepository;
    private final EmployeeRepository employeeRepository;
    private final TeamMemberShipRepository teamMemberShipRepository;

    @Override
    @Transactional
    public TeamResponse createTeam(TeamRequest request) {
        Employee employee = employeeRepository.findById(request.leadId()).
                orElseThrow(() -> new ServiceException(ResponseKeys.CLIENT_RESOURCE_NOT_FOUND, "Employee is not there"));
        Team team = new Team();
        team.setTeamName(request.name());
        team.setDescription(request.description());
        teamRepository.save(team);
        List<Employee> employeeList = employeeRepository.findAllById(request.membersId());
        if (employeeList.size() != request.membersId().size()) {
            throw new ServiceException(ResponseKeys.CLIENT_RESOURCE_NOT_FOUND, "Employee is not there");
        }
        List<TeamMemberShip> memberShipList = new ArrayList<>();
        memberShipList.add(createTeamMembership(employee, team, RoleEnum.TEAM_LEAD));
        employeeList.stream().map(e -> createTeamMembership(e, team, RoleEnum.MEMBER)).forEach(memberShipList::add);
        return buildTeamResponse(team, teamMemberShipRepository.saveAll(memberShipList));
    }

    @Transactional(readOnly = true)
    @Override
    public TeamResponse fetchTeamWitMember(long teamId) {
        Team team = teamRepository.findByIdTeamAndMember(teamId);
        return buildTeamResponse(team, team.getTeamMemberShip().stream().toList());
    }

    @Override
    @Transactional(readOnly = true)
    public Page<Team> fetchAllTeams(int page, int size) {
        return teamRepository.findAll(PageRequest.of(page, size, Sort.Direction.DESC, "createdDate"));
    }


    private TeamResponse buildTeamResponse(Team team, List<TeamMemberShip> teamMemberList) {
        return new TeamResponse(team.getId(), team.getTeamName(), team.getDescription(), teamMemberList.stream()
                .map(t -> {
                    Employee employee = t.getEmployee();
                    return new TeamResponse.MemberResponse(employee.getEmployeeCode(), employee.getEmployeeName(), employee.getEmailId(), t.getRole().name());
                })
                .toList());
    }

    private TeamMemberShip createTeamMembership(Employee employee, Team team, RoleEnum role) {
        TeamMemberShip membership = new TeamMemberShip();
        membership.setEmployee(employee);
        membership.setTeam(team);
        membership.setRole(role);
        return membership;
    }

}
