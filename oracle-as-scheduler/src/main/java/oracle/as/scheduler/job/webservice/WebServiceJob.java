package oracle.as.scheduler.job.webservice;

import java.util.HashMap;

import javax.xml.soap.SOAPMessage;

import com.newrelic.api.agent.NewRelic;
import com.newrelic.api.agent.Trace;
import com.newrelic.api.agent.TracedMethod;
import com.newrelic.api.agent.weaver.MatchType;
import com.newrelic.api.agent.weaver.Weave;
import com.newrelic.api.agent.weaver.Weaver;
import com.newrelic.instrumentation.labs.job.ws.SchedulerWSUtils;

@Weave(type = MatchType.BaseClass)
public abstract class WebServiceJob {

	@Trace
	protected SOAPMessage invoke(long requestId, WebServiceOperation wsOp) {
		TracedMethod traced = NewRelic.getAgent().getTracedMethod();
		if (wsOp != null) {
			HashMap<String, Object> attributes = new HashMap<>();
			SchedulerWSUtils.addAttribute(attributes, "WebServiceOperation-MessageId", wsOp.getMessageId());
			SchedulerWSUtils.addAttribute(attributes, "WebServiceOperation-EndpointURL", wsOp.getEndpointURL());
			SchedulerWSUtils.addAttribute(attributes, "WebServiceOperation-RequestMessage", wsOp.getRequestMessage());
			traced.addCustomAttributes(attributes);
			String serviceName = wsOp.getServiceName();
			String opName = wsOp.getOperation();
			if (serviceName != null && !serviceName.isEmpty()) {
				if (opName != null && !opName.isEmpty()) {
					traced.setMetricName("Custom", "Oracle", "Scheduler", "WSJob", getClass().getSimpleName(), "invoke",
							serviceName, opName);
				} else {
					traced.setMetricName("Custom", "Oracle", "Scheduler", "WSJob", getClass().getSimpleName(), "invoke",
							serviceName, "NoOperationName");
				}
			} else if (opName != null && !opName.isEmpty()) {
				traced.setMetricName("Custom", "Oracle", "Scheduler", "WSJob", getClass().getSimpleName(), "invoke",
						"NoServiceName", opName);
			} else {
				traced.setMetricName("Custom", "Oracle", "Scheduler", "WSJob", getClass().getSimpleName(), "invoke",
						"NoServiceName", "NoOperationName");
			} 
		}
		return Weaver.callOriginal();
	}
}
