package weblogic.connector.work;

import javax.resource.spi.work.ExecutionContext;
import javax.resource.spi.work.Work;
import javax.resource.spi.work.WorkListener;

import com.newrelic.api.agent.Trace;
import com.newrelic.api.agent.weaver.Weave;
import com.newrelic.api.agent.weaver.Weaver;

@Weave
public abstract class WorkManager {

	@Trace
	public void doWork(Work originalWork, long startTimeout, ExecutionContext execContext, WorkListener originalWorkListener)  {
		Weaver.callOriginal();
	}
	
	@Trace
	public long startWork(Work originalWork, long startTimeout, ExecutionContext execContext, WorkListener originalWorkListener) {
		return Weaver.callOriginal();
	}
	
	@Trace
	public void scheduleWork(Work originalWork, long startTimeout, ExecutionContext execContext, WorkListener originalWorkListener) {
		Weaver.callOriginal();
	}
}
