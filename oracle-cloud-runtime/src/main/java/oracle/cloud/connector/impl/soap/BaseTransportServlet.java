package oracle.cloud.connector.impl.soap;

import javax.servlet.http.HttpServletRequest;

import com.newrelic.api.agent.NewRelic;
import com.newrelic.api.agent.Trace;
import com.newrelic.api.agent.TransactionNamePriority;
import com.newrelic.api.agent.weaver.MatchType;
import com.newrelic.api.agent.weaver.Weave;
import com.newrelic.api.agent.weaver.Weaver;

import oracle.cloud.connector.api.CloudMessage;

@Weave(type = MatchType.BaseClass)
public abstract class BaseTransportServlet {
	
	protected String _serviceRef = Weaver.callOriginal();

	@Trace
	protected CloudMessage dispatchInboundMessage(HttpServletRequest httpServletRequest, CloudMessage cloudRequestMessage)  {
		if(_serviceRef != null && !_serviceRef.isEmpty()) {
			NewRelic.getAgent().getTransaction().setTransactionName(TransactionNamePriority.FRAMEWORK_HIGH, false, "SOA-TransportServlet", "SOA","TransportServlet",_serviceRef);
			NewRelic.getAgent().getTracedMethod().setMetricName("Custom","Oracle-SOA","BaseTransportServlet",getClass().getSimpleName(),"dispatchInboundMessage");
		}
		return Weaver.callOriginal();
	}
}
