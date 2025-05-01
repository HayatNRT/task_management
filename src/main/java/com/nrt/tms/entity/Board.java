package com.nrt.tms.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.Set;

@EqualsAndHashCode(callSuper = true)
@Entity
@Data
public class Board extends BaseEntity {
    private String name;
    @OneToOne
    @JoinColumn(name = "team_id")
    private Team team;
    @OneToMany(mappedBy = "board")
    private Set<Task> tasks;
}
