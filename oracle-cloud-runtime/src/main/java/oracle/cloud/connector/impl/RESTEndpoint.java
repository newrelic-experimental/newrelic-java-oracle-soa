package oracle.cloud.connector.impl;

import java.net.URL;
import java.util.HashMap;

import com.newrelic.api.agent.NewRelic;
import com.newrelic.api.agent.Trace;
import com.newrelic.api.agent.weaver.Weave;
import com.newrelic.api.agent.weaver.Weaver;
import com.newrelic.instrumentation.labs.oracle.cloud.connector.CloudConnectorUtils;
import com.newrelic.instrumentation.labs.oracle.cloud.connector.RestResourceHeaders;

import oracle.cloud.connector.api.CloudInvocationContext;
import oracle.cloud.connector.api.CloudMessage;
import com.sun.jersey.api.client.Client;
import oracle.cloud.connector.impl.rest.RESTResource;

@Weave
public abstract class RESTEndpoint {
	
	protected CloudInvocationContext context = Weaver.callOriginal();
	
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

	protected RESTResource createNewRestResource(URL targetURL, Client client) {
		RESTResource resource = Weaver.callOriginal();
		if(resource != null) {
			NewRelic.getAgent().getTransaction().insertDistributedTraceHeaders(new RestResourceHeaders(resource));
		}
		return resource;
	}
}
