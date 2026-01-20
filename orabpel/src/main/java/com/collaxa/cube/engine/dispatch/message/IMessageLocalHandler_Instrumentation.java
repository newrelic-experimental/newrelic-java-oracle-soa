package com.collaxa.cube.engine.dispatch.message;

import com.collaxa.cube.engine.ICubeContext;
import com.newrelic.api.agent.NewRelic;
import com.newrelic.api.agent.Trace;
import com.newrelic.api.agent.weaver.MatchType;
import com.newrelic.api.agent.weaver.Weave;
import com.newrelic.api.agent.weaver.Weaver;

@Weave(type = MatchType.Interface, originalName = "com.collaxa.cube.engine.dispatch.message.IMessageLocalHandler")
public class IMessageLocalHandler_Instrumentation {

    @Trace
    public void handleLocal(IMessage message, ICubeContext ctx) {
        NewRelic.getAgent().getTracedMethod().setMetricName("Custom","MessageLocalHandler",getClass().getSimpleName(),"handleLocal");
        Weaver.callOriginal();
    }
}
