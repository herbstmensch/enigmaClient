package de.herbstmensch.enigma.model;

import java.util.List;

import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.thoughtworks.xstream.annotations.XStreamImplicit;

@XStreamAlias("e2servicelist")
public class ServiceList {

	@XStreamImplicit(itemFieldName = "e2service")
	private List<Service> services;

	public List<Service> getServices() {
		return services;
	}

	public void setServices(List<Service> services) {
		this.services = services;
	}

	@Override
	public String toString() {
		return "ServiceList [services=" + services + "]";
	}

	

}
