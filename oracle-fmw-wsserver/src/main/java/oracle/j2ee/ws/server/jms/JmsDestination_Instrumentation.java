package oracle.j2ee.ws.server.jms;

import com.newrelic.api.agent.NewRelic;
import com.newrelic.api.agent.Trace;
import com.newrelic.api.agent.weaver.MatchType;
import com.newrelic.api.agent.weaver.Weave;
import com.newrelic.api.agent.weaver.Weaver;

import javax.xml.soap.SOAPElement;
import java.rmi.RemoteException;

@Weave(type = MatchType.Interface, originalName = "oracle.j2ee.ws.server.jms.JmsDestination")
public class JmsDestination_Instrumentation {

    @Trace
    public void send(SOAPElement soapElement) {
        NewRelic.getAgent().getTracedMethod().setMetricName("Custom","SOA","JmsDestination",getClass().getSimpleName(),"send");
        Weaver.callOriginal();
    }

    @Trace(dispatcher = true)
    public SOAPElement receive() {
        NewRelic.getAgent().getTracedMethod().setMetricName("Custom","SOA","JmsDestination",getClass().getSimpleName(),"receive");
        return Weaver.callOriginal();
    }

}
