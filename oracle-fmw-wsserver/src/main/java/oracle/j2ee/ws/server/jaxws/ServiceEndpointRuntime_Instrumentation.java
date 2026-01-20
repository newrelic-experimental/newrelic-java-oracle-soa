package oracle.j2ee.ws.server.jaxws;

import com.newrelic.api.agent.Trace;
import com.newrelic.api.agent.weaver.Weave;
import com.newrelic.api.agent.weaver.Weaver;
import oracle.j2ee.ws.common.handlers.HandlerChainInvoker;

import javax.xml.soap.SOAPMessage;
import javax.xml.ws.handler.soap.SOAPMessageContext;

@Weave(originalName = "oracle.j2ee.ws.server.jaxws.ServiceEndpointRuntime")
public class ServiceEndpointRuntime_Instrumentation {

    @Trace
    public SOAPMessage processMessage(SOAPMessageContext messageContext, SOAPMessage req, TieOperation mapping, HandlerChainInvoker invoker) {
        return Weaver.callOriginal();
    }

}
