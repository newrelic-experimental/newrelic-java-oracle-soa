package com.newrelic.instrumentation.labs.soa.jmsadapter;

import java.util.Collection;
import java.util.Enumeration;
import java.util.HashSet;
import java.util.Set;

import javax.jms.JMSException;
import javax.jms.Message;

import com.newrelic.api.agent.HeaderType;
import com.newrelic.api.agent.Headers;

public class JMSHeaders implements Headers {
	
	private Message message = null;
	
	public JMSHeaders(Message msg) {
		message = msg;
	}

	@Override
	public void addHeader(String name, String value) {
		try {
			message.setStringProperty(name, value);
		} catch (JMSException e) {
		}
	}

	@Override
	public boolean containsHeader(String name) {
		return false;
	}

	@Override
	public String getHeader(String name) {
		try {
			return message.getStringProperty(name);
		} catch (JMSException e) {
			return null;
		}
	}

	@SuppressWarnings("rawtypes")
	@Override
	public Collection<String> getHeaderNames() {
		Set<String> set = new HashSet<String>();
		try {
			Enumeration propertyNames = message.getPropertyNames();
			while(propertyNames.hasMoreElements()) {
				Object value = propertyNames.nextElement();
				if(value != null) {
					set.add(value.toString());
				}
			}
		} catch (JMSException e) {
		}
		return set;
	}

	@Override
	public HeaderType getHeaderType() {
		return HeaderType.MESSAGE;
	}

	@Override
	public Collection<String> getHeaders(String name) {
		Set<String> values = new HashSet<String>();
		String value = getHeader(name);
		if(value != null) {
			values.add(value);
		}
		return values;
	}

	@Override
	public void setHeader(String name, String value) {
		try {
			message.setStringProperty(name, value);
		} catch (JMSException e) {
		}
	}

}
