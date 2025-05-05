package com.bosch.pssb.test.utils;

import java.time.Instant;

public class TestUtils implements Runnable {

	@Override
	public void run() {
		System.out.println("scheduler running at :" + Instant.now());

	}

}
