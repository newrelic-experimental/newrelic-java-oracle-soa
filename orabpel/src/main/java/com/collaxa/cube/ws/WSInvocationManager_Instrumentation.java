package com.collaxa.cube.ws;

import com.collaxa.cube.engine.ICubeContext;
import com.collaxa.cube.engine.ext.common.InvokeHandler;
import com.collaxa.cube.engine.types.bpel.CXPartnerLink;
import com.collaxa.cube.persistence.dto.WorkItemKey;
import com.newrelic.api.agent.NewRelic;
import com.newrelic.api.agent.Trace;
import com.newrelic.api.agent.weaver.Weave;
import com.newrelic.api.agent.weaver.Weaver;

import java.util.Map;

@Weave(originalName = "com.collaxa.cube.ws.WSInvocationManager")
public class WSInvocationManager_Instrumentation {

    @Trace
    public Map invoke(InvokeHandler.InstanceInvokeProperties instance, String operationName, Map inputs, CXPartnerLink partnerLink, Map callProps, ICubeContext ctx) {
        NewRelic.getAgent().getTracedMethod().addCustomAttribute("OperationName", operationName);
        NewRelic.getAgent().getTracedMethod().addCustomAttribute("PartnerLink", partnerLink.toString());
        return Weaver.callOriginal();
    }

    @Trace
    public void invokeNonblock(InvokeHandler.InstanceInvokeProperties instance, WorkItemKey wik, String operationName, Map inputs, CXPartnerLink partnerLink, Map callProps, ICubeContext ctx) {
        NewRelic.getAgent().getTracedMethod().addCustomAttribute("OperationName", operationName);
        NewRelic.getAgent().getTracedMethod().addCustomAttribute("PartnerLink", partnerLink.toString());
        Weaver.callOriginal();
    }
}
