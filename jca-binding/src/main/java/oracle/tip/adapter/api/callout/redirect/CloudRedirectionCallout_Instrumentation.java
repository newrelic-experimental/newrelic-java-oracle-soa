package oracle.tip.adapter.api.callout.redirect;

import java.util.Map;

import javax.resource.cci.Record;

import com.newrelic.api.agent.NewRelic;
import com.newrelic.api.agent.Trace;
import com.newrelic.api.agent.weaver.MatchType;
import com.newrelic.api.agent.weaver.Weave;
import com.newrelic.api.agent.weaver.Weaver;

@Weave(originalName = "oracle.tip.adapter.api.callout.redirect.CloudRedirectionCallout", type = MatchType.Interface)
public abstract class CloudRedirectionCallout_Instrumentation {

	@Trace(dispatcher = true)
	public Record request(Record record, Map<String, String> properties) {
		NewRelic.getAgent().getTracedMethod().setMetricName("Custom","SOA-JCA","CloudRedirectionCallout",getClass().getSimpleName(),"request");
		return Weaver.callOriginal();
	}

	@Trace(dispatcher = true)
	public void post(Record record, Map<String, String> properties) {
		NewRelic.getAgent().getTracedMethod().setMetricName("Custom","SOA-JCA","CloudRedirectionCallout",getClass().getSimpleName(),"post");
		Weaver.callOriginal();
	}

}
