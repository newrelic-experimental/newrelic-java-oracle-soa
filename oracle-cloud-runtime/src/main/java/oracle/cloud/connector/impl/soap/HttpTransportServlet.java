package oracle.cloud.connector.impl.soap;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpServletResponseWrapper;
import javax.xml.soap.SOAPMessage;

import com.newrelic.api.agent.NewRelic;
import com.newrelic.api.agent.Trace;
import com.newrelic.api.agent.weaver.Weave;
import com.newrelic.api.agent.weaver.Weaver;

import oracle.cloud.connector.api.CloudAdapterLoggingService;
import weblogic.servlet.FutureServletResponse;

@SuppressWarnings("serial")
@Weave
public abstract class HttpTransportServlet extends BaseTransportServlet {

	@Trace
	public void service(HttpServletRequest request, FutureServletResponse response) {
		Weaver.callOriginal();
	}
	
	@Trace
	private void returnWSDL(HttpServletRequest request, HttpServletResponseWrapper response, CloudAdapterLoggingService logger) {
		NewRelic.getAgent().getTracedMethod().setMetricName("Custom","OracleSOA","HttpTransportServlet","returnWSDL");
		Weaver.callOriginal();
	}
	
	@Trace
	private void returnResource(HttpServletRequest request, HttpServletResponseWrapper response) {
		NewRelic.getAgent().getTracedMethod().setMetricName("Custom","OracleSOA","HttpTransportServlet","returnResource");
		Weaver.callOriginal();
	}
	
	@SuppressWarnings("unused")
	private String getResourceObject(HttpServletRequest request) {
		String requestObject = Weaver.callOriginal();
		NewRelic.getAgent().getTracedMethod().addCustomAttribute("Requested-Object", requestObject);
		return requestObject;
	}
	
	@Trace
	private SOAPMessage processRequest(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse,
			SOAPMessage soapRequestMessage, CloudAdapterLoggingService logger) {
		return Weaver.callOriginal();
	}
}
