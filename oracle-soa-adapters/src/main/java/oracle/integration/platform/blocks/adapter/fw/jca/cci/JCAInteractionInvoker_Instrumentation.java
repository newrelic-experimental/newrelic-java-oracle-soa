package oracle.integration.platform.blocks.adapter.fw.jca.cci;

import java.util.HashMap;
import java.util.Map;

import javax.resource.ResourceException;
import javax.resource.cci.Interaction;

import com.newrelic.api.agent.NewRelic;
import com.newrelic.api.agent.Trace;
import com.newrelic.api.agent.weaver.Weave;
import com.newrelic.api.agent.weaver.Weaver;

import oracle.fabric.common.InvocationContext;
import oracle.fabric.common.NormalizedMessage;
import oracle.integration.platform.blocks.adapter.fw.jca.cci.JCAConnectionManager.JCAConnectionPool.JCAConnection;

@Weave(originalName = "oracle.integration.platform.blocks.adapter.fw.jca.cci.JCAInteractionInvoker")
public abstract class JCAInteractionInvoker_Instrumentation {

	protected JCAEndpointInteraction m_jcaInteraction = Weaver.callOriginal();
	protected JCAConnectionManager m_jcaConnectionManager = Weaver.callOriginal();
	protected String m_operationName = Weaver.callOriginal();
	protected String m_inputName = Weaver.callOriginal();
	protected String m_outputName = Weaver.callOriginal();
	protected String m_inputPartName = Weaver.callOriginal();
	protected String m_outputPartName = Weaver.callOriginal();
	private String m_hostName = Weaver.callOriginal();

	@Trace(dispatcher = true)
	public NormalizedMessage invokeSyncJcaReference(oracle.fabric.common.Operation operation,
			NormalizedMessage fabricRequestMessage, InvocationContext context, Map<String, String> endpointProperties) {
		NewRelic.getAgent().getTracedMethod().setMetricName("Custom","JCAInteractionInvoker","invokeSyncJcaReference", operation.getName());
		return Weaver.callOriginal();
	}

	@Trace(dispatcher = true)
	public NormalizedMessage invokeAsyncJcaReference(oracle.fabric.common.Operation operation,
			NormalizedMessage fabricRequestMessage, InvocationContext context, Map<String, String> endpointProperties) {
		NewRelic.getAgent().getTracedMethod().setMetricName("Custom","JCAInteractionInvoker","invokeAsyncJcaReference", operation.getName());
		return Weaver.callOriginal();
	}

	@Trace
	public NormalizedMessage invokeJcaReference(oracle.fabric.common.Operation operation,
			NormalizedMessage fabricRequestMessage, InvocationContext context, Map<String, String> endpointProperties,
			boolean isSync) {
		NewRelic.getAgent().getTracedMethod().setMetricName("Custom","JCAInteractionInvoker","invokeJcaReference", operation.getName());
		return Weaver.callOriginal();
	}
	
	@Trace(dispatcher = true)
	public NormalizedMessage executeJcaInteraction(oracle.fabric.common.Operation operation,
			NormalizedMessage fabricRequestMessage, Map<String, String> endpointProperties, boolean isSync) {
		NewRelic.getAgent().getTracedMethod().setMetricName("Custom","JCAInteractionInvoker","executeJcaInteraction", operation.getName());
		HashMap<String, Object> attributes = new HashMap<String, Object>();
		addAttribute(attributes, "HostName", m_hostName);
			addAttribute(attributes,"Operation", m_operationName);
			addAttribute(attributes,"inputName", m_inputName);
			addAttribute(attributes,"inputPartName", m_inputPartName);
			addAttribute(attributes,"outputName", m_outputName);
			addAttribute(attributes,"outputPartName", m_outputPartName);
			addAttribute(attributes,"JCAInteraction", m_jcaInteraction.getClass().getName());
		if(m_jcaConnectionManager != null) {
			addAttribute(attributes,"adapterName", m_jcaConnectionManager.getAdapterName());
			addAttribute(attributes,"composite",m_jcaConnectionManager.getCompositeName());
			addAttribute(attributes,"endpoint",m_jcaConnectionManager.getEndpointId());
			addAttribute(attributes,"jndiURI",m_jcaConnectionManager.getJndiLocationUri());
			addAttribute(attributes,"service",m_jcaConnectionManager.getServiceName());
			
			try {
				Map instanceProperties = fabricRequestMessage.getProperties();
				JCAConnection jcaConnection = m_jcaConnectionManager.obtainJCAConnection(instanceProperties);
				if(jcaConnection != null) {
					Interaction connectionInteraction = jcaConnection.getInteraction();
					addAttribute(attributes, "JCAConnection-Interaction", connectionInteraction.getClass().getName());
						m_jcaConnectionManager.releaseJCAConnection(jcaConnection);
				}
			} catch (Exception e) {
			}
		}
		NewRelic.getAgent().getTracedMethod().addCustomAttributes(attributes);
		return Weaver.callOriginal();
	}
	
	private void addAttribute(Map<String, Object> attributes, String key, Object value) {
		if(attributes != null && key != null && value != null) {
			attributes.put(key, value);
		}
	}
}
