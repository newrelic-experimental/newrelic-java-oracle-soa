package oracle.j2ee.ws.server;

import com.newrelic.api.agent.Trace;
import com.newrelic.api.agent.weaver.MatchType;
import com.newrelic.api.agent.weaver.Weave;
import com.newrelic.api.agent.weaver.Weaver;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Weave(type = MatchType.BaseClass, originalName = "oracle.j2ee.ws.server.WebServiceServlet")
public abstract class WebServiceServlet_Instrumentation {

    @Trace
    protected void doPost(HttpServletRequest request, HttpServletResponse response) {
        Weaver.callOriginal();
    }
}
