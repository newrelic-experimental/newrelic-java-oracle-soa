package oracle.tip.adapter.api.callout;

import org.w3c.dom.Element;

import com.newrelic.api.agent.NewRelic;
import com.newrelic.api.agent.Trace;
import com.newrelic.api.agent.weaver.MatchType;
import com.newrelic.api.agent.weaver.Weave;
import com.newrelic.api.agent.weaver.Weaver;

@Weave(originalName = "oracle.tip.adapter.api.callout.Callout", type = MatchType.Interface)
public class Callout_Instrumentation {

	@Trace
	public void invoke(Element var1)  {
		NewRelic.getAgent().getTracedMethod().setMetricName("Custom","SOA-JCA","Callout",getClass().getSimpleName(),"invoke");
		Weaver.callOriginal();
	}
}
