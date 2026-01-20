package oracle.j2ee.ws.server.jaxws;

import com.newrelic.api.agent.NewRelic;
import com.newrelic.api.agent.Trace;
import com.newrelic.api.agent.TracedMethod;
import com.newrelic.api.agent.weaver.Weave;
import com.newrelic.api.agent.weaver.Weaver;

import javax.xml.soap.SOAPMessage;
import javax.xml.ws.handler.soap.SOAPMessageContext;

@Weave(originalName = "oracle.j2ee.ws.server.jaxws.AsyncServiceRuntimeDelegate")
public class AsyncServiceRuntimeDelegate_Instrumentation {

    @Trace
    public SOAPMessage processMessage(SOAPMessageContext messageContext, String requestURI, String userPrincipalName) {
        TracedMethod traced = NewRelic.getAgent().getTracedMethod();
        traced.addCustomAttribute("RequestURI", requestURI);
        return Weaver.callOriginal();
    }
}
