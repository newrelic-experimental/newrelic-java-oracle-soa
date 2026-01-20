package com.oracle.webservices.impl.disi.service;

import com.newrelic.api.agent.Trace;
import com.newrelic.api.agent.weaver.Weave;
import com.newrelic.api.agent.weaver.Weaver;
import com.sun.xml.ws.api.message.Packet;
import com.sun.xml.ws.api.server.AsyncProviderCallback;

import javax.xml.ws.WebServiceContext;

@Weave(originalName = "com.oracle.webservices.impl.disi.service.ProviderRequestWrapper")
class ProviderRequestWrapper_Instrumentation {

    @Trace
    public void invoke(Packet requestContext, AsyncProviderCallback<Packet> callback, WebServiceContext context) {
        Weaver.callOriginal();
    }
}
