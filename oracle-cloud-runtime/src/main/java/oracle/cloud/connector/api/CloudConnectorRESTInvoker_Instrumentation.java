package oracle.cloud.connector.api;


import com.newrelic.api.agent.Trace;
import com.newrelic.api.agent.weaver.MatchType;
import com.newrelic.api.agent.weaver.Weave;
import com.newrelic.api.agent.weaver.Weaver;

import java.util.Map;

@Weave(type = MatchType.Interface, originalName = "oracle.cloud.connector.api.CloudConnectorRESTInvoker")
public class CloudConnectorRESTInvoker_Instrumentation {

    @Trace
    public Map<String, String> invokeRestService(Map<String, String> var1) {

        return Weaver.callOriginal();
    }
}
