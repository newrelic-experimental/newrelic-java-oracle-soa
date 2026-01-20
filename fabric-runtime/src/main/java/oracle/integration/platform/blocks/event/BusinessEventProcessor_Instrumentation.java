package oracle.integration.platform.blocks.event;

import com.newrelic.api.agent.NewRelic;
import com.newrelic.api.agent.Trace;
import com.newrelic.api.agent.TracedMethod;
import com.newrelic.api.agent.weaver.MatchType;
import com.newrelic.api.agent.weaver.Weave;
import com.newrelic.api.agent.weaver.Weaver;
import oracle.fabric.blocks.event.ComponentId;
import oracle.fabric.common.BusinessEvent;
import oracle.fabric.common.NormalizedMessage;

@Weave(type = MatchType.Interface, originalName = "oracle.fabric.blocks.event.BusinessEventProcessor")
public class BusinessEventProcessor_Instrumentation {

    @Trace(dispatcher = true)
    public void onEvent(ComponentId componentId, BusinessEvent businessEvent)
    {
        TracedMethod traced = NewRelic.getAgent().getTracedMethod();
        traced.setMetricName("SOA","BusinessEventProcessor",getClass().getSimpleName(),"onMessage");
        traced.addCustomAttribute("ComponentId",componentId.toString());
        traced.addCustomAttribute("BusinessEvent", businessEvent.getEventName().toString());
        Weaver.callOriginal();
    }
}
