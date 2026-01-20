package oracle.integration.platform.blocks.event;

import com.newrelic.api.agent.NewRelic;
import com.newrelic.api.agent.Trace;
import com.newrelic.api.agent.TracedMethod;
import com.newrelic.api.agent.weaver.MatchType;
import com.newrelic.api.agent.weaver.Weave;
import com.newrelic.api.agent.weaver.Weaver;
import oracle.fabric.blocks.event.ComponentId;
import oracle.fabric.blocks.event.ConsistencyLevel;
import oracle.fabric.common.BusinessEvent;
import oracle.fabric.common.NormalizedMessage;

@Weave(type = MatchType.Interface, originalName = "oracle.fabric.blocks.event.BusinessEventBus")
public class BusinessEventBus_Instrumentation {

    @Trace
    public void publishEvent(ComponentId componentId, BusinessEvent event, int var3) {
        TracedMethod traced = NewRelic.getAgent().getTracedMethod();
        traced.addCustomAttribute("Component",componentId.getComponentName());
        traced.addCustomAttribute("BusinessEvent",event.getEventName().toString());
        traced.setMetricName(new String[] {"Custom","BusinessEventBus",getClass().getSimpleName(),"publishEvent"});
        Weaver.callOriginal();
    }

    @Trace
    public void publish(ComponentId componentId, NormalizedMessage message) {
        TracedMethod traced = NewRelic.getAgent().getTracedMethod();
        traced.addCustomAttribute("Component",componentId.getComponentName());
        NewRelic.getAgent().getTracedMethod().setMetricName(new String[] {"Custom","BusinessEventBus",getClass().getSimpleName(),"publish"});
        Weaver.callOriginal();
    }

    @Trace
    public void sendEvent(ComponentId componentId1, ComponentId componentId2, ConsistencyLevel consistencyLevel, BusinessEvent event, int var5)  {
        TracedMethod traced = NewRelic.getAgent().getTracedMethod();
        traced.addCustomAttribute("Component1",componentId1.getComponentName());
        traced.addCustomAttribute("Component2",componentId2.getComponentName());
        traced.addCustomAttribute("BusinessEvent",event.getEventName().toString());
        traced.setMetricName(new String[] {"Custom","BusinessEventBus",getClass().getSimpleName(),"sendEvent"});
        Weaver.callOriginal();
    }

}
