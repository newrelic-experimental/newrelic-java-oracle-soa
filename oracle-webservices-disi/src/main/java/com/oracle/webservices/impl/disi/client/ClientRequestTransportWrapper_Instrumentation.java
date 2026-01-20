package com.oracle.webservices.impl.disi.client;

import com.newrelic.api.agent.Trace;
import com.newrelic.api.agent.weaver.Weave;
import com.newrelic.api.agent.weaver.Weaver;
import com.oracle.webservices.api.disi.ClientResponseTransport;
import com.sun.xml.ws.api.message.Packet;

@Weave(originalName = "com.oracle.webservices.impl.disi.client.ClientRequestTransportWrapper")
public class ClientRequestTransportWrapper_Instrumentation {

    @Trace
    public void request(Packet requestContext, ClientResponseTransport clientResponseTransport) {
        Weaver.callOriginal();
    }
}
