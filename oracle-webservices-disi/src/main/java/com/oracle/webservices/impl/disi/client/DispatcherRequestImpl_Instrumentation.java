package com.oracle.webservices.impl.disi.client;

import java.util.concurrent.Future;


import com.newrelic.api.agent.NewRelic;
import com.newrelic.api.agent.Trace;
import com.newrelic.api.agent.weaver.Weave;
import com.newrelic.api.agent.weaver.Weaver;
import com.newrelic.instrumenatation.labs.oracle.ws.disi.MessageContextHeaders;
import com.oracle.webservices.api.disi.DispatcherResponse;
import com.oracle.webservices.api.message.MessageContext;

@Weave(originalName = "com.oracle.webservices.impl.disi.client.DispatcherRequestImpl")
public abstract class DispatcherRequestImpl_Instrumentation {

	@Trace
	public Future<?> request(MessageContext requestContextIn, DispatcherResponse dispatcherResponse) {
		NewRelic.getAgent().getTransaction().insertDistributedTraceHeaders(new MessageContextHeaders(requestContextIn));
		return Weaver.callOriginal();
	}
	
}
