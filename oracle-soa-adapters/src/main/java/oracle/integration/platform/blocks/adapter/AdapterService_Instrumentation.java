package oracle.integration.platform.blocks.adapter;

import com.newrelic.api.agent.NewRelic;
import com.newrelic.api.agent.Trace;
import com.newrelic.api.agent.weaver.Weave;
import com.newrelic.api.agent.weaver.Weaver;
import com.newrelic.instrumentation.labs.soa.adapter.AdapterHeaders;

import oracle.fabric.common.InvocationContext;
import oracle.fabric.common.NormalizedMessage;
import oracle.fabric.common.Operation;

@Weave(originalName = "oracle.integration.platform.blocks.adapter.AdapterService")
public abstract class AdapterService_Instrumentation {
	
	@Trace
	public void post(NormalizedMessage message, Operation operation, InvocationContext context) {
		
		String opName = operation.getName();
		NewRelic.getAgent().getTracedMethod().setMetricName("Custom","Weblogic-SOA","AdapterService","post",opName);
		AdapterHeaders headers = new AdapterHeaders(message);
		NewRelic.getAgent().getTransaction().insertDistributedTraceHeaders(headers);
		Weaver.callOriginal();
	}

}
