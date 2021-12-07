package com.zendesk.timer_service.controller;

import java.util.List;
import java.util.Map;

import org.quartz.SchedulerException;
import org.quartz.SchedulerMetaData;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.zendesk.timer_service.entity.Message;
import com.zendesk.timer_service.entity.SchedulerJobInfo;
import com.zendesk.timer_service.service.SchedulerJobService;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RequiredArgsConstructor
@RestController
@RequestMapping("/api")
public class JobController {

	private final SchedulerJobService scheduleJobService;


  @RequestMapping(value = "/createUpdateTimer", method = RequestMethod.POST , produces = "application/json" , consumes = "application/json")
  public Object createUpdateTimer(@RequestBody Map<String, Object> payload) {
    log.info("params, job = {}", payload);
    SchedulerJobInfo job = new SchedulerJobInfo(payload);

    Message message = Message.failure();
    try {
      String jobId = scheduleJobService.saveOrupdate(job);
      message = Message.success();
      message.setMsg(jobId);
    } catch (Exception e) {
      message.setMsg(e.getMessage());
      log.error("updateCron ex:", e);
    }
    return message;

  }

	@RequestMapping(value = "/saveOrUpdate", method = { RequestMethod.GET, RequestMethod.POST })
	public Object saveOrUpdate(SchedulerJobInfo job) {
		log.info("params, job = {}", job);
		Message message = Message.failure();
		try {
			scheduleJobService.saveOrupdate(job);
			message = Message.success();
		} catch (Exception e) {
			message.setMsg(e.getMessage());
			log.error("updateCron ex:", e);
		}
		return message;
	}

	@RequestMapping("/metaData")
	public Object metaData() throws SchedulerException {
		SchedulerMetaData metaData = scheduleJobService.getMetaData();
		return metaData;
	}

	@RequestMapping("/getAllJobs")
	public Object getAllJobs() throws SchedulerException {
		List<SchedulerJobInfo> jobList = scheduleJobService.getAllJobList();
		return jobList;
	}

	@RequestMapping(value = "/runJob", method = { RequestMethod.GET, RequestMethod.POST })
	public Object runJob(SchedulerJobInfo job) {
		log.info("params, job = {}", job);
		Message message = Message.failure();
		try {
			scheduleJobService.startJobNow(job);
			message = Message.success();
		} catch (Exception e) {
			message.setMsg(e.getMessage());
			log.error("runJob ex:", e);
		}
		return message;
	}

	@RequestMapping(value = "/pauseJob", method = { RequestMethod.GET, RequestMethod.POST })
	public Object pauseJob(SchedulerJobInfo job) {
		log.info("params, job = {}", job);
		Message message = Message.failure();
		try {
			scheduleJobService.pauseJob(job);
			message = Message.success();
		} catch (Exception e) {
			message.setMsg(e.getMessage());
			log.error("pauseJob ex:", e);
		}
		return message;
	}

	@RequestMapping(value = "/resumeJob", method = { RequestMethod.GET, RequestMethod.POST })
	public Object resumeJob(SchedulerJobInfo job) {
		log.info("params, job = {}", job);
		Message message = Message.failure();
		try {
			scheduleJobService.resumeJob(job);
			message = Message.success();
		} catch (Exception e) {
			message.setMsg(e.getMessage());
			log.error("resumeJob ex:", e);
		}
		return message;
	}

	@RequestMapping(value = "/deleteJob", method = { RequestMethod.GET, RequestMethod.POST })
	public Object deleteJob(SchedulerJobInfo job) {
		log.info("params, job = {}", job);
		Message message = Message.failure();
		try {
			scheduleJobService.deleteJob(job);
			message = Message.success();
		} catch (Exception e) {
			message.setMsg(e.getMessage());
			log.error("deleteJob ex:", e);
		}
		return message;
	}
}
