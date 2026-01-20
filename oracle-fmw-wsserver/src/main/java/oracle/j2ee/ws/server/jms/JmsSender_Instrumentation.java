package oracle.j2ee.ws.server.jms;

import com.newrelic.api.agent.NewRelic;
import com.newrelic.api.agent.weaver.MatchType;
import com.newrelic.api.agent.weaver.Weave;
import com.newrelic.api.agent.weaver.Weaver;

import javax.xml.soap.SOAPElement;

@Weave(type = MatchType.Interface, originalName = "oracle.j2ee.ws.server.jms.JmsSender")
public class JmsSender_Instrumentation {

    public void send(SOAPElement var1) {
        NewRelic.getAgent().getTracedMethod().setMetricName("Custom","SOA","JmsSender",getClass().getSimpleName(),"send");

        Weaver.callOriginal();
    }
}
