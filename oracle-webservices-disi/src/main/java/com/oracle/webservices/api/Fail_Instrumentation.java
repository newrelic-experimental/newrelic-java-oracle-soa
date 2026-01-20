package com.oracle.webservices.api;

import com.newrelic.api.agent.NewRelic;
import com.newrelic.api.agent.weaver.MatchType;
import com.newrelic.api.agent.weaver.Weave;
import com.newrelic.api.agent.weaver.Weaver;
import com.oracle.webservices.api.message.MessageContext;

@Weave(type = MatchType.Interface, originalName = "com.oracle.webservices.api.disi.Fail")
public class Fail_Instrumentation {

    public void fail(Throwable throwable, MessageContext var2) {
        NewRelic.noticeError(throwable);
        Weaver.callOriginal();
    }

}
