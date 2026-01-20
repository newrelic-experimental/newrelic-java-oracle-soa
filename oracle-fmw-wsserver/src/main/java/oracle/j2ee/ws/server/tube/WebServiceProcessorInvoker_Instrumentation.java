package oracle.j2ee.ws.server.tube;

import com.newrelic.api.agent.NewRelic;
import com.newrelic.api.agent.Trace;
import com.newrelic.api.agent.weaver.Weave;
import com.newrelic.api.agent.weaver.Weaver;
import com.sun.istack.NotNull;
import com.sun.xml.ws.api.message.Packet;

import java.lang.reflect.Method;

@Weave(originalName = "oracle.j2ee.ws.server.tube.WebServiceProcessorInvoker")
public class WebServiceProcessorInvoker_Instrumentation {

    @Trace
    public Object invoke(Packet packet, Method method, Object... args) {
        NewRelic.getAgent().getTracedMethod().addCustomAttribute("InvokedMethod", method.getName());
        NewRelic.getAgent().getTracedMethod().addCustomAttribute("InvokedMethodClass", method.getDeclaringClass().getName());
        return Weaver.callOriginal();
    }
}
