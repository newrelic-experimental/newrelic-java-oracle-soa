package com.oracle.webservices.impl.disi.client;

import java.util.concurrent.Future;

import javax.xml.ws.handler.MessageContext;

import com.newrelic.api.agent.Trace;
import com.newrelic.api.agent.weaver.Weave;
import com.newrelic.api.agent.weaver.Weaver;
import com.oracle.webservices.api.disi.DispatcherResponse;

@Weave
public abstract class DispatcherRequestImpl {

	@Trace
	public Future<?> request(MessageContext requestContextIn, DispatcherResponse dispatcherResponse) {
		
		return Weaver.callOriginal();
	}
	
}
