package oracle.bpel.services.workflow.client;

import com.newrelic.api.agent.NewRelic;
import com.newrelic.api.agent.Trace;
import com.newrelic.api.agent.weaver.Weave;
import com.newrelic.api.agent.weaver.Weaver;
import oracle.bpel.services.workflow.IWorkflowConstants;

import javax.xml.namespace.QName;
import javax.xml.soap.SOAPMessage;

@Weave(originalName = "oracle.bpel.services.workflow.client.SOAPDispatcher")
public abstract class SOAPDispatcher_Instrumentation {


    @Trace
    public static SOAPMessage dispatch(WorkflowServiceClientContext context, IWorkflowConstants.ServiceInfo serviceInfo, SOAPMessage message) {
        NewRelic.getAgent().getTracedMethod().addCustomAttribute("ServiceName", serviceInfo.getServiceName());
        NewRelic.getAgent().getTracedMethod().addCustomAttribute("ServiceNamespace", serviceInfo.getServiceNamespace());
        NewRelic.getAgent().getTracedMethod().addCustomAttribute("JNDIServiceName", serviceInfo.getJNDIServiceName());
        QName portName = serviceInfo.getPortQName();
        if (portName != null) {
            NewRelic.getAgent().getTracedMethod().addCustomAttribute("PortName", portName.toString());
        }
        return Weaver.callOriginal();
    }
}
