package com.nrt.tms.repository;

import com.nrt.tms.entity.Team;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface TeamRepository extends JpaRepository<Team, Long> {
    @Query("SELECT t FROM Team t JOIN FETCH t.teamMemberShip m JOIN FETCH m.employee WHERE t.id = :teamId")
    Team findByIdTeamAndMember(@Param("teamId") Long teamId);
}
