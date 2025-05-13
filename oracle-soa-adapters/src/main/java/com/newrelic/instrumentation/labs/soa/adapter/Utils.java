package com.newrelic.instrumentation.labs.soa.adapter;

import java.util.Map;

import com.newrelic.api.agent.NewRelic;

import oracle.fabric.common.NormalizedMessage;

public class Utils {

	public static final String NEWRELIC_HEADER_NAME = "newrelic.tracing.header";
	
	public static void addDistributed(NormalizedMessage message) {
		String value = (String) message.getProperty(NEWRELIC_HEADER_NAME);
		if(value == null || value.isEmpty()) {
			AdapterHeaders headers = new AdapterHeaders(message);
			NewRelic.getAgent().getTransaction().insertDistributedTraceHeaders(headers);
		}
	}
	
	public static void addAttribute(Map<String, Object> attributes, String key, Object value) {
		if(value != null && attributes != null && key != null && !key.isEmpty()) {
			attributes.put(key, value);
		}
	}
}
