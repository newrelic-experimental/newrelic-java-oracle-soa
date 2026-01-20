package oracle.integration.platform.blocks.adapter.client;

import com.newrelic.api.agent.NewRelic;
import com.newrelic.api.agent.Trace;
import com.newrelic.api.agent.TracedMethod;
import com.newrelic.api.agent.TransportType;
import com.newrelic.api.agent.weaver.Weave;
import com.newrelic.api.agent.weaver.Weaver;
import com.newrelic.instrumentation.labs.soa.adapter.AdapterHeaders;

import oracle.fabric.common.NormalizedMessage;

@Weave(originalName = "oracle.integration.platform.blocks.adapter.client.JCABindingOperation")
public abstract class JCABindingOperation_Instrumentation {

	private String m_portTypeName = Weaver.callOriginal();
	private String m_operationName = Weaver.callOriginal();

	@Trace(dispatcher = true)
	public void executeInputOnlyOperation(Object input)  {
		TracedMethod traced = NewRelic.getAgent().getTracedMethod();
		traced.addCustomAttribute("PortName", m_portTypeName);
		traced.addCustomAttribute("OperationName", m_operationName);
		Weaver.callOriginal();
	}
	
	@Trace(dispatcher = true)
	public NormalizedMessage executeRequestResponseOperation(NormalizedMessage input) {
		AdapterHeaders headers = new AdapterHeaders(input);
		NewRelic.getAgent().getTransaction().acceptDistributedTraceHeaders(TransportType.Other, headers);
		TracedMethod traced = NewRelic.getAgent().getTracedMethod();
		traced.addCustomAttribute("PortName", m_portTypeName);
		traced.addCustomAttribute("OperationName", m_operationName);
		return Weaver.callOriginal();
	}
	
	@Trace(dispatcher = true)
	public Object executeRequestResponseOperation(Object input) {
		TracedMethod traced = NewRelic.getAgent().getTracedMethod();
		traced.addCustomAttribute("PortName", m_portTypeName);
		traced.addCustomAttribute("OperationName", m_operationName);
		return Weaver.callOriginal();
	}
}
