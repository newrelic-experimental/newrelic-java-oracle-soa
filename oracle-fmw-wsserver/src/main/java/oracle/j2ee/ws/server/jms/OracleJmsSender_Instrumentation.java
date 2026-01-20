package oracle.j2ee.ws.server.jms;

import com.newrelic.api.agent.NewRelic;
import com.newrelic.api.agent.weaver.MatchType;
import com.newrelic.api.agent.weaver.Weave;
import com.newrelic.api.agent.weaver.Weaver;

import javax.xml.soap.SOAPElement;

@Weave(type = MatchType.Interface, originalName = "oracle.j2ee.ws.server.jms.OracleJmsSender")
public class OracleJmsSender_Instrumentation {

    public void send(SOAPElement var1, OracleJmsProperties var2) {
        NewRelic.getAgent().getTracedMethod().setMetricName("Custom","SOA","OracleJmsSender",getClass().getSimpleName(),"send");

        Weaver.callOriginal();
    }
}
