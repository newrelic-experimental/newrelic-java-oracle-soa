package com.collaxa.cube.engine.dispatch.message;

import com.newrelic.api.agent.NewRelic;
import com.newrelic.api.agent.Trace;
import com.newrelic.api.agent.weaver.MatchType;
import com.newrelic.api.agent.weaver.Weave;
import com.newrelic.api.agent.weaver.Weaver;

@Weave(type= MatchType.Interface, originalName = "com.collaxa.cube.engine.dispatch.message.IMessageHandler")
public class IMessageHandler_Instrumentation {

    @Trace
    public IMessage handle(IMessage message) {
        NewRelic.getAgent().getTracedMethod().setMetricName(new String[] {"Custom","MessageHandler",getClass().getSimpleName(),"handle",message.getClass().getSimpleName(),"handle"});
        return Weaver.callOriginal();
    }
}
