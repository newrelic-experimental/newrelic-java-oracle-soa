package oracle.as.scheduler;

import com.newrelic.api.agent.NewRelic;
import com.newrelic.api.agent.Trace;
import com.newrelic.api.agent.TracedMethod;
import com.newrelic.api.agent.weaver.MatchType;
import com.newrelic.api.agent.weaver.Weave;
import com.newrelic.api.agent.weaver.Weaver;

@Weave(type = MatchType.Interface, originalName = "oracle.as.scheduler.Executable")
public class Executable_Instrumentation {

    @Trace
    public void execute(RequestExecutionContext requestExecutionContext, RequestParameters parameters) {
        TracedMethod traced = NewRelic.getAgent().getTracedMethod();
        traced.setMetricName("SOA","BusinessEventProcessor",getClass().getSimpleName(),"execute");
        traced.addCustomAttribute("RequestHandle", requestExecutionContext.getRequestHandle());
        Weaver.callOriginal();
    }
}
