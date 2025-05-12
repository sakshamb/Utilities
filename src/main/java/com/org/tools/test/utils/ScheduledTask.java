package com.org.tools.test.utils;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.org.tools.test.service.TestToolService;

@Component
public class ScheduledTask implements Runnable{
	
	@Autowired
	TestToolService service;

	@Override
	public void run() {
		service.triggerLogic();
	}

}
