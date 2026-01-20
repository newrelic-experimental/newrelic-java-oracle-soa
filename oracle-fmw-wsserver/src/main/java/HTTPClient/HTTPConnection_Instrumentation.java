package HTTPClient;

import com.newrelic.api.agent.HttpParameters;
import com.newrelic.api.agent.NewRelic;
import com.newrelic.api.agent.Trace;
import com.newrelic.api.agent.weaver.Weave;
import com.newrelic.api.agent.weaver.Weaver;
import com.newrelic.instrumentation.labs.oracle.fmw.server.RequestHeaders;

import java.net.URI;
import java.net.URISyntaxException;

@Weave(originalName = "HTTPClient.HTTPConnection")
public abstract class HTTPConnection_Instrumentation {

    public abstract String getProtocol();
    public abstract String getHost();
    public abstract int getPort();

    @Trace
    Response sendRequest(Request req, Timeouts con_timeout) {
        NewRelic.getAgent().getTransaction().insertDistributedTraceHeaders(new RequestHeaders(req));
        try {
            String method = req.getMethod();
            String requestURI = req.getRequestURI();
            URI uri = new URI(getProtocol(),null,getHost(),getPort(),requestURI,null,null);
            HttpParameters parameters = HttpParameters.library("OracleSOA").uri(uri).procedure(method).noInboundHeaders().build();
            NewRelic.getAgent().getTracedMethod().reportAsExternal(parameters);
        } catch (URISyntaxException ignored) {
        }
        return Weaver.callOriginal();
    }
}
