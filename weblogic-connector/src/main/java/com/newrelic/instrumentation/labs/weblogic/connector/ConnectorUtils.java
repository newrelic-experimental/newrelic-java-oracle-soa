package com.newrelic.instrumentation.labs.weblogic.connector;

import javax.resource.spi.work.Work;

public class ConnectorUtils {

	public static NRWorkWrapper getWrapper(Work work) {
		if (work != null) {
			if (work instanceof NRWorkWrapper) {
				return (NRWorkWrapper) work;
			} 
			
			return new NRWorkWrapper(work);
		}
		return null;
	}
}
