package com.nrt.tms.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Entity
@Setter
@Getter
public class Team extends BaseEntity {

    private String teamName;
    @ManyToOne
    @JoinColumn(name = "team_lead_id")
    private User teamLead;
    @OneToMany(mappedBy = "team")
    private List<User> teamMembers;

}
