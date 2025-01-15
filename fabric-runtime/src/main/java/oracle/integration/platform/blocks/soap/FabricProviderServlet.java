package oracle.integration.platform.blocks.soap;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.newrelic.api.agent.NewRelic;
import com.newrelic.api.agent.Trace;
import com.newrelic.api.agent.TransactionNamePriority;
import com.newrelic.api.agent.weaver.Weave;
import com.newrelic.api.agent.weaver.Weaver;
import com.newrelic.instrumentation.labs.fabric.runtime.FabricPathInfo;
import com.newrelic.instrumentation.labs.fabric.runtime.FabricRuntimeUtils;

@Weave
public abstract class FabricProviderServlet {
	
	protected WebServiceEntryBindingComponent wsEntryBC = Weaver.callOriginal();

	@Trace
	protected void doGet(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) {
		Weaver.callOriginal();
	}
	
	@Trace
	protected void doPost(HttpServletRequest request, HttpServletResponse response) {
		String pInfo = request.getPathInfo();
		if(pInfo != null) {
			FabricPathInfo fInfo = FabricRuntimeUtils.getServiceName(pInfo, wsEntryBC);
			if(fInfo != null) {
				String tName = fInfo.getServiceName() != null ? fInfo.getDn() + "/" + fInfo.getServiceName() : fInfo.getDn() + "/Unknown";
				NewRelic.getAgent().getTransaction().setTransactionName(TransactionNamePriority.FRAMEWORK_HIGH, false, "Fabric", tName);
			}
		}
		Weaver.callOriginal();
	}
}
