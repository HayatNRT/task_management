package com.nrt.tms.entity;

import com.nrt.tms.util.Priority;
import com.nrt.tms.util.TaskStatus;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.util.List;

@Entity
@Setter
@Getter
public class Task extends BaseEntity {
    private String title;
    private String description;
    @Enumerated(EnumType.STRING)
    private TaskStatus taskStatus;
    @Enumerated(EnumType.STRING)
    private Priority priority;
    private LocalDate dueDate;
    @ManyToOne
    @JoinColumn(name = "project_id")
    private Project project;
    @ManyToOne
    @JoinColumn(name = "assigned_user_id")
    private Employee assignedUser;
    @OneToMany(mappedBy = "task")
    private List<Comment> comments;
    @ManyToOne
    @JoinColumn(name = "board_id")
    private Board board;
    @ManyToOne
    @JoinColumn(name = "team_id")
    private Team team;
}
