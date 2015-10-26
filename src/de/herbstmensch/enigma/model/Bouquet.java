package de.herbstmensch.enigma.model;

import java.util.ArrayList;
import java.util.List;

import com.thoughtworks.xstream.annotations.XStreamAlias;

@XStreamAlias("e2bouquet")
public class Bouquet {

	@XStreamAlias("e2servicename")
	private String name;
	@XStreamAlias("e2servicereference")
	private String servicereference;
	@XStreamAlias("e2servicelist")
	List<Service> services = new ArrayList<Service>();

	public String getName() {
		return name;
	}

	public String getServicereference() {
		return servicereference;
	}

	public List<Service> getServices() {
		return services;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setServicereference(String servicereference) {
		this.servicereference = servicereference;
	}

	public void setServices(List<Service> services) {
		this.services = services;
	}

	@Override
	public String toString() {
		return "Bouquet [servicereference=" + servicereference + ", name=" + name + ", services=" + services + "]";
	}

	

}
