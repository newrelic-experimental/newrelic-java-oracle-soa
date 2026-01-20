package com.oracle.webservices.api;

import com.newrelic.api.agent.NewRelic;
import com.newrelic.api.agent.Trace;
import com.newrelic.api.agent.weaver.MatchType;
import com.newrelic.api.agent.weaver.Weave;
import com.newrelic.api.agent.weaver.Weaver;
import com.oracle.webservices.api.message.MessageContext;

@Weave(type = MatchType.Interface, originalName = "com.oracle.webservices.api.disi.Response")
public class Response_Instrumentation {

    @Trace
    public void response(MessageContext var1) {
        NewRelic.getAgent().getTracedMethod().setMetricName(new String[] {"Custom","Response",getClass().getSimpleName(),"response"});
        Weaver.callOriginal();
    }
}
