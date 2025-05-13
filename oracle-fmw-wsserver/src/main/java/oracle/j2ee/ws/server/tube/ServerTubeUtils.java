package oracle.j2ee.ws.server.tube;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.sun.xml.ws.api.server.WebServiceContextDelegate;

import com.newrelic.api.agent.Trace;
import com.newrelic.api.agent.weaver.Weave;
import com.newrelic.api.agent.weaver.Weaver;
import com.oracle.webservices.api.disi.DISIEndpoint;

import oracle.j2ee.ws.common.ProcessorContext;
import oracle.j2ee.ws.server.WebServiceProcessor;

@Weave
public class ServerTubeUtils {

	@Trace
	public static void processRequest(DISIEndpoint endpoint, ServletContext servletContext,
			ProcessorContext processorContext, HttpServletRequest servletRequest, HttpServletResponse servletResponse,
			WebServiceContextDelegate wscd, WebServiceProcessor processor) {
		Weaver.callOriginal();
	}
}
