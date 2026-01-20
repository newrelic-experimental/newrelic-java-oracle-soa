package oracle.integration.platform.blocks.adapter.fw.jca.cci;

import java.util.HashMap;
import java.util.Map;

import com.newrelic.api.agent.NewRelic;
import com.newrelic.api.agent.Trace;
import com.newrelic.api.agent.weaver.Weave;
import com.newrelic.api.agent.weaver.Weaver;
import com.newrelic.instrumentation.labs.soa.adapter.Utils;

import oracle.fabric.common.InvocationContext;
import oracle.fabric.common.NormalizedMessage;


@Weave(originalName = "oracle.integration.platform.blocks.adapter.fw.jca.cci.JCAEndpointInteraction")
public class JCAEndpointInteraction_Instrumentation {

	private String m_compositeDN = Weaver.callOriginal();
	private String m_referenceName = Weaver.callOriginal();
	private String m_referenceDN = Weaver.callOriginal();
	private String m_moduleName = Weaver.callOriginal();
	private String m_portTypeName = Weaver.callOriginal();
	private String m_operationName = Weaver.callOriginal();

	@Trace(dispatcher = true)
	public NormalizedMessage performSynchronousInteraction(oracle.fabric.common.Operation operation, NormalizedMessage message, InvocationContext context) {
		Map<String, Object> attributes = new HashMap<String, Object>();
		Utils.addAttribute(attributes, "CompositeDN", m_compositeDN);
		Utils.addAttribute(attributes, "ReferenceName", m_referenceName);
		Utils.addAttribute(attributes, "ReferenceDN", m_referenceDN);
		Utils.addAttribute(attributes, "ModuleName", m_moduleName);
		Utils.addAttribute(attributes, "PortType", m_portTypeName);
		Utils.addAttribute(attributes, "OperationName", m_operationName);
		NewRelic.getAgent().getTracedMethod().addCustomAttributes(attributes);
		return Weaver.callOriginal();
	}

	@Trace(dispatcher = true)
	public NormalizedMessage performAsynchronousInteraction(final oracle.fabric.common.Operation operation, NormalizedMessage message, InvocationContext context) {
		Map<String, Object> attributes = new HashMap<String, Object>();
		Utils.addAttribute(attributes, "CompositeDN", m_compositeDN);
		Utils.addAttribute(attributes, "ReferenceName", m_referenceName);
		Utils.addAttribute(attributes, "ReferenceDN", m_referenceDN);
		Utils.addAttribute(attributes, "ModuleName", m_moduleName);
		Utils.addAttribute(attributes, "PortType", m_portTypeName);
		Utils.addAttribute(attributes, "OperationName", m_operationName);
		NewRelic.getAgent().getTracedMethod().addCustomAttributes(attributes);
		return Weaver.callOriginal();
	}

}
