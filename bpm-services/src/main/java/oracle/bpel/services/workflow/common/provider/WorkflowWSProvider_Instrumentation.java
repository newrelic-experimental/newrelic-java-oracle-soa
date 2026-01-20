package oracle.bpel.services.workflow.common.provider;

import com.newrelic.api.agent.Trace;
import com.newrelic.api.agent.weaver.Weave;

import javax.xml.soap.SOAPMessage;

import com.newrelic.api.agent.weaver.Weaver;
import oracle.webservices.provider.MessageContext;

@Weave(originalName = "oracle.bpel.services.workflow.common.provider.WorkflowWSProvider")
public class WorkflowWSProvider_Instrumentation {

    @Trace
    public SOAPMessage processMessage(SOAPMessage soapMessage, MessageContext context) {
        return Weaver.callOriginal();
    }
}
