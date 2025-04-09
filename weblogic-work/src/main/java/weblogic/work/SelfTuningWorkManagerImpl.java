package weblogic.work;

import com.newrelic.api.agent.NewRelic;
import com.newrelic.api.agent.Token;
import com.newrelic.api.agent.Trace;
import com.newrelic.api.agent.weaver.NewField;
import com.newrelic.api.agent.weaver.Weave;
import com.newrelic.api.agent.weaver.Weaver;

import weblogic.invocation.ComponentInvocationContext;

@Weave
public abstract class SelfTuningWorkManagerImpl extends WorkManagerImpl {

	@Weave
	private static final class WorkAdapterImpl {
		
		@NewField
		private Token token = null;
		
		private WorkAdapterImpl(Runnable runnable) {
			if (token == null) {
				Token t = NewRelic.getAgent().getTransaction().getToken();
				if (t != null && t.isActive()) {
					token = t;
				} else if(t != null) {
					t.expire();
					t = null;
				}
			}
		}
		
		private WorkAdapterImpl(Runnable runnable, ComponentInvocationContext cic) {
			if (token == null) {
				Token t = NewRelic.getAgent().getTransaction().getToken();
				if (t != null && t.isActive()) {
					token = t;
				} else if(t != null) {
					t.expire();
					t = null;
				}
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

		@SuppressWarnings("unused")
		public Runnable cancel(String reason) {
			if(token != null) {
				token.expire();
				token = null;
			}
			return Weaver.callOriginal();
		}
		
		@SuppressWarnings("unused")
		public void release() {
			if(token != null) {
				token.expire();
				token = null;
			}
			Weaver.callOriginal();
		}
	}
}
