package com.newrelic.instrumentation.labs.oracle.cloud.connector;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

import com.newrelic.api.agent.HeaderType;
import com.newrelic.api.agent.Headers;

import oracle.cloud.connector.api.CloudMessage;
import oracle.cloud.connector.api.MessageHeader;
import oracle.cloud.connector.api.MessageType;
import oracle.cloud.connector.impl.HTTPHeaderBuilder;

public class CloudMessageHeaders implements Headers {
	
	private CloudMessage message = null;
	
	public CloudMessageHeaders(CloudMessage msg) {
		message = msg;
	}

	@Override
	public HeaderType getHeaderType() {
		return HeaderType.HTTP;
	}

	@Override
	public String getHeader(String name) {
		List<MessageHeader> headers = message.getHeaders();

		for(MessageHeader header : headers) {
			if(header.getHeaderName().equals(name)) {
				Object value = header.getValue();
				MessageType headerType = header.getValueType();
				if(headerType == MessageType.STRING) {
					return value.toString();
				} else if(headerType == MessageType.LIST) {
					if(value instanceof Collection) {
						Collection<?> list = (Collection<?>)value;
						if(list.size() > 0) {
							Object[] array = list.toArray();
							return array[0].toString();
						}
					}
				}
			}
		}
		return null;
	}

	@Override
	public Collection<String> getHeaders(String name) {
		List<MessageHeader> headers = message.getHeaders();

		for(MessageHeader header : headers) {
			if(header.getHeaderName().equals(name)) {
				Object value = header.getValue();
				if (value != null) {
					MessageType headerType = header.getValueType();
					if (headerType == MessageType.STRING) {
						List<String> valueList = new ArrayList<>();
						valueList.add(value.toString());
						return valueList;
					} else if (headerType == MessageType.LIST) {
						if (value instanceof Collection) {
							Collection<?> list = (Collection<?>) value;
							List<String> valueList = new ArrayList<>();
							for(Object obj : list) {
								valueList.add(obj.toString());
							}
							return valueList;
						}
					} 
				}
			}
		}
		return Collections.emptyList();
	}

	@Override
	public void setHeader(String name, String value) {
		HTTPHeaderBuilder builder = new HTTPHeaderBuilder();
		builder.setName(name);
		builder.addValue(name);
		message.addMessageHeader(builder.build());
	}

	@Override
	public void addHeader(String name, String value) {
		HTTPHeaderBuilder builder = new HTTPHeaderBuilder();
		builder.setName(name);
		builder.addValue(name);
		message.addMessageHeader(builder.build());
	}

	@Override
	public Collection<String> getHeaderNames() {
		List<MessageHeader> headers = message.getHeaders();
		List<String> names = new ArrayList<>();
		for(MessageHeader header : headers) {
			names.add(header.getHeaderName());
		}
		return names;
	}

	@Override
	public boolean containsHeader(String name) {
		return getHeaderNames().contains(name);
	}

}
