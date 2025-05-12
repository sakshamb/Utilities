package com.org.tools.test.service;

import java.time.Instant;
import java.time.ZoneId;

import org.springframework.stereotype.Service;

@Service
public class TestToolService {

	public String triggerLogic() {
		Instant instant= Instant.now();
		System.out.println("scheduler running at :" + instant.atZone(ZoneId.systemDefault()));
		return Instant.now().toString();
	}
}
