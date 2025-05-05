package com.bosch.pssb.test.controller;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.ZoneId;
import java.time.temporal.ChronoUnit;
import java.util.Date;

import org.springframework.context.annotation.Bean;
import org.springframework.scheduling.TaskScheduler;
import org.springframework.scheduling.concurrent.ConcurrentTaskScheduler;
import org.springframework.scheduling.concurrent.ThreadPoolTaskScheduler;
import org.springframework.scheduling.config.TaskSchedulerRouter;
import org.springframework.scheduling.support.CronTrigger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class TestController {

	@GetMapping("/singleInstanceScheduler")
	@ResponseBody
	public String createSingleTriggerScheduler() {
		Instant instant=Instant.now();
		instant=instant.atZone(ZoneId.systemDefault()).with(LocalTime.parse("16:22:00")).toInstant();
		System.out.println(instant.plus(2, ChronoUnit.MINUTES ));
		ThreadPoolTaskScheduler scheduler= new ThreadPoolTaskScheduler();
		scheduler.setPoolSize(1);
		scheduler.initialize();
		
		Runnable taskTest= new Runnable() {
			public void run() {
				System.out.println("scheduler running at :" + Instant.now());
			}
		};
		
		scheduler.schedule(taskTest, instant.plus(2, ChronoUnit.MINUTES ));
		return "ok";
	}
	
	@GetMapping("/multiInstanceScheduler")
	@ResponseBody
	public String createMultiTriggerScheduler() {
		// scheduling every min for quick testing
		CronTrigger trigger=new CronTrigger("0 0/1 * * * ? ");
		ThreadPoolTaskScheduler scheduler= new ThreadPoolTaskScheduler();
		scheduler.setPoolSize(1);
		scheduler.initialize();
		
		Runnable taskTest= new Runnable() {
			public void run() {
				System.out.println("scheduler running at :" + Instant.now());
			}
		};
		
		scheduler.schedule(taskTest, trigger);	
		return "ok";
	}
	
}
