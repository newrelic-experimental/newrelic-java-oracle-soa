package oracle.integration.platform.blocks.mesh;

import com.newrelic.api.agent.NewRelic;
import com.newrelic.api.agent.Trace;
import com.newrelic.api.agent.weaver.Weave;
import com.newrelic.api.agent.weaver.Weaver;

import oracle.fabric.common.InvocationContext;
import oracle.fabric.common.NormalizedMessage;
import oracle.fabric.common.Operation;

@Weave
public abstract class MessageRouter {

	@Trace
	public NormalizedMessage request(NormalizedMessage message, Operation operation, InvocationContext context) {
		if(operation != null) {
			String opName = operation.getName();
			if(opName != null) {
				NewRelic.getAgent().getTracedMethod().setMetricName("Custom","Fabric","MessageRouter","request",opName);
			}
		}
		return Weaver.callOriginal();
	}
	
	public void post(NormalizedMessage message, Operation operation, InvocationContext context) {
		if(operation != null) {
			String opName = operation.getName();
			if(opName != null) {
				NewRelic.getAgent().getTracedMethod().setMetricName("Custom","Fabric","MessageRouter","post",opName);
			}
		}
		Weaver.callOriginal();
	}
}
