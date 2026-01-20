package oracle.as.scheduler.adapter;

import com.newrelic.api.agent.NewRelic;
import com.newrelic.api.agent.TracedMethod;
import com.newrelic.api.agent.weaver.Weave;
import com.newrelic.api.agent.weaver.Weaver;
import oracle.as.scheduler.core.UserInfo;

@Weave(originalName = "oracle.as.scheduler.adapter.CommandExecutor")
public class CommandExecutor_Instrumentation {

    public CommandExecutor_Instrumentation.CmdExecResult_Instrumentation executeCommand(Command cmd, UserInfo userInfo, boolean isRaContext) {
        TracedMethod tracer = NewRelic.getAgent().getTracedMethod();
        tracer.setMetricName("Custom","CommandExecutor","executeCommand");
        tracer.addCustomAttribute("Command-AppName",cmd.getAppName());
        tracer.addCustomAttribute("Command-JobName",cmd.getJobName());
        tracer.addCustomAttribute("Command-JobPkg",cmd.getJobPkg());
        tracer.addCustomAttribute("Command-RequestId",cmd.getRequestId());

        return Weaver.callOriginal();
    }

    @Weave(originalName = "oracle.as.scheduler.adapter.CommandExecutor$CmdExecResult")
    public static class CmdExecResult_Instrumentation {

    }
}
