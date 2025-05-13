package oracle.tip.adapter.api.callout.batch;

import com.newrelic.api.agent.NewRelic;
import com.newrelic.api.agent.Trace;
import com.newrelic.api.agent.weaver.MatchType;
import com.newrelic.api.agent.weaver.Weave;
import com.newrelic.api.agent.weaver.Weaver;

@Weave(originalName = "oracle.tip.adapter.api.callout.batch.BatchNotificationCallout", type = MatchType.Interface)
public class BatchNotificationCallout_Instrumentation {

	@Trace(dispatcher = true)
	public void onInitiateBatch(String var1, String var2) {
		NewRelic.getAgent().getTracedMethod().setMetricName("Custom","SOA-JCA","BatchNotificationCallout",getClass().getSimpleName(),"onInitiateBatch");
		Weaver.callOriginal();
	}

	@Trace(dispatcher = true)
	public void onFailedBatch(String var1, String var2, long var3, Throwable var5) {
		NewRelic.getAgent().getTracedMethod().setMetricName("Custom","SOA-JCA","BatchNotificationCallout",getClass().getSimpleName(),"onFailedBatch");
		Weaver.callOriginal();
	}

	@Trace(dispatcher = true)
	public void onCompletedBatch(String var1, String var2, long var3) {
		NewRelic.getAgent().getTracedMethod().setMetricName("Custom","SOA-JCA","BatchNotificationCallout",getClass().getSimpleName(),"onCompletedBatch");
		Weaver.callOriginal();
	}

}
