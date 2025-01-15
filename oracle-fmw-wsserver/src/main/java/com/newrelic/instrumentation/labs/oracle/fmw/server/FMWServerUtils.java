package com.newrelic.instrumentation.labs.oracle.fmw.server;

import java.util.Map;

import javax.xml.namespace.QName;

import oracle.j2ee.ws.common.ProcessorContext;
import oracle.webservices.WebServiceEndpointInfo;

public class FMWServerUtils {

	public static void addAttribute(Map<String, Object> attributes, String key, Object value) {
		if(value != null && attributes != null && key != null && !key.isEmpty()) {
			attributes.put(key, value);
		}
	}

	public static void addWSEndpointInfo(Map<String, Object> attributes, WebServiceEndpointInfo info) {
		if(info != null) {
			addAttribute(attributes, "WebServiceEndpointInfo-EndpointName", info.getEndpointName());
			addAttribute(attributes, "WebServiceEndpointInfo-ImplementorType", info.getImplementorType());
			addAttribute(attributes, "WebServiceEndpointInfo-VersionID", info.getVersionID());
			QName wsName = info.getWebServiceQName();
			addAttribute(attributes, "WebServiceEndpointInfo-WebServiceNameQName", wsName);
			QName portName = info.getPortName();
			addAttribute(attributes, "WebServiceEndpointInfo-PortName", portName);
			QName serviceName = info.getServiceName();
			addAttribute(attributes, "WebServiceEndpointInfo-ServiceName", serviceName);
			QName bindingName = info.getBindingName();
			addAttribute(attributes, "WebServiceEndpointInfo-BindingName", bindingName);
			String endPtId = info.getEndpointIdentifier();
			addAttribute(attributes, "WebServiceEndpointInfo-EndpointIdentifier", endPtId);

		}
	}
	
	public static void addProcessorContext(Map<String,Object> attributes, ProcessorContext context) {
		if(context != null) {
			addAttribute(attributes, "ProcessorContext-EndpointURL", context.getEndpointURL());
			addAttribute(attributes, "ProcessorContext-RequestURI", context.getRequestURI());
			addAttribute(attributes, "ProcessorContext-URLPattern", context.getURLPattern());
		}
	}
}
