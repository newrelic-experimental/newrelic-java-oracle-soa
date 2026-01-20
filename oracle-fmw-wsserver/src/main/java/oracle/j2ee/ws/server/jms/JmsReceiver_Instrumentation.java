package oracle.j2ee.ws.server.jms;

import com.newrelic.api.agent.NewRelic;
import com.newrelic.api.agent.Trace;
import com.newrelic.api.agent.weaver.MatchType;
import com.newrelic.api.agent.weaver.Weave;
import com.newrelic.api.agent.weaver.Weaver;

import javax.xml.soap.SOAPElement;

@Weave(type = MatchType.Interface, originalName = "oracle.j2ee.ws.server.jms.JmsReceiver")
public class JmsReceiver_Instrumentation {

    @Trace(dispatcher = true)
    public SOAPElement receive() {
        NewRelic.getAgent().getTracedMethod().setMetricName("Custom","SOA","JmsReceiver",getClass().getSimpleName(),"receive");
        return Weaver.callOriginal();
    }
}
