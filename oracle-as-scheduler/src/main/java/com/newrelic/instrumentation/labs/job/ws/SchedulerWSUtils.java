package com.newrelic.instrumentation.labs.job.ws;

import java.util.Map;

public class SchedulerWSUtils {

	
	public static void addAttribute(Map<String, Object> attributes, String key, Object value) {
		if(attributes != null && key != null && !key.isEmpty() && value != null) {
			attributes.put(key, value);
		}
	}
	
	
}
