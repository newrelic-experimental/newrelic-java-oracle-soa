package com.oracle.webservices.api;

import com.newrelic.api.agent.NewRelic;
import com.newrelic.api.agent.Trace;
import com.newrelic.api.agent.weaver.MatchType;
import com.newrelic.api.agent.weaver.Weave;
import com.newrelic.api.agent.weaver.Weaver;
import com.oracle.webservices.api.message.MessageContext;

@Weave(type = MatchType.Interface, originalName = "com.oracle.webservices.api.disi.Request")
public class Request_Instrumentation<RESPONSE> {

    @Trace
    public void request(MessageContext messageContext, RESPONSE response) {
        NewRelic.getAgent().getTracedMethod().setMetricName("Custom","WebServices","Request",getClass().getSimpleName(),"request");
        Weaver.callOriginal();
    }
}
