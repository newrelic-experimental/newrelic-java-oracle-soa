package oracle.j2ee.ws.server.jaxws;

import com.newrelic.api.agent.NewRelic;
import com.newrelic.api.agent.Trace;
import com.newrelic.api.agent.weaver.MatchType;
import com.newrelic.api.agent.weaver.Weave;
import com.newrelic.api.agent.weaver.Weaver;
import com.newrelic.instrumentation.labs.oracle.fmw.server.FMWServerUtils;

import java.util.HashMap;
import java.util.Map;

@Weave(type = MatchType.Interface, originalName = "oracle.j2ee.ws.server.jaxws.AsyncMessageQueue")
public class AsyncMessageQueue_Instrumentation {

    @Trace
    public void send(IncomingRequestData var1, String var2) {
        Map<String,Object> attributes = new HashMap<String,Object>();
        FMWServerUtils.addIncomingRequestData(attributes, var1);
        NewRelic.getAgent().getTracedMethod().addCustomAttributes(attributes);
        Weaver.callOriginal();
    }
}
