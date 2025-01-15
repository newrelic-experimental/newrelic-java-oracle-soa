package oracle.webservices.provider;

import javax.xml.soap.SOAPMessage;

import com.newrelic.api.agent.NewRelic;
import com.newrelic.api.agent.Trace;
import com.newrelic.api.agent.weaver.MatchType;
import com.newrelic.api.agent.weaver.Weave;
import com.newrelic.api.agent.weaver.Weaver;

@Weave(type = MatchType.Interface)
public abstract class Provider {

	@Trace
	public SOAPMessage processMessage(SOAPMessage var1, MessageContext var2) {
		NewRelic.getAgent().getTracedMethod().setMetricName("Custom","Oracle","FMWServer","Provider",getClass().getSimpleName(),"processMessage");
		return Weaver.callOriginal();
	}
}
