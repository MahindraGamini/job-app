package com.mahi.job_app.controller;

import com.mahi.job_app.model.JobModel;
import com.mahi.job_app.service.JobService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/jobPosts")
public class JobController {

    private final JobService jobService;

    public JobController(JobService jobService) {
        this.jobService = jobService;
    }

    @GetMapping
    public List<JobModel> getAllJobs() {
        return jobService.getAllJobs();
    }

    @GetMapping("/{postId}")
    public JobModel getJob(@PathVariable int postId) {
        return jobService.getJob(postId);
    }

    @PostMapping
    public JobModel addJob(@RequestBody JobModel jobModel) {
        return jobService.add(jobModel);
    }

    @PatchMapping("/{postId}")
    public JobModel updateJob(@PathVariable int postId,
                              @RequestBody JobModel jobModel) {
        return jobService.update(jobModel, postId);
    }

    @DeleteMapping("/{postId}")
    public void deleteJob(@PathVariable int postId) {
        jobService.delete(postId);
    }

    @GetMapping("/search")
    public List<JobModel> search(@RequestParam String keyword) {
        return jobService.search(keyword);
    }
}