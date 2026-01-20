package oracle.bpel.services.workflow.fabric;

import com.newrelic.api.agent.NewRelic;
import com.newrelic.api.agent.Trace;
import com.newrelic.api.agent.weaver.Weave;
import com.newrelic.api.agent.weaver.Weaver;
import oracle.bpel.services.common.exception.ServicesException;
import oracle.bpel.services.workflow.metadata.routingslip.model.RoutingSlip;
import oracle.bpel.services.workflow.task.IInitiateTaskResponse;
import oracle.bpel.services.workflow.task.model.Task;
import oracle.fabric.common.InvocationContext;
import oracle.fabric.common.NormalizedMessage;
import oracle.fabric.common.Operation;
import org.w3c.dom.Element;

import java.util.Map;

@Weave(originalName = "oracle.bpel.services.workflow.fabric.FabricWorkflowServiceEngine")
public class FabricWorkflowServiceEngine_Instrumentation {

    @Trace(dispatcher = true)
    public int abortFlow(long flowId) {
        NewRelic.getAgent().getTracedMethod().addCustomAttribute("FlowId", flowId);
        return Weaver.callOriginal();
    }

    @Trace(dispatcher = true)
    public int abortInstancesByCompositeInstanceId(long compositeInstanceId) {
        NewRelic.getAgent().getTracedMethod().addCustomAttribute("CompositeInstanceId", compositeInstanceId);
        return Weaver.callOriginal();
    }

    @Trace(dispatcher = true)
    public void doCallback(Task task, String operation, Element message) {
        NewRelic.getAgent().getTracedMethod().addCustomAttribute("Operation", operation);
        Weaver.callOriginal();
    }

    @Trace
    public Map<String, Object> doRequest(Task task, String reference, String operation, Map<String, Object> input) {
        NewRelic.getAgent().getTracedMethod().addCustomAttribute("Reference", reference);
        NewRelic.getAgent().getTracedMethod().addCustomAttribute("Operation", operation);
        return Weaver.callOriginal();
    }

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

    @Trace
    public IInitiateTaskResponse initateTaskViaFramework(Task task, RoutingSlip routingSlip) {
        return Weaver.callOriginal();
    }

    public void reportTaskFault(Task task, ServicesException e, boolean isRecoverable) {
        NewRelic.noticeError(e);
        Weaver.callOriginal();
    }

    @Trace(dispatcher = true)
    public NormalizedMessage request(NormalizedMessage message, Operation operation, InvocationContext context) {
        NewRelic.getAgent().getTracedMethod().addCustomAttribute("Operation", operation.getName());
        return Weaver.callOriginal();
    }
}
