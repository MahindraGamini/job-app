package com.mahi.job_app.repo;

import com.mahi.job_app.model.JobModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface JobRepo extends JpaRepository<JobModel, Integer> {

    List<JobModel> findByJobNameContainingIgnoreCaseOrJobDescContainingIgnoreCase(String jobName, String jobDesc);
}