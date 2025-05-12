package com.org.tools.test.utils;

import java.time.Instant;
import java.time.LocalTime;
import java.time.ZoneId;
import java.time.temporal.ChronoUnit;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.concurrent.ThreadPoolTaskScheduler;
import org.springframework.scheduling.support.CronTrigger;
import org.springframework.stereotype.Component;

@Component
public class SchedulerUtils {


	@Autowired 
	ScheduledTask task;
	
	public String createSingleTriggerScheduler() {
		Instant instant = Instant.now();
		instant = instant.atZone(ZoneId.systemDefault()).with(LocalTime.parse("10:25:00")).toInstant();
		
		ThreadPoolTaskScheduler scheduler = new ThreadPoolTaskScheduler();
		scheduler.setPoolSize(1);
		scheduler.initialize();

		scheduler.schedule(task, instant.plus(1, ChronoUnit.MINUTES));
		// add to mongo
		return "scheduled single";
	}

	public String createMultiTriggerScheduler() {
		// scheduling every min for quick testing
		CronTrigger trigger = new CronTrigger("0 0/1 * * * ? ");
		ThreadPoolTaskScheduler scheduler = new ThreadPoolTaskScheduler();
		scheduler.setPoolSize(1);
		scheduler.initialize();

		scheduler.schedule(task, trigger);
		//add to mongo
		return "scheduled multi";
	}
}
