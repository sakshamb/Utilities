package com.org.tools.test.utils;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

@Component
public class TestApplicationListener implements ApplicationListener<ContextRefreshedEvent> {

	@Autowired
	SchedulerUtils schedulerUtils;
	
	@Override
	public void onApplicationEvent(ContextRefreshedEvent event) {
		System.out.println("onApplication event");
		//read all schedules from mongo
		//schedule in spring
		schedulerUtils.createSingleTriggerScheduler();
		
	}

}
