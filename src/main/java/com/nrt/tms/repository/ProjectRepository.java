package com.nrt.tms.repository;

import com.nrt.tms.entity.Project;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface ProjectRepository extends JpaRepository<Project, Long> {



    Optional<Project> findProjectByProjectCode(String projectCode);

}
