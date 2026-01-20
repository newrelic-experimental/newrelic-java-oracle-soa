package com.oracle.webservices.api;

import com.newrelic.api.agent.NewRelic;
import com.newrelic.api.agent.Trace;
import com.newrelic.api.agent.weaver.MatchType;
import com.newrelic.api.agent.weaver.Weave;
import com.newrelic.api.agent.weaver.Weaver;
import com.oracle.webservices.api.disi.DispatcherResponse;
import com.oracle.webservices.api.message.MessageContext;

import java.util.concurrent.Future;

@Weave(type = MatchType.BaseClass, originalName = "com.oracle.webservices.api.disi.DispatcherRequest")
public class DispatcherRequest_Instrumentation {

    @Trace
    public Future<?> request(MessageContext var1, DispatcherResponse var2) {
        NewRelic.getAgent().getTracedMethod().setMetricName("Custom","SOA","DispatcherRequest",getClass().getSimpleName(),"request");
        return Weaver.callOriginal();
    }
}
