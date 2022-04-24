package com.nachc.examples.threadexample;

import org.junit.Test;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class WidgetFactoryIntegrationTest {

	@Test
	public void shouldBuildWidgets() {
		log.info("Starting test...");
		int howMany = 100;
		int batchSize = 10;
		int lotNumber = 1;
		WidgetFactory factory = new WidgetFactory(howMany, batchSize, lotNumber);
		factory.makeWidgets();
		log.info("Done.");
	}
	
}
