package com.mahi.job_app.model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "users")
@Data
public class User {
@Id
@GeneratedValue(strategy= GenerationType.IDENTITY)
private Integer id;
private String userName;
private String password;
}
