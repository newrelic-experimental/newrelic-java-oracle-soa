package oracle.bpel.services.workflow.common;

import com.newrelic.api.agent.NewRelic;
import com.newrelic.api.agent.Trace;
import com.newrelic.api.agent.TracedMethod;
import com.newrelic.api.agent.weaver.MatchType;
import com.newrelic.api.agent.weaver.Weave;
import com.newrelic.api.agent.weaver.Weaver;
import com.newrelic.instrumentation.labs.oracle.bpel.BPEL_Utils;

import javax.xml.soap.SOAPMessage;
import java.util.HashMap;
import java.util.Map;

@Weave(type = MatchType.Interface, originalName = "oracle.bpel.services.workflow.common.ISOAPServerDispatcher")
public abstract class ISOAPServerDispatcher_Instrumentation {

    public abstract String getServiceName();

    public abstract String getPortName();

    public abstract String getServiceNamespace();

    public abstract String getEndPointUrl();

    @Trace
    public void invokeDispatcher(SOAPMessage var1) {
        TracedMethod traced = NewRelic.getAgent().getTracedMethod();
        Map<String,Object> attributes = new HashMap<String,Object>();
        BPEL_Utils.addAttribute(attributes,"ServiceName", getServiceName());
        BPEL_Utils.addAttribute(attributes,"PortName", getPortName());
        BPEL_Utils.addAttribute(attributes,"ServiceNamespace", getServiceNamespace());
        BPEL_Utils.addAttribute(attributes,"EndPointUrl", getEndPointUrl());
        traced.setMetricName("Custom","SOA","BPEL","ISOAPServerDispatcher",getClass().getSimpleName(),"invokeDispatcher");
        traced.addCustomAttributes(attributes);
        Weaver.callOriginal();
    }
}
