package com.zendesk.timer_service.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.Date;
import java.util.Map;

@ToString
@Getter
@Setter
@Entity
@Table(name = "scheduler_job_info")
public class SchedulerJobInfo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String jobId;
    private String jobName;
    private String jobGroup;
    private String jobStatus;
    private String jobClass;
    private String cronExpression;
    private String desc;
    private String interfaceName;
    private Long repeatTime;
    private Boolean cronJob;
    private String payLoad;
    private Long startTime;
    private Long endTime;

    private String startTimeDate;
    private String endTimeDate;



  public SchedulerJobInfo(){}
  public SchedulerJobInfo(Map<String, Object> payload){

    if(payload.containsKey("jobId"))
      this.jobId = (String)payload.get("jobId");
    if(payload.containsKey("jobName"))
      this.jobName = (String)payload.get("jobName");
    if(payload.containsKey("jobGroup"))
      this.jobGroup = (String)payload.get("jobGroup");
    if(payload.containsKey("jobStatus"))
      this.jobStatus = (String)payload.get("jobStatus");
    if(payload.containsKey("jobClass"))
      this.jobClass = (String)payload.get("jobClass");
    if(payload.containsKey("cronExpression"))
      this.cronExpression = (String)payload.get("cronExpression");
    if(payload.containsKey("desc"))
      this.desc = (String)payload.get("desc");
    if(payload.containsKey("interfaceName"))
      this.interfaceName = (String)payload.get("interfaceName");
    if(payload.containsKey("repeatTime"))
      this.repeatTime = new Long((Integer)payload.get("repeatTime"));
    if(payload.containsKey("cronJob"))
      this.cronJob = (Boolean)payload.get("cronJob");
    if(payload.containsKey("payLoad"))
      this.payLoad = (String)payload.get("payLoad");
    if(payload.containsKey("startTime")) {
      this.startTime = new Long((Long) payload.get("startTime"));
      this.startTimeDate = new Date(this.startTime).toString();
    }
    if(payload.containsKey("endTime")) {
      this.endTime = new Long((Long) payload.get("endTime"));
      this.endTimeDate = new Date(this.endTime).toString();
    }

  }


}
