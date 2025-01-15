package weblogic.connector.work;

import javax.resource.spi.work.ExecutionContext;

import com.newrelic.api.agent.NewRelic;
import com.newrelic.api.agent.Token;
import com.newrelic.api.agent.Trace;
import com.newrelic.api.agent.weaver.NewField;
import com.newrelic.api.agent.weaver.Weave;
import com.newrelic.api.agent.weaver.Weaver;

import weblogic.connector.security.layer.WorkImpl;
import weblogic.connector.security.layer.WorkListenerImpl;

@Weave
abstract class WorkRequest {

	@NewField
	private Token token = null;
	
	WorkRequest(WorkImpl work, long startTimeout, ExecutionContext ec, WorkListenerImpl listener, WorkContextManager ctxManager) {
		Token t = NewRelic.getAgent().getTransaction().getToken();
		if(t != null && t.isActive()) {
			token = t;
		} else if(t != null) {
			t.expire();
			t = null;
		}
	}
	
	@Trace(async = true)
	public void run() {
		if(token != null) {
			token.linkAndExpire();
			token = null;
		}
		Weaver.callOriginal();
	}
}
