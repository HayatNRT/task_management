package com.nrt.tms.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serial;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Set;

@Data
@NoArgsConstructor
@Entity
@Table(name = "application_user")
public class ApplicationUser implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "user_id", length = 10)
    private String uid;

    @Column(name = "user_full_name", length = 30)
    private String name;

    @Column(name = "login_stamp")
    private LocalDateTime loginTime;

    @Column(name = "email_id")
    private String email;

    @Column(name = "username")
    private String username;

    @Column(name = "user_password", nullable = false)
    private String password;

    private String enable;

    private String contactNo;

//	@ManyToOne(fetch = FetchType.EAGER)
//	@JoinColumn(name = "designation_Id", referencedColumnName = "desId")
//	private Designation designation;

    @ManyToMany(fetch = FetchType.EAGER)
    private Set<Role> roles;




}
    



   


