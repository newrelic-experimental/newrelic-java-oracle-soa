package oracle.j2ee.ws.server.jms;

import com.newrelic.api.agent.NewRelic;
import com.newrelic.api.agent.Trace;
import com.newrelic.api.agent.weaver.MatchType;
import com.newrelic.api.agent.weaver.Weave;
import com.newrelic.api.agent.weaver.Weaver;
import oracle.j2ee.ws.server.jms.holders.OracleJmsPropertiesHolder;

import javax.xml.soap.SOAPElement;

@Weave(type = MatchType.Interface, originalName = "oracle.j2ee.ws.server.jms.OracleJmsReceiver")
public class OracleJmsReceiver_Instrumentation {

    @Trace(dispatcher = true)
    public SOAPElement receive(OracleJmsPropertiesHolder var1) {
        NewRelic.getAgent().getTracedMethod().setMetricName("Custom","SOA","OracleJmsReceiver",getClass().getSimpleName(),"receive");
        return Weaver.callOriginal();
    }
}
