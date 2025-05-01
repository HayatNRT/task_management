package com.nrt.tms.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.List;

@Data
@Entity
@NoArgsConstructor
@Table(name = "roles")
public class Role implements Serializable {

    private static final long serialVersionUID = 1L;

    public Role(Long roleId) {
        this.roleId = roleId;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "user_role_generator")
    @SequenceGenerator(name = "user_role_generator", sequenceName = "users_role_seq", initialValue = 10000, allocationSize = 1)
    private Long roleId;

    @Column(name = "roleName", unique = true)
    private String roleName;

    @JsonIgnore
    @ManyToMany(mappedBy = "roles")
    private List<ApplicationUser> users;

    private String roleDesc;


}