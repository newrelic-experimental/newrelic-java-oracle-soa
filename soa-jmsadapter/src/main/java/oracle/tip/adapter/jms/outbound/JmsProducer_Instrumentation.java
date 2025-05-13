package oracle.tip.adapter.jms.outbound;

import com.newrelic.api.agent.Trace;
import com.newrelic.api.agent.weaver.Weave;
import com.newrelic.api.agent.weaver.Weaver;

import oracle.tip.adapter.api.record.BaseRecord;
import oracle.tip.adapter.jms.JmsInteractionSpec;

@Weave(originalName = "oracle.tip.adapter.jms.outbound.JmsProducer")
public abstract class JmsProducer_Instrumentation {

	@Trace
	public boolean execute(JmsInteractionSpec ispec, BaseRecord inputXMLRecord, BaseRecord outputXMLRecord)  {
		
		return Weaver.callOriginal();
	}
}
