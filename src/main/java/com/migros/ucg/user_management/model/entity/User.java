package com.migros.ucg.user_management.model.entity;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;

@Data
@SequenceGenerator(name = "USERS_SEQUENCE", sequenceName = "MIGROS_USERS_SEQ", initialValue = 1, allocationSize = 1)
@Table(name = "USERS")
@Entity
public class User
{
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "USERS_SEQUENCE")
    @Column(name = "USER_ID")
    @Id
    private Integer userID;

    @Column(nullable = false)
    private String username;

    @Column(nullable = false)
    private String password;

    private Date created;
}
