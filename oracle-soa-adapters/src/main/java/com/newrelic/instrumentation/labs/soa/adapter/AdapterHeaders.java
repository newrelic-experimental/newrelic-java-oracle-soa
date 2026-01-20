package com.newrelic.instrumentation.labs.soa.adapter;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import com.newrelic.api.agent.HeaderType;
import com.newrelic.api.agent.Headers;

import oracle.fabric.common.NormalizedMessage;

public class AdapterHeaders implements Headers {
	
	NormalizedMessage message = null;
	
	public AdapterHeaders(NormalizedMessage msg) {
		message = msg;
	}

	@Override
	public HeaderType getHeaderType() {
		return HeaderType.MESSAGE;
	}

	@Override
	public String getHeader(String name) {
		return (String) message.getProperty(name);
	}

	@Override
	public Collection<String> getHeaders(String name) {
		String value = getHeader(name);
		List<String> list = new ArrayList<String>();
		if(value != null && !value.isEmpty()) {
			list.add(value);
		}
		return list;
	}

	@Override
	public void setHeader(String name, String value) {
		message.addProperty(name, value);
	}

	@Override
	public void addHeader(String name, String value) {
		message.addProperty(name, value);
	}

	@Override
	public Collection<String> getHeaderNames() {
		return message.getProperties().keySet();
	}

	@Override
	public boolean containsHeader(String name) {
		return getHeaderNames().contains(name);
	}

}
