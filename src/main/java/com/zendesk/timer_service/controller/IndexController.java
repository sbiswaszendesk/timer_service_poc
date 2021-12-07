package com.zendesk.timer_service.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.zendesk.timer_service.entity.SchedulerJobInfo;
import com.zendesk.timer_service.service.SchedulerJobService;

@Controller
public class IndexController {

	@Autowired
	private SchedulerJobService scheduleJobService;

	@GetMapping("/index")
	public String index(Model model){
		List<SchedulerJobInfo> jobList = scheduleJobService.getAllJobList();
		model.addAttribute("jobs", jobList);
		return "index";
	}

}
