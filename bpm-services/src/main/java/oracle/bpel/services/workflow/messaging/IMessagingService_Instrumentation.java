package oracle.bpel.services.workflow.messaging;

import com.newrelic.api.agent.Trace;
import com.newrelic.api.agent.weaver.MatchType;
import com.newrelic.api.agent.weaver.Weave;
import com.newrelic.api.agent.weaver.Weaver;
import oracle.bpel.services.workflow.WorkflowException;
import oracle.bpel.services.workflow.verification.IWorkflowContext;

import java.util.Map;

@Weave(type = MatchType.Interface, originalName = "oracle.bpel.services.workflow.messaging.IMessagingService")
public class IMessagingService_Instrumentation {

    @Trace(dispatcher = true)
    public void publishMessage(IWorkflowContext workflowContext, Map<String, String> map, IMessageBody body) {
        Weaver.callOriginal();
    }

    @Trace(dispatcher = true)
    public IMessageBody receive(IWorkflowContext var1, long var2, Map<String, String> var4) {
        return Weaver.callOriginal();
    }

}
