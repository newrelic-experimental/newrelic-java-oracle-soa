package oracle.tip.adapter.jms.JMS;

import java.util.HashMap;

import javax.jms.Destination;
import javax.jms.Queue;
import javax.jms.Topic;

import com.newrelic.api.agent.NewRelic;
import com.newrelic.api.agent.Trace;
import com.newrelic.api.agent.weaver.Weave;
import com.newrelic.api.agent.weaver.Weaver;

import oracle.tip.adapter.api.record.BaseRecord;
import oracle.tip.adapter.api.sw.AdapterStopWatch;
import oracle.tip.adapter.jms.JmsAdapterMessage;
import oracle.tip.adapter.jms.outbound.JmsProduceInteractionSpec;
import oracle.tip.adapter.jms.outbound.JmsRequestReplyInteractionSpec;

@Weave(originalName = "oracle.tip.adapter.jms.JMS.JMSMessageProducer")
public abstract class JMSMessageProducer_Instrumentation {
	
	@Trace
	public String produce(JmsProduceInteractionSpec interactionSpec, JmsAdapterMessage outboundMessage, AdapterStopWatch jmsStopWatch) {
		Destination destination = interactionSpec.getDestination();
		HashMap<String, Object> attributes = new HashMap<String, Object>();
		if(destination != null) {
			if(destination instanceof Queue) {
				attributes.put("Destination-Type", "Queue");
			} else if(destination instanceof Topic) {
				attributes.put("Destination-Type", "Topic");
			}
		}
		String destName = interactionSpec.getDestinationName();
		if(destName != null) {
			attributes.put("DestinationName", destName);
		}
		NewRelic.getAgent().getTracedMethod().addCustomAttributes(attributes);
		return Weaver.callOriginal();
	}

	@Trace
	public boolean request(JmsRequestReplyInteractionSpec interactionSpec, JmsAdapterMessage outboundMessage, AdapterStopWatch jmsStopWatch, BaseRecord replyRecord) {
		Destination destination = interactionSpec.getDestination();
		HashMap<String, Object> attributes = new HashMap<String, Object>();
		if(destination != null) {
			if(destination instanceof Queue) {
				attributes.put("Destination-Type", "Queue");
			} else if(destination instanceof Topic) {
				attributes.put("Destination-Type", "Topic");
			}
		}
		String destName = interactionSpec.getDestinationName();
		if(destName != null) {
			attributes.put("DestinationName", destName);
		}
		String replyDestName = interactionSpec.getReplyDestinationName();
		if(replyDestName != null) {
			attributes.put("ReplyDestinationName", replyDestName);
		}
		NewRelic.getAgent().getTracedMethod().addCustomAttributes(attributes);
		return Weaver.callOriginal();
	}
}
