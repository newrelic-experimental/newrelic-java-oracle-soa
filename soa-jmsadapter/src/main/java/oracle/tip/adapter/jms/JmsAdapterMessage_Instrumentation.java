package oracle.tip.adapter.jms;

import javax.jms.Message;

import com.newrelic.api.agent.NewRelic;
import com.newrelic.api.agent.weaver.Weave;
import com.newrelic.api.agent.weaver.Weaver;
import com.newrelic.instrumentation.labs.soa.jmsadapter.JMSHeaders;

import oracle.tip.adapter.jms.JMS.JMSConnection;

@Weave(originalName = "oracle.tip.adapter.jms.JmsAdapterMessage")
public abstract class JmsAdapterMessage_Instrumentation {

	public Message constructOutboundJMSMessage(JMSConnection jmsConnection, JmsInteractionSpec interactionSpec) {
		Message msg = Weaver.callOriginal();
		JMSHeaders headers = new JMSHeaders(msg);
		NewRelic.getAgent().getTransaction().insertDistributedTraceHeaders(headers);
		return msg;
	}
}
