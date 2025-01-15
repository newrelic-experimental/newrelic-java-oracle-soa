package com.newrelic.instrumenatation.labs.oracle.ws.disi;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Map;

import com.oracle.webservices.api.message.MessageContext;
import com.newrelic.api.agent.HeaderType;
import com.newrelic.api.agent.Headers;

public class MessageContextHeaders implements Headers {
	
	private MessageContext context = null;
	
	public MessageContextHeaders(MessageContext ctx) {
		context = ctx;
	}

	@Override
	public HeaderType getHeaderType() {
		return HeaderType.MESSAGE;
	}

	@Override
	public String getHeader(String name) {
		return context.get(name).toString();
	}

	@Override
	public Collection<String> getHeaders(String name) {
		List<String> list = new ArrayList<>();
		String value = getHeader(name);
		if(value != null && !value.isEmpty()) {
			list.add(value);
		}
		return list;
	}

	@Override
	public void setHeader(String name, String value) {
		context.put(name, value);
	}

	@Override
	public void addHeader(String name, String value) {
		context.put(name, value);
	}

	@Override
	public Collection<String> getHeaderNames() {
		Map<String, Object> asMap = context.asMap();
		return asMap != null ? asMap.keySet() : Collections.emptyList();
	}

	@Override
	public boolean containsHeader(String name) {
		return getHeaderNames().contains(name);
	}

}
