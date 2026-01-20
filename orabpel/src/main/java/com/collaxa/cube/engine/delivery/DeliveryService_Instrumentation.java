package com.collaxa.cube.engine.delivery;

import com.collaxa.cube.engine.ICubeContext;
import com.collaxa.cube.engine.dispatch.message.invoke.InvokeInstanceMessage;
import com.newrelic.api.agent.NewRelic;
import com.newrelic.api.agent.Trace;
import com.newrelic.api.agent.weaver.Weave;
import com.newrelic.api.agent.weaver.Weaver;
import com.newrelic.instrumentation.oracle.soa.bpel.OracleBPELUtils;
import oracle.soa.management.ComponentDN;

import java.util.HashMap;
import java.util.Map;

@Weave(originalName = "com.collaxa.cube.engine.delivery.DeliveryService")
public class DeliveryService_Instrumentation {

    @Trace
    private void handleCallback(int conversationType, String subscriberId, long cikey, CallbackInfo cb, ComponentDN pid, ICubeContext ctx) {
        Map<String,Object> attributes = new HashMap<String,Object>();
        OracleBPELUtils.addAttribute(attributes, "ConversationType", conversationType);
        OracleBPELUtils.addAttribute(attributes, "SubscriberId", subscriberId);
        NewRelic.getAgent().getTracedMethod().addCustomAttributes(attributes);
        Weaver.callOriginal();
    }

    @Trace
    public void handleInvoke(InvokeInstanceMessage message, ICubeContext ctx) {
        Map<String,Object> attributes = new HashMap<String,Object>();
        OracleBPELUtils.addInvokeInstanceMessage(attributes, message);
        NewRelic.getAgent().getTracedMethod().addCustomAttributes(attributes);
        Weaver.callOriginal();
    }

    @Trace
    public void receiveCallback(CallbackInfo info, ICubeContext ctx) {
        Map<String,Object> attributes = new HashMap<String,Object>();
        OracleBPELUtils.addCallbackInfo(attributes, info);
        NewRelic.getAgent().getTracedMethod().addCustomAttributes(attributes);
        Weaver.callOriginal();
    }

    @Trace
    public void receiveInvoke(InvokeInfo info, ICubeContext ctx) {
        Map<String,Object> attributes = new HashMap<String,Object>();
        OracleBPELUtils.addInvokeInfo(attributes, info);
        NewRelic.getAgent().getTracedMethod().addCustomAttributes(attributes);
        Weaver.callOriginal();
    }
}
