package com.org.tools.test.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.org.tools.test.utils.SchedulerUtils;

@Controller
public class TestController {

	@Autowired
	SchedulerUtils schedulerUtils;
	
	@GetMapping("/singleInstanceScheduler")
	@ResponseBody
	public String createSingleTriggerScheduler() {
		return schedulerUtils.createSingleTriggerScheduler();
	}
	
	@GetMapping("/multiInstanceScheduler")
	@ResponseBody
	public String createMultiTriggerScheduler() {
		return schedulerUtils.createMultiTriggerScheduler();
	}
}
	
