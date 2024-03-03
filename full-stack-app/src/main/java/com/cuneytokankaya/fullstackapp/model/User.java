package com.cuneytokankaya.fullstackapp.model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "tbl_users")
@Data
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String userName;
    private String password;
}
