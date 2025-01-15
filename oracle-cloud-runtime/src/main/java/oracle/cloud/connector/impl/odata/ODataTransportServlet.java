package oracle.cloud.connector.impl.odata;

import javax.servlet.http.HttpServletRequest;

import com.newrelic.api.agent.Trace;
import com.newrelic.api.agent.weaver.Weave;
import com.newrelic.api.agent.weaver.Weaver;

import oracle.cloud.connector.api.CloudAdapterLoggingService;
import oracle.cloud.connector.api.CloudMessage;
import weblogic.servlet.FutureServletResponse;

@Weave
public abstract class ODataTransportServlet {

	@Trace
	public void service(HttpServletRequest request, FutureServletResponse response) {
		Weaver.callOriginal();
	}
	
	@Trace
	private CloudMessage processRequest(HttpServletRequest httpServletRequest, CloudAdapterLoggingService logger,
			String reqMediaType, String encoding) {
		return Weaver.callOriginal();
	}
}
