package com.morganstanely.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.batch.core.BatchStatus;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.JobExecution;
import org.springframework.batch.core.JobParameter;
import org.springframework.batch.core.JobParameters;
import org.springframework.batch.core.JobParametersInvalidException;
import org.springframework.batch.core.launch.JobLauncher;
import org.springframework.batch.core.repository.JobExecutionAlreadyRunningException;
import org.springframework.batch.core.repository.JobInstanceAlreadyCompleteException;
import org.springframework.batch.core.repository.JobRestartException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/load")
public class LoadController {

	@Autowired
	private JobLauncher jobLauncher;

	@Autowired
	private Job job;

	@GetMapping
	public ResponseEntity<BatchStatus> load() throws JobExecutionAlreadyRunningException, JobRestartException,
			JobInstanceAlreadyCompleteException, JobParametersInvalidException {

		Map<String, JobParameter> map = new HashMap<String, JobParameter>();
		map.put("time", new JobParameter(System.currentTimeMillis()));
		JobParameters jobParameters = new JobParameters(map);
		JobExecution jobExecution = null;
		try {
			jobExecution = jobLauncher.run(job, jobParameters);
			while (jobExecution.isRunning()) {
				System.out.println("Job is : " + jobExecution.getStatus() + "....");
			}
		} catch (Exception e) {
			e.printStackTrace();

		}
		return new ResponseEntity<>(jobExecution.getStatus(), HttpStatus.OK);

	}
}
