package oracle.cloud.connector.impl;

import java.util.HashMap;

import javax.xml.soap.SOAPMessage;
import javax.xml.ws.Dispatch;

import com.newrelic.api.agent.NewRelic;
import com.newrelic.api.agent.Trace;
import com.newrelic.api.agent.weaver.Weave;
import com.newrelic.api.agent.weaver.Weaver;
import com.newrelic.instrumentation.labs.oracle.cloud.connector.CloudConnectorUtils;

import oracle.cloud.connector.api.CloudInvocationContext;
import oracle.cloud.connector.api.CloudMessage;

@Weave
public abstract class SOAPEndpoint {

	CloudInvocationContext context = Weaver.callOriginal();
	
	@Trace
	public CloudMessage invoke(CloudMessage message) {
		HashMap<String, Object> attributes = new HashMap<>();
		CloudConnectorUtils.addDefinition(attributes, context.getIntegrationWSDL());
		CloudConnectorUtils.addCloudMessage(attributes, message, "Inbound");
		CloudMessage result = Weaver.callOriginal();
		CloudConnectorUtils.addCloudMessage(attributes, message, "Result");
		NewRelic.getAgent().getTracedMethod().addCustomAttributes(attributes);
		return result;
	}

	@Trace
	protected SOAPMessage dispatchMessage(SOAPMessage message, Dispatch<SOAPMessage> dispatcher) {
		return Weaver.callOriginal();
	}
	
	@Trace
	protected void dispatchMessageOneWay(SOAPMessage message, Dispatch<SOAPMessage> dispatcher) {
		Weaver.callOriginal();
	}
}
