package com.oracle.webservices.impl.disi.client;

import com.newrelic.api.agent.NewRelic;
import com.newrelic.api.agent.Trace;
import com.newrelic.api.agent.weaver.Weave;
import com.newrelic.api.agent.weaver.Weaver;
import com.sun.xml.ws.api.message.Packet;
import com.sun.xml.ws.api.pipe.NextAction;

@Weave(originalName = "com.oracle.webservices.impl.disi.client.ClientTransportTube")
class ClientTransportTube_Instrumentation {

    @Trace
    public NextAction processException(Throwable t) {
        NewRelic.noticeError(t);
        NextAction nextAction = Weaver.callOriginal();
        if(nextAction != null) {
            NewRelic.getAgent().getTracedMethod().addCustomAttribute("NextAction", nextAction.getKindString());
        }
        return nextAction;
    }

    @Trace
    public NextAction processResponse(Packet response) {
        NextAction nextAction = Weaver.callOriginal();
        if(nextAction != null) {
            NewRelic.getAgent().getTracedMethod().addCustomAttribute("NextAction", nextAction.getKindString());
        }
        return nextAction;
    }

    @Trace
    public NextAction processRequest(Packet request) {
        NextAction nextAction = Weaver.callOriginal();
        if(nextAction != null) {
            NewRelic.getAgent().getTracedMethod().addCustomAttribute("NextAction", nextAction.getKindString());
        }
        return nextAction;
    }
}
