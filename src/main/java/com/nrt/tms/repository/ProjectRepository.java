package com.nrt.tms.repository;

import com.nrt.tms.entity.Project;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ProjectRepository extends JpaRepository<Project, Long> {


    Optional<Project> findProjectByProjectCode(String projectCode);


}
