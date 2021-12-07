package com.zendesk.timer_service.job;

import java.sql.Timestamp;
import java.util.stream.IntStream;

import org.quartz.JobDataMap;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.springframework.scheduling.quartz.QuartzJobBean;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class SimpleJob extends QuartzJobBean {
    @Override
    protected void executeInternal(JobExecutionContext context) throws JobExecutionException {
        log.info("SimpleJob Start................");
       /* IntStream.range(0, 5).forEach(i -> {
            log.info("Counting - {}", i);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                log.error(e.getMessage(), e);
            }
        });*/

        JobDataMap dataMap = context.getJobDetail().getJobDataMap();

        String id = (String) dataMap.get("id");
        String payload = (String) dataMap.get("payload");
        log.info("Job id =" + id + " payload " + payload) ;
      try {
        Thread.sleep(1000);
      } catch (InterruptedException e) {
        e.printStackTrace();
      }
      log.info("SimpleJob End................");
    }
}
