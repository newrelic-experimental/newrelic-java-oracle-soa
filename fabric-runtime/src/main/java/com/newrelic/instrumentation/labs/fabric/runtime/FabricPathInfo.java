package com.newrelic.instrumentation.labs.fabric.runtime;

public class FabricPathInfo {

	private String dn;
	private String serviceName;
	
	public FabricPathInfo(String dn, String serviceName) {
		super();
		this.dn = dn;
		this.serviceName = serviceName;
	}

	public String getDn() {
		return dn;
	}

	public String getServiceName() {
		return serviceName;
	}
	
	
}
