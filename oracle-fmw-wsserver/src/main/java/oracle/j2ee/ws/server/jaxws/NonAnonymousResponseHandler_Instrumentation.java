package oracle.j2ee.ws.server.jaxws;

import com.newrelic.api.agent.NewRelic;
import com.newrelic.api.agent.Trace;
import com.newrelic.api.agent.TracedMethod;
import com.newrelic.api.agent.weaver.Weave;
import com.newrelic.api.agent.weaver.Weaver;
import com.newrelic.instrumentation.labs.oracle.fmw.server.FMWServerUtils;
import oracle.j2ee.ws.server.deployment.WebServiceEndpoint;

import javax.xml.namespace.QName;
import javax.xml.soap.SOAPMessage;
import javax.xml.ws.Dispatch;
import javax.xml.ws.handler.soap.SOAPMessageContext;
import java.util.HashMap;
import java.util.Map;

@Weave(originalName = "oracle.j2ee.ws.server.jaxws.NonAnonymousResponseHandler")
public class NonAnonymousResponseHandler_Instrumentation {

    private WebServiceEndpoint webServiceEndpoint = Weaver.callOriginal();

    @Trace
    private void sendResponse(Dispatch dispatch, SOAPMessageContext messageContext, SOAPMessage soapResponse, Boolean isFaultMsg, String requestMessageId)  {
        if(webServiceEndpoint != null) {
            TracedMethod tracedMethod = NewRelic.getAgent().getTracedMethod();
            Map<String, Object> attributes = new HashMap<>();
            FMWServerUtils.addWebServiceEndpoint(attributes, webServiceEndpoint);
            tracedMethod.addCustomAttributes(attributes);
        }
        Weaver.callOriginal();
    }

    }
