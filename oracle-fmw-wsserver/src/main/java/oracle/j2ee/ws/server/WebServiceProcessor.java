package oracle.j2ee.ws.server;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.xml.soap.SOAPMessage;

import com.newrelic.api.agent.NewRelic;
import com.newrelic.api.agent.Trace;
import com.newrelic.api.agent.TracedMethod;
import com.newrelic.api.agent.weaver.MatchType;
import com.newrelic.api.agent.weaver.Weave;
import com.newrelic.api.agent.weaver.Weaver;
import com.newrelic.instrumentation.labs.oracle.fmw.server.FMWServerUtils;
import com.oracle.webservices.api.disi.DISIEndpoint;
import com.oracle.webservices.impl.jms.jrf.JmsRequestWrapper;
import com.oracle.webservices.oracle_internal_api.interceptors.InterceptorInternalMessageContext;

import oracle.j2ee.ws.common.ProcessorContext;
import oracle.webservices.WebServiceEndpointInfo;

@Weave(type = MatchType.BaseClass)
public abstract class WebServiceProcessor {
	public abstract String getAppName();

	public abstract String getModuleName();

	public abstract WebServiceEndpointInfo getEndpoint();


	@Trace
	public void doService(ProcessorContext processorContext) {
		TracedMethod traced = NewRelic.getAgent().getTracedMethod();
		HashMap<String, Object> attributes = new HashMap<>();
		FMWServerUtils.addAttribute(attributes, "AppName", getAppName());
		FMWServerUtils.addAttribute(attributes, "ModuleName", getModuleName());
		FMWServerUtils.addWSEndpointInfo(attributes, getEndpoint());
		FMWServerUtils.addProcessorContext(attributes, processorContext);
		traced.addCustomAttributes(attributes);
		traced.setMetricName("Custom","Oracle","FMWServer","WebServiceProcessor",getClass().getSimpleName(),"doService");
		Weaver.callOriginal();
	}
	
	@Trace
	public void invokeTubeEndpoint(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse,
			InterceptorInternalMessageContext msgContext, ProcessorContext processorContext, DISIEndpoint disiEndpoint) {
		NewRelic.getAgent().getTracedMethod().setMetricName("Custom","Oracle","FMWServer","WebServiceProcessor",getClass().getSimpleName(),"invokeTubeEndpoint-HTTP");
		Weaver.callOriginal();
	}
	
	@Trace
	public void invokeTubeEndpoint(JmsRequestWrapper request, InterceptorInternalMessageContext msgContext,
			ProcessorContext processorContext, DISIEndpoint disiEndpoint) {
		NewRelic.getAgent().getTracedMethod().setMetricName("Custom","Oracle","FMWServer","WebServiceProcessor",getClass().getSimpleName(),"invokeTubeEndpoint-JMS");
		Weaver.callOriginal();
	}
	
	@Trace
	protected int doRequestProcessing(ProcessorContext processorContext) {
		NewRelic.getAgent().getTracedMethod().setMetricName("Custom","Oracle","FMWServer","WebServiceProcessor",getClass().getSimpleName(),"doRequestProcessing");
		return Weaver.callOriginal();
	}
	
	@Trace
	public int doRequestProcessingPhaseTwo(ProcessorContext var1) {
		NewRelic.getAgent().getTracedMethod().setMetricName("Custom","Oracle","FMWServer","WebServiceProcessor",getClass().getSimpleName(),"doRequestProcessingPhaseTwo");
		return Weaver.callOriginal();
	}
	
	@Trace
	protected boolean executeInterceptorRequestChain(ProcessorContext var1) {
		NewRelic.getAgent().getTracedMethod().setMetricName("Custom","Oracle","FMWServer","WebServiceProcessor",getClass().getSimpleName(),"executeInterceptorRequestChain");
		return Weaver.callOriginal();
	}

	@Trace
	protected void executeInterceptorResponseChain(ProcessorContext var1) {
		NewRelic.getAgent().getTracedMethod().setMetricName("Custom","Oracle","FMWServer","WebServiceProcessor",getClass().getSimpleName(),"executeInterceptorResponseChain");
		Weaver.callOriginal();
	}

	@Trace
	protected void executeFaultInterceptorChain(ProcessorContext var1) {
		NewRelic.getAgent().getTracedMethod().setMetricName("Custom","Oracle","FMWServer","WebServiceProcessor",getClass().getSimpleName(),"executeFaultInterceptorChain");
		Weaver.callOriginal();
	}

	@Trace
	protected boolean executeWSDLPreProcessingChain(Map<String, Object> var1) {
		NewRelic.getAgent().getTracedMethod().setMetricName("Custom","Oracle","FMWServer","WebServiceProcessor",getClass().getSimpleName(),"executeWSDLPreProcessingChain");
		return Weaver.callOriginal();
	}
	
	@Trace
	protected SOAPMessage doEndpointProcessing(Object var1, ProcessorContext var2) {
		NewRelic.getAgent().getTracedMethod().setMetricName("Custom","Oracle","FMWServer","WebServiceProcessor",getClass().getSimpleName(),"doEndpointProcessing");
		return Weaver.callOriginal();
	}

	@Trace
	protected void executeWSDLPostProcessingChain(Map<String, Object> var1) {
		NewRelic.getAgent().getTracedMethod().setMetricName("Custom","Oracle","FMWServer","WebServiceProcessor",getClass().getSimpleName(),"executeWSDLPostProcessingChain");
		Weaver.callOriginal();
	}

}
