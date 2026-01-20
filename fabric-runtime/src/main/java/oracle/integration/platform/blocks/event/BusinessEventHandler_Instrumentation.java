package oracle.integration.platform.blocks.event;

import com.newrelic.api.agent.NewRelic;
import com.newrelic.api.agent.Trace;
import com.newrelic.api.agent.TracedMethod;
import com.newrelic.api.agent.weaver.MatchType;
import com.newrelic.api.agent.weaver.Weave;
import com.newrelic.api.agent.weaver.Weaver;
import oracle.fabric.common.BusinessEvent;

@Weave(originalName = "oracle.fabric.blocks.event.BusinessEventHandler", type = MatchType.Interface)
public class BusinessEventHandler_Instrumentation {

    @Trace(dispatcher = true)
    public void onEvent(BusinessEvent event) {
        TracedMethod traced = NewRelic.getAgent().getTracedMethod();
        traced.setMetricName("Custom","BusinessEventHandler",getClass().getSimpleName(),"onEvent");
        traced.addCustomAttribute("BusinessEvent", event.getEventName().toString());
        Weaver.callOriginal();
    }
}
