package oracle.j2ee.ws.server.jms;

import com.newrelic.api.agent.NewRelic;
import com.newrelic.api.agent.weaver.MatchType;
import com.newrelic.api.agent.weaver.Weave;
import com.newrelic.api.agent.weaver.Weaver;
import oracle.j2ee.ws.server.jms.holders.OracleJmsPropertiesHolder;

import javax.xml.soap.SOAPElement;

@Weave(type = MatchType.Interface, originalName = "oracle.j2ee.ws.server.jms.JmsDestinationPort")
public class JmsDestinationPort_Instrumentation {

    public SOAPElement transport(SOAPElement var1, OracleJmsProperties var2, OracleJmsPropertiesHolder var3)  {
        NewRelic.getAgent().getTracedMethod().setMetricName("Custom","SOA","JmsDestinationPort",getClass().getSimpleName(),"transport");
        return Weaver.callOriginal();
    }


    public void send(SOAPElement var1) {
        NewRelic.getAgent().getTracedMethod().setMetricName("Custom","SOA","JmsDestinationPort",getClass().getSimpleName(),"send");
        Weaver.callOriginal();
    }

    public SOAPElement receive() {
        NewRelic.getAgent().getTracedMethod().setMetricName("Custom","SOA","JmsDestinationPort",getClass().getSimpleName(),"receive");
        return Weaver.callOriginal();
    }

}
