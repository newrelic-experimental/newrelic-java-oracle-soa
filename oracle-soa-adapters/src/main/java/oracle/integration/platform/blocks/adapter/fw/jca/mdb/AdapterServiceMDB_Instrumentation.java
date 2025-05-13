package oracle.integration.platform.blocks.adapter.fw.jca.mdb;

import com.newrelic.api.agent.Trace;
import com.newrelic.api.agent.weaver.Weave;
import com.newrelic.api.agent.weaver.Weaver;

import javax.resource.cci.Record;

@Weave(originalName = "oracle.integration.platform.blocks.adapter.fw.jca.mdb.AdapterServiceMDB")
public class AdapterServiceMDB_Instrumentation {

	@Trace(dispatcher = true)
	public Record onMessage(Record record) {
		return Weaver.callOriginal();
	}
}
