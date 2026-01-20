package oracle.tip.adapter.jms.inbound;

import java.util.Map;

import javax.resource.cci.Record;

import com.newrelic.api.agent.NewRelic;
import com.newrelic.api.agent.Trace;
import com.newrelic.api.agent.TransportType;
import com.newrelic.api.agent.weaver.MatchType;
import com.newrelic.api.agent.weaver.Weave;
import com.newrelic.api.agent.weaver.Weaver;
import com.newrelic.instrumentation.labs.soa.jmsadapter.SOAJMSHeaders;

import oracle.tip.adapter.jms.JmsAdapterMessage;

@Weave(originalName = "oracle.tip.adapter.jms.inbound.JmsConsumer", type = MatchType.BaseClass)
public class JmsConsumer_Instrumentation {

	@SuppressWarnings("rawtypes")
	@Trace(dispatcher = true)
	public void send(JmsAdapterMessage inboundMessage) {
		Map userProps = inboundMessage.getUserProperties();
		SOAJMSHeaders headers = new SOAJMSHeaders(userProps);
		NewRelic.getAgent().getTransaction().acceptDistributedTraceHeaders(TransportType.JMS, headers);
		Weaver.callOriginal();
	}
	
	@Trace
	protected Record doSend(Record xmlRecord, String inboundRecordName) {
		NewRelic.getAgent().getTracedMethod().addCustomAttribute("InboundRecordName", inboundRecordName);
		return Weaver.callOriginal();
	}
}
