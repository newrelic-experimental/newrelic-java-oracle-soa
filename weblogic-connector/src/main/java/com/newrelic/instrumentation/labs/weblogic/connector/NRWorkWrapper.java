package com.newrelic.instrumentation.labs.weblogic.connector;

import javax.resource.spi.work.Work;

import com.newrelic.api.agent.Token;
import com.newrelic.api.agent.Trace;

public class NRWorkWrapper implements Work {
	
	private Work delegate = null;
	private Token token = null;
	
	public NRWorkWrapper(Work work) {
		delegate = work;
	}

	@Override
	@Trace(async = true)
	public void run() {
		if(token != null) {
			token.linkAndExpire();
			token = null;
		}
		delegate.run();
	}

	@Override
	public void release() {
		if(token != null) {
			token.expire();
			token = null;
		}
		delegate.release();
	}

	public boolean isTokenSet() {
		return token != null;
	}
	
	public void setToken(Token t) {
		token = t;
	}
}
