package com.newrelic.instrumentation.labs.oracle.cloud.connector;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;

import com.newrelic.api.agent.HeaderType;
import com.newrelic.api.agent.Headers;

import oracle.cloud.connector.impl.rest.RESTResource;

public class RestResourceHeaders implements Headers {
	
	private RESTResource resource = null;
	private HashMap<String, String> added = new HashMap<>();
	
	public RestResourceHeaders(RESTResource res) {
		resource = res;
	}

	@Override
	public HeaderType getHeaderType() {
		return HeaderType.HTTP;
	}

	@Override
	public String getHeader(String name) {
		return added.get(name);
	}

	@Override
	public Collection<String> getHeaders(String name) {
		List<String> list = new ArrayList<>();
		String value = getHeader(name);
		if(value != null) {
			list.add(value);
		}
		return list;
	}

	@Override
	public void setHeader(String name, String value) {
		resource.addHeader(name, value);
		added.put(name, value);
	}

	@Override
	public void addHeader(String name, String value) {
		resource.addHeader(name, value);
		added.put(name, value);
	}

	@Override
	public Collection<String> getHeaderNames() {
		
		return added.keySet();
	}

	@Override
	public boolean containsHeader(String name) {
		return getHeaderNames().contains(name);
	}

}
