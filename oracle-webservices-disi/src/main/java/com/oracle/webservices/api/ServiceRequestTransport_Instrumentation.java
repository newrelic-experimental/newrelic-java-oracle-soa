package com.oracle.webservices.api;

import java.util.concurrent.Future;

import com.newrelic.api.agent.NewRelic;
import com.newrelic.api.agent.Trace;
import com.newrelic.api.agent.weaver.MatchType;
import com.newrelic.api.agent.weaver.Weave;
import com.newrelic.api.agent.weaver.Weaver;
import com.oracle.webservices.api.disi.ServiceResponseTransport;
import com.oracle.webservices.api.message.MessageContext;

@Weave(type = MatchType.BaseClass, originalName = "com.oracle.webservices.api.disi.ServiceRequestTransport")
public class ServiceRequestTransport_Instrumentation {
	
	@Trace
	public Future<?> request(MessageContext var1) {
		NewRelic.getAgent().getTracedMethod().setMetricName("Custom","FMW","ServiceRequestTransport",getClass().getSimpleName(),"request");
		return Weaver.callOriginal();
	}

	@Trace
	public Future<?> request(MessageContext var1, ServiceResponseTransport var2, ServiceResponseTransport var3) {
		NewRelic.getAgent().getTracedMethod().setMetricName("Custom","FMW","ServiceRequestTransport",getClass().getSimpleName(),"request");
		return Weaver.callOriginal();
	}
			
}
