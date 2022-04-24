package com.nachc.examples.threadexample;

import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

import com.nachc.examples.threadexample.runnable.WidgetRunnable;
import com.nachc.examples.threadexample.widget.Widget;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class WidgetFactory {

	private int howMany;
	
	private int batchSize;
	
	private int lotNumber;
	
	public WidgetFactory(int howMany, int batchSize, int lotNumber) {
		this.howMany = howMany;
		this.batchSize = batchSize;
		this.lotNumber = lotNumber;
	}
	
	public void makeWidgets() {
		ThreadPoolExecutor executor = (ThreadPoolExecutor) Executors.newFixedThreadPool(batchSize);
		log.info("Building " + howMany + " widgets...");
		for (int i = 0; i < howMany; i++) {
			Widget widget = new Widget(lotNumber, i);
			WidgetRunnable runnable = new WidgetRunnable(widget);
			executor.execute(runnable);
		}
		log.info("SHUTTING DOWN----------------");
		executor.shutdown();
	}

}
