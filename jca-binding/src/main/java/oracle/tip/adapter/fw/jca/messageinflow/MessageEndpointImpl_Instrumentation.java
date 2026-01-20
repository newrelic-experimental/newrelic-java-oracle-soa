package oracle.tip.adapter.fw.jca.messageinflow;

import javax.resource.cci.Record;

import com.newrelic.api.agent.Trace;
import com.newrelic.api.agent.weaver.Weave;
import com.newrelic.api.agent.weaver.Weaver;

@Weave(originalName = "oracle.tip.adapter.fw.jca.messageinflow.MessageEndpointImpl")
public class MessageEndpointImpl_Instrumentation {

	@Trace(dispatcher = true)
	public Record onMessage(Record message) {
		return Weaver.callOriginal();
	}
}
