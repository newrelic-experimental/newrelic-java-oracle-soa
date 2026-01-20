package oracle.j2ee.ws.server.mex;

import com.newrelic.api.agent.NewRelic;
import com.newrelic.api.agent.weaver.MatchType;
import com.newrelic.api.agent.weaver.Weave;
import com.newrelic.api.agent.weaver.Weaver;
import oracle.j2ee.ws.common.tube.JRFContext;

@Weave(type = MatchType.BaseClass, originalName = "oracle.j2ee.ws.server.mex.MEXProcessor")
public class MEXProcessor_Instrumentation {

    protected boolean processRequest(JRFContext ctx) {
        NewRelic.getAgent().getTracedMethod().setMetricName("Custom","SOA","MEXProcessor", getClass().getSimpleName(),"processRequest");
        return Weaver.callOriginal();
    }
}
