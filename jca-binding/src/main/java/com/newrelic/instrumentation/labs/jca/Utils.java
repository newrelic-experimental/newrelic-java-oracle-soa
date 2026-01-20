package com.newrelic.instrumentation.labs.jca;

import javax.resource.spi.work.Work;

import com.newrelic.api.agent.NewRelic;
import com.newrelic.api.agent.Token;

public class Utils {
	
	public static WorkWrapper getWrapper(Work work) {
		if(work instanceof WorkWrapper) {
			return null;
		}
		Token t = NewRelic.getAgent().getTransaction().getToken();
		if(t != null && t.isActive()) {
			return new WorkWrapper(work,t);
		} else if(t != null) {
			t.expire();
			t = null;
		}
		return null;
	}

}
