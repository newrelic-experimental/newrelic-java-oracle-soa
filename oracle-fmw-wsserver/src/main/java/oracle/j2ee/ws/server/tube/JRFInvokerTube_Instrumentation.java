package oracle.j2ee.ws.server.tube;

import com.newrelic.api.agent.NewRelic;
import com.newrelic.api.agent.Trace;
import com.newrelic.api.agent.weaver.Weave;
import com.newrelic.api.agent.weaver.Weaver;
import com.sun.xml.ws.api.message.Packet;
import com.sun.xml.ws.api.pipe.NextAction;

@Weave(originalName = "oracle.j2ee.ws.server.tube.JRFInvokerTube")
public class JRFInvokerTube_Instrumentation {

    @Trace
    public NextAction processRequest(Packet request) {
        NextAction nextAction = Weaver.callOriginal();
        if(nextAction != null) {
            NewRelic.getAgent().getTracedMethod().addCustomAttribute("NextAction", nextAction.getKindString());
        }
        return nextAction;
    }

}
