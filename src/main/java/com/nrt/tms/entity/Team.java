package com.nrt.tms.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Set;

@Entity
@Setter
@Getter
public class Team extends BaseEntity {

    private String teamName;

    private String description;
    @JsonIgnore
    @OneToOne(mappedBy = "team")
    private Board board;
    @JsonIgnore
    @OneToMany(mappedBy = "team",fetch = FetchType.EAGER)
    private Set<TeamMemberShip> teamMemberShip;
    @OneToMany(mappedBy = "team")
    private Set<Task> tasks;


}
