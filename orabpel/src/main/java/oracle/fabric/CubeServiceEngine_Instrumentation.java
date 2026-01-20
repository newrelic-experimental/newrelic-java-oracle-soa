package oracle.fabric;

import com.collaxa.cube.engine.ext.common.InvokeHandler;
import com.collaxa.cube.engine.types.bpel.CXPartnerLink;
import com.newrelic.api.agent.NewRelic;
import com.newrelic.api.agent.Trace;
import com.newrelic.api.agent.weaver.MatchType;
import com.newrelic.api.agent.weaver.Weave;
import com.newrelic.api.agent.weaver.Weaver;
import oracle.fabric.blocks.event.ComponentId;
import oracle.fabric.common.*;
import oracle.fabric.composite.CompositeDN;

@Weave(originalName = "oracle.fabric.CubeServiceEngine", type = MatchType.BaseClass)
public class CubeServiceEngine_Instrumentation {

    @Trace
    public Object executeComponentInstanceMethod(String instanceId, String methodName, Object[] parameters) {
        NewRelic.getAgent().getTracedMethod().addCustomAttribute("InstanceId", instanceId);
        NewRelic.getAgent().getTracedMethod().addCustomAttribute("MethodName", methodName);
        return Weaver.callOriginal();
    }

    @Trace
    public Object executeComponentMethod(oracle.soa.management.CompositeDN compositeDN, String componentName, String methodName, Object[] parameters) {
        NewRelic.getAgent().getTracedMethod().addCustomAttribute("ComponentName", componentName);
        NewRelic.getAgent().getTracedMethod().addCustomAttribute("MethodName", methodName);
        return Weaver.callOriginal();
    }

    @Trace
    public Object executeEngineMethod(String methodName, Object[] parameters) {
        NewRelic.getAgent().getTracedMethod().addCustomAttribute("MethodName", methodName);
        return Weaver.callOriginal();
    }

    @Trace(dispatcher = true)
    public void onEvent(ComponentId target, BusinessEvent businessEvent) {
        NewRelic.getAgent().getTracedMethod().addCustomAttribute("BusinessEvent", businessEvent.getEventName().toString());
        Weaver.callOriginal();
    }

    @Trace(dispatcher = true)
    public void onMessage(ComponentId target, NormalizedMessage message) {
        Weaver.callOriginal();
    }

    @Trace
    public void post(NormalizedMessage message, Operation operation, InvocationContext context) {
        NewRelic.getAgent().getTracedMethod().addCustomAttribute("Operation", operation.getName());
        Weaver.callOriginal();
    }

    @Trace
    public void postToMesh(NormalizedMessage nm, String operation, CXPartnerLink partnerLink, InvokeHandler.InstanceInvokeProperties instance) {
        NewRelic.getAgent().getTracedMethod().addCustomAttribute("Operation", operation);
        Weaver.callOriginal();
    }

    public NormalizedMessage request(NormalizedMessage message, Operation operation, InvocationContext context) {
        NewRelic.getAgent().getTracedMethod().addCustomAttribute("Operation", operation.getName());
        return Weaver.callOriginal();
    }

    public NormalizedMessage requestToMesh(NormalizedMessage nm, String operation, CXPartnerLink partnerLink, InvokeHandler.InstanceInvokeProperties instance) {
        NewRelic.getAgent().getTracedMethod().addCustomAttribute("Operation", operation);
        NewRelic.getAgent().getTracedMethod().addCustomAttribute("PartnerLink", partnerLink.toString());
        return Weaver.callOriginal();
    }
}
