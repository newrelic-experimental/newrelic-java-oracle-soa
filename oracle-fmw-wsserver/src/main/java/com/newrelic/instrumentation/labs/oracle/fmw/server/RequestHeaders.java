package com.newrelic.instrumentation.labs.oracle.fmw.server;

import HTTPClient.NVPair;
import HTTPClient.Request;
import com.newrelic.api.agent.HeaderType;
import com.newrelic.api.agent.Headers;

import java.util.*;

public class RequestHeaders implements Headers {

    private final Request request;

    public RequestHeaders(Request request) {
        this.request = request;
    }

    @Override
    public HeaderType getHeaderType() {
        return HeaderType.HTTP;
    }

    @Override
    public String getHeader(String name) {
        NVPair[] headers = request.getHeaders();
        for (NVPair header : headers) {
            if(header.getName().equalsIgnoreCase(name)) {
                return header.getValue();
            }
        }
        return "";
    }

    @Override
    public Collection<String> getHeaders(String name) {
        List<String> headers = new ArrayList<>();
        String value = getHeader(name);
        if(value != null) {
            headers.add(value);
        }
        return headers;
    }

    @Override
    public void setHeader(String name, String value) {
        NVPair[] headers = request.getHeaders();
        List<NVPair> newHeaders = headers != null ? Arrays.asList(headers) : new  ArrayList<>();
        newHeaders.add(new NVPair(name, value));
        NVPair[] newHeadersArray = new NVPair[newHeaders.size()];
        request.setHeaders(newHeaders.toArray(newHeadersArray));
    }

    @Override
    public void addHeader(String name, String value) {
        setHeader(name, value);
    }

    @Override
    public Collection<String> getHeaderNames() {
        NVPair[] headers = request.getHeaders();
        Set<String> headerNames = new HashSet<>();
        for (NVPair header : headers) {
            headerNames.add(header.getName());
        }
        return headerNames;
    }

    @Override
    public boolean containsHeader(String name) {
        return getHeaderNames().contains(name);
    }
}
