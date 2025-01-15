package oracle.as.scheduler.job.webservice;

import com.newrelic.api.agent.Trace;
import com.newrelic.api.agent.weaver.Weave;
import com.newrelic.api.agent.weaver.Weaver;

import oracle.as.scheduler.RequestExecutionContext;
import oracle.as.scheduler.RequestParameters;

@Weave
public abstract class AsyncWSJob {

	@Trace
	public void execute(RequestExecutionContext context, RequestParameters params)  {
		Weaver.callOriginal();
	}
}
