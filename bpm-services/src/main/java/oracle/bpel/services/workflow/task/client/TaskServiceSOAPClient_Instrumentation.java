package oracle.bpel.services.workflow.task.client;

import com.newrelic.api.agent.Trace;
import com.newrelic.api.agent.weaver.Weave;
import com.newrelic.api.agent.weaver.Weaver;
import org.w3c.dom.Element;

@Weave(originalName = "oracle.bpel.services.workflow.task.client.TaskServiceSOAPClient")
public class TaskServiceSOAPClient_Instrumentation {

    @Trace
    public Element invoke(Element input) {
        return Weaver.callOriginal();
    }
}
