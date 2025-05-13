package com.newrelic.instrumentation.labs.jca;

import javax.resource.spi.work.Work;

import com.newrelic.api.agent.Token;
import com.newrelic.api.agent.Trace;

public class WorkWrapper implements Work {
	
	private Work delegate = null;
	private Token token = null;
	
	public WorkWrapper(Work d, Token t) {
		delegate = d;
		token = t;
	}

	@Override
	@Trace(async = true)
	public void run() {
		if(token != null) {
			token.linkAndExpire();
			token = null;
		}
		if(delegate != null) {
			delegate.run();
		}
	}

	@Override
	public void release() {
		if(token != null) {
			token.expire();
			token = null;
		}
		if(delegate != null) {
			delegate.release();
		}
	}

}
