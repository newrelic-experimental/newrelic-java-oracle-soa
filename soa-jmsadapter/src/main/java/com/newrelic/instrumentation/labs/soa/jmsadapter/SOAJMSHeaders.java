package com.newrelic.instrumentation.labs.soa.jmsadapter;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import com.newrelic.api.agent.HeaderType;
import com.newrelic.api.agent.Headers;

@SuppressWarnings({"unchecked", "rawtypes"} )
public class SOAJMSHeaders implements Headers {
	
	private Map properties;
	
	public SOAJMSHeaders(Map props) {
		properties = props;
	}

	@Override
	public void addHeader(String name, String value) {
		properties.put(name, value);
	}

	@Override
	public boolean containsHeader(String name) {
		return properties.containsKey(name);
	}

	@Override
	public String getHeader(String name) {
		return properties.get(name).toString();
	}

	@Override
	public Collection<String> getHeaderNames() {
		Set<String> set = new HashSet<String>();
		for(Object key : properties.keySet()) {
			set.add(key.toString());
		}
		return set;
	}

	@Override
	public HeaderType getHeaderType() {
		return HeaderType.MESSAGE;
	}

	@Override
	public Collection<String> getHeaders(String name) {
		List<String> list = new ArrayList<String>();
		String value = getHeader(name);
		if(value != null) {
			list.add(value);
		}
		return list;
	}

	@Override
	public void setHeader(String name, String value) {
		properties.put(name, value);
	}

}
