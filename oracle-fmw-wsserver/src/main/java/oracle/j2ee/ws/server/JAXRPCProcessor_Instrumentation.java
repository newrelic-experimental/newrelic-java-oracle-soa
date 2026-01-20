package oracle.j2ee.ws.server;

import com.newrelic.api.agent.Trace;
import com.newrelic.api.agent.weaver.Weave;
import com.newrelic.api.agent.weaver.Weaver;
import oracle.j2ee.ws.common.ProcessorContext;

import javax.xml.soap.SOAPMessage;

@Weave(originalName = "oracle.j2ee.ws.server.JAXRPCProcessor")
public class JAXRPCProcessor_Instrumentation {

    @Trace
    protected SOAPMessage doEndpointProcessing(Object implementor, ProcessorContext processorContext) {
        return Weaver.callOriginal();
    }

    @Trace
    public int doRequestProcessingPhaseTwo(ProcessorContext processorContext) {
        return Weaver.callOriginal();
    }

    @Trace
    public void doService(ProcessorContext processorContext) {
        Weaver.callOriginal();
    }
}
