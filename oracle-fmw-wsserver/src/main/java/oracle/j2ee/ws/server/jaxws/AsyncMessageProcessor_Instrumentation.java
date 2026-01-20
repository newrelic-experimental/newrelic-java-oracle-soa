package oracle.j2ee.ws.server.jaxws;

import com.newrelic.api.agent.NewRelic;
import com.newrelic.api.agent.Trace;
import com.newrelic.api.agent.TracedMethod;
import com.newrelic.api.agent.weaver.MatchType;
import com.newrelic.api.agent.weaver.Weave;
import com.newrelic.api.agent.weaver.Weaver;
import com.newrelic.instrumentation.labs.oracle.fmw.server.FMWServerUtils;

import javax.jms.Message;
import javax.xml.namespace.QName;
import java.util.HashMap;
import java.util.Map;

@Weave(type = MatchType.BaseClass, originalName = "oracle.j2ee.ws.server.jaxws.AsyncMessageProcessor")
public class AsyncMessageProcessor_Instrumentation {

    protected QName operationName = Weaver.callOriginal();

    @Trace
    public void onMessage(IncomingRequestData data) {
        Map<String,Object> attributes = new HashMap<String,Object>();
        FMWServerUtils.addIncomingRequestData(attributes, data);
        FMWServerUtils.addAttribute(attributes,"operationName",operationName.toString());
        TracedMethod traced = NewRelic.getAgent().getTracedMethod();
        traced.addCustomAttributes(attributes);
        traced.setMetricName("Custom","SOA","AsyncMessageProcessor", getClass().getSimpleName(),"onMessage(IncomingRequestData)");
        Weaver.callOriginal();
    }

    @Trace
    public void onMessage(Message message) {
        TracedMethod traced = NewRelic.getAgent().getTracedMethod();
        traced.addCustomAttribute("operationName",operationName.toString());
        traced.setMetricName("Custom","SOA","AsyncMessageProcessor", getClass().getSimpleName(),"onMessage(Message)");
        Weaver.callOriginal();
    }
}
