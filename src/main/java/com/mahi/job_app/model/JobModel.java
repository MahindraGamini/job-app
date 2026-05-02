package com.mahi.job_app.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "jobs")
public class JobModel {
    @Id
    private int jobId;
    private String jobName;
    private String jobDesc;
    private List<String> postTechStack;
    private Integer reqExp;

}