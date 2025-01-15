package oracle.integration.platform.blocks.mesh;

import com.newrelic.api.agent.NewRelic;
import com.newrelic.api.agent.Trace;
import com.newrelic.api.agent.weaver.MatchType;
import com.newrelic.api.agent.weaver.Weave;
import com.newrelic.api.agent.weaver.Weaver;

import oracle.fabric.common.InvocationContext;
import oracle.fabric.common.NormalizedMessage;
import oracle.fabric.common.Operation;

@Weave(type = MatchType.Interface)
public abstract class MessageHandler {

	@Trace
	public NormalizedMessage doCallbackRequest(NormalizedMessage var1, Operation var2, InvocationContext var3) {
		NewRelic.getAgent().getTracedMethod().setMetricName("Custom","Fabric","MessageHandler",getClass().getSimpleName(),"doCallbackRequest");
		return Weaver.callOriginal();
	}
	
	@Trace
	public NormalizedMessage doRequest(NormalizedMessage var1, Operation var2, InvocationContext var3) {
		NewRelic.getAgent().getTracedMethod().setMetricName("Custom","Fabric","MessageHandler",getClass().getSimpleName(),"doRequest");
		return Weaver.callOriginal();
	}

	@Trace
	public void doCallbackPost(NormalizedMessage var1, Operation var2, InvocationContext var3) {
		NewRelic.getAgent().getTracedMethod().setMetricName("Custom","Fabric","MessageHandler",getClass().getSimpleName(),"doCallbackPost");
		Weaver.callOriginal();
	}

	@Trace
	public void doPost(NormalizedMessage var1, Operation var2, InvocationContext var3) {
		NewRelic.getAgent().getTracedMethod().setMetricName("Custom","Fabric","MessageHandler",getClass().getSimpleName(),"doPost");
		Weaver.callOriginal();
	}

}
