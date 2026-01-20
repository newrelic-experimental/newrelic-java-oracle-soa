package oracle.tip.adapter.fw.jca.work;

import javax.resource.spi.work.Work;

import com.newrelic.api.agent.weaver.Weave;
import com.newrelic.api.agent.weaver.Weaver;
import com.newrelic.instrumentation.labs.jca.Utils;
import com.newrelic.instrumentation.labs.jca.WorkWrapper;

@Weave(originalName = "oracle.tip.adapter.fw.jca.work.WorkManagerImpl")
public class WorkManagerImpl_Instrumentation {

	public void scheduleWork(Work work) {
		WorkWrapper wrapper = Utils.getWrapper(work);
		if(wrapper != null) {
			work = wrapper;
		}
		Weaver.callOriginal();
	}
}
