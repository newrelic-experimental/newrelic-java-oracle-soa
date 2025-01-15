package oracle.cloud.connector.impl.soap;

import java.util.HashMap;

import com.newrelic.api.agent.NewRelic;
import com.newrelic.api.agent.Token;
import com.newrelic.api.agent.Trace;
import com.newrelic.api.agent.TransportType;
import com.newrelic.api.agent.weaver.MatchType;
import com.newrelic.api.agent.weaver.NewField;
import com.newrelic.api.agent.weaver.Weave;
import com.newrelic.api.agent.weaver.WeaveAllConstructors;
import com.newrelic.api.agent.weaver.Weaver;
import com.newrelic.instrumentation.labs.oracle.cloud.connector.CloudConnectorUtils;
import com.newrelic.instrumentation.labs.oracle.cloud.connector.CloudMessageHeaders;

import oracle.cloud.connector.api.CloudMessage;
import oracle.cloud.connector.api.SOAPMessageReceiver;

@Weave(type = MatchType.BaseClass)
public abstract class BaseSOAPMessageReceiver implements SOAPMessageReceiver {
	
	@NewField
	protected Token token = null;
	
	@WeaveAllConstructors
	public BaseSOAPMessageReceiver() {
		if(token == null) {
			Token t = NewRelic.getAgent().getTransaction().getToken();
			if(t != null && t.isActive()) {
				token = t;
			} else if(t != null) {
				t.expire();
				t = null;
			}
		}
	}

	@Override
	@Trace(async = true)
	public void run() {
		if(token != null) {
			token.linkAndExpire();
			token = null;;
		}
		Weaver.callOriginal();
	}

	@Override
	@Trace(dispatcher = true)
	public CloudMessage onMessage(CloudMessage inbound) {
		CloudMessageHeaders headers = new CloudMessageHeaders(inbound);
		NewRelic.getAgent().getTransaction().acceptDistributedTraceHeaders(TransportType.Other, headers);
		HashMap<String, Object> attributes = new HashMap<>();
		CloudConnectorUtils.addCloudMessage(attributes, inbound, "Inbound");
		CloudMessage result = Weaver.callOriginal();
		CloudConnectorUtils.addCloudMessage(attributes, result, "Result");
		NewRelic.addCustomParameters(attributes);
		return result;
	}

	
}
