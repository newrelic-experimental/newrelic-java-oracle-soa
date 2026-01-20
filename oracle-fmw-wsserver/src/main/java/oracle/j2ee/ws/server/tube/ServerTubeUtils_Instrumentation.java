package oracle.j2ee.ws.server.tube;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.newrelic.api.agent.NewRelic;
import com.newrelic.instrumentation.labs.oracle.fmw.server.FMWServerUtils;
import com.oracle.webservices.impl.jms.jrf.JmsRequestWrapper;
import com.sun.xml.ws.api.server.WebServiceContextDelegate;

import com.newrelic.api.agent.Trace;
import com.newrelic.api.agent.weaver.Weave;
import com.newrelic.api.agent.weaver.Weaver;
import com.oracle.webservices.api.disi.DISIEndpoint;

import oracle.j2ee.ws.common.ProcessorContext;
import oracle.j2ee.ws.server.WebServiceProcessor_Instrumentation;

import java.util.HashMap;
import java.util.Map;

@Weave(originalName = "oracle.j2ee.ws.server.tube.ServerTubeUtils")
public class ServerTubeUtils_Instrumentation {

	@Trace
	public static void processRequest(DISIEndpoint endpoint, ServletContext servletContext,
			ProcessorContext processorContext, HttpServletRequest servletRequest, HttpServletResponse servletResponse,
			WebServiceContextDelegate wscd, WebServiceProcessor_Instrumentation processor) {
		Map<String,Object> attributes = new HashMap<String,Object>();
		FMWServerUtils.addProcessorContext(attributes, processorContext);
		NewRelic.getAgent().getTracedMethod().addCustomAttributes(attributes);
		Weaver.callOriginal();
	}

	@Trace
	public static void processRequest(DISIEndpoint endpoint, ProcessorContext processorContext, JmsRequestWrapper request, WebServiceContextDelegate wscd, WebServiceProcessor_Instrumentation processor) {
		Map<String,Object> attributes = new HashMap<String,Object>();
		FMWServerUtils.addProcessorContext(attributes, processorContext);
		NewRelic.getAgent().getTracedMethod().addCustomAttributes(attributes);
		Weaver.callOriginal();
	}

	}
