package com.oracle.webservices.impl.disi.service;

import com.newrelic.api.agent.NewRelic;
import com.newrelic.api.agent.Trace;
import com.newrelic.api.agent.weaver.Weave;
import com.newrelic.api.agent.weaver.Weaver;
import com.sun.xml.ws.api.message.Packet;
import com.sun.xml.ws.api.pipe.NextAction;

@Weave(originalName = "com.oracle.webservices.impl.disi.service.DISIProviderInvokerTube")
public class DISIProviderInvokerTube_Instrumentation {

    @Trace
    public NextAction processRequest(Packet request) {
        NextAction next = Weaver.callOriginal();
        if(next != null) {
            NewRelic.getAgent().getTracedMethod().addCustomAttribute("NextAction", next.getKindString());
        }
        return next;
    }

    @Trace
    public NextAction processResponse(Packet response) {
        NextAction next = Weaver.callOriginal();
        if(next != null) {
            NewRelic.getAgent().getTracedMethod().addCustomAttribute("NextAction", next.getKindString());
        }
        return next;
    }

    @Trace
    public NextAction processException(Throwable t) {
        NewRelic.noticeError(t);
        NextAction next = Weaver.callOriginal();
        if(next != null) {
            NewRelic.getAgent().getTracedMethod().addCustomAttribute("NextAction", next.getKindString());
        }
        return next;
    }

}
