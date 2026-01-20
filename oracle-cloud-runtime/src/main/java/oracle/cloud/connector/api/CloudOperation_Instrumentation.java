package oracle.cloud.connector.api;

import com.newrelic.api.agent.NewRelic;
import com.newrelic.api.agent.Trace;
import com.newrelic.api.agent.weaver.MatchType;
import com.newrelic.api.agent.weaver.Weave;
import com.newrelic.api.agent.weaver.Weaver;

@Weave(type = MatchType.Interface, originalName = "oracle.cloud.connector.api.CloudOperation")
public abstract class CloudOperation_Instrumentation {

    public abstract String getName();

    @Trace
    public CloudMessage invoke(CloudMessage var1) {
        NewRelic.getAgent().getTracedMethod().setMetricName("OracleSOA", "CloudOperation", getClass().getSimpleName() ,getName(),"invoke");
        return Weaver.callOriginal();
    }
}
