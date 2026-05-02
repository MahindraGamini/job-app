package com.mahi.job_app.service;

import com.mahi.job_app.model.JobModel;
import com.mahi.job_app.repo.JobRepo;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class JobService {

    private final JobRepo jobRepo;

    public JobService(JobRepo jobRepo) {
        this.jobRepo = jobRepo;
    }

    public List<JobModel> getAllJobs() {
        return jobRepo.findAll();
    }

    public JobModel getJob(int postId) {
        return jobRepo.findById(postId)
                .orElseThrow(() -> new RuntimeException("Job not found"));
    }

    public JobModel add(JobModel jobModel) {
        return jobRepo.save(jobModel);
    }

    public JobModel update(JobModel jobModel, int postId) {
        jobModel.setJobId(postId);
        return jobRepo.save(jobModel);
    }

    public void delete(int postId) {
        jobRepo.deleteById(postId);
    }

    public List<JobModel> search(String keyword) {
        return jobRepo
                .findByJobNameContainingIgnoreCaseOrJobDescContainingIgnoreCase(keyword, keyword);
    }

}