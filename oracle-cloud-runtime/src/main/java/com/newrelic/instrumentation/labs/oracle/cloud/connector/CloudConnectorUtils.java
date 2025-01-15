package com.newrelic.instrumentation.labs.oracle.cloud.connector;

import java.util.Map;

import javax.wsdl.Definition;

import oracle.cloud.connector.api.CloudInvocationContext;
import oracle.cloud.connector.api.CloudMessage;
import oracle.cloud.connector.api.SOAPMessageReceiver;

public class CloudConnectorUtils {

	public static void addAttribute(Map<String, Object> attributes, String key, Object value) {
		if(attributes != null && key != null && !key.isEmpty() && value != null) {
			attributes.put(key, value);
		}
	}
	
	public static void addCloudMessage(Map<String, Object> attributes, CloudMessage message, String prefix) {
		if(message != null) {
			if(prefix != null && !prefix.isEmpty()) {
				addAttribute(attributes, prefix + "-CloudMessage-Type", message.getPayloadMessageType());
			} else {
				addAttribute(attributes, "CloudMessage-Type", message.getPayloadMessageType());
			}
		}
	}

	public static void addSOAPMessageReceiver(Map<String, Object> attributes, SOAPMessageReceiver receiver) {
		if(receiver != null) {
			addAttribute(attributes, "SOAPMessageReceiver-FlowDisplayName", receiver.getFlowDisplayName());
			addAttribute(attributes, "SOAPMessageReceiver-SOAPAction", receiver.getSOAPAction());
			addAttribute(attributes, "SOAPMessageReceiver-ContextURI", receiver.getContextURI());
			addAttribute(attributes, "SOAPMessageReceiver-ReceiverProtocol", receiver.getReceiverProtocol());
		}
	}

	public static void addCloudInvocationContext(Map<String, Object> attributes, CloudInvocationContext ctx) {
		if(ctx != null) {
			addAttribute(attributes, "CloudInvocationContext-TargetOperation", ctx.getTargetOperationName());
			
		}
	}
	
	public static void addDefinition(Map<String,Object> attributes, Definition def) {
		if(def != null) {
			addAttribute(attributes, "Definition-QName", def.getQName());
		}
		
	}

}
