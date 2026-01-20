package com.oracle.webservices.impl.disi.service;

import com.newrelic.api.agent.Trace;
import com.newrelic.api.agent.weaver.Weave;
import com.newrelic.api.agent.weaver.Weaver;
import com.oracle.webservices.api.message.MessageContext;

@Weave(originalName = "com.oracle.webservices.impl.disi.service.NonSOAPResponseProcessor")
class NonSOAPResponseProcessor_Instrumentation {

    @Trace
    public boolean request(MessageContext requestContext, ServiceResponseTransportProcessor serviceResponseTransportProcessor, NoValueFuture<?> future) {
        return Weaver.callOriginal();
    }
}
