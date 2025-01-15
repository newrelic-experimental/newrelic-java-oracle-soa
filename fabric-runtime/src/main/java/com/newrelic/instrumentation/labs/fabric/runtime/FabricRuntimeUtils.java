package com.newrelic.instrumentation.labs.fabric.runtime;

import oracle.integration.platform.blocks.PathInfo;
import oracle.integration.platform.blocks.soap.WebServiceEntryBindingComponent;

public class FabricRuntimeUtils {

	
	public static FabricPathInfo getServiceName(String pathInfo, WebServiceEntryBindingComponent wsEntryBC) {
		if(pathInfo == null || pathInfo.isEmpty()) return null;
		
		String temp = pathInfo.startsWith("/") ? pathInfo.substring(1) : pathInfo;
		String[] path = temp.split("/");
		if(path.length == 0) return null;
		
		if(path.length == 1) {
			PathInfo info = wsEntryBC.getCustomPath(pathInfo);
			if(info != null) {
				return new FabricPathInfo(info.getCompositeName(), info.getService());
			}
		} else {
			String dn = path[0] + '/' + path[1];
			String serviceName = path.length == 3 ? path[2] : null;
			return new FabricPathInfo(dn, serviceName);
		}
		
		
		
		return null;
	}

}
