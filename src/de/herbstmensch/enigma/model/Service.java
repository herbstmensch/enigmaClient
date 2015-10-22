package de.herbstmensch.enigma.model;

import com.thoughtworks.xstream.annotations.XStreamAlias;

@XStreamAlias("e2service")
public class Service {

	@XStreamAlias("e2servicereference")
	String servicereference;
	@XStreamAlias("e2servicename")
	String servicename;
	
	public Service() {
	}

	public Service(String servicereference, String servicename) {
		super();
		this.servicereference = servicereference;
		this.servicename = servicename;
	}

	public String getServicereference() {
		return servicereference;
	}

	public void setServicereference(String servicereference) {
		this.servicereference = servicereference;
	}

	public String getServicename() {
		return servicename;
	}

	public void setServicename(String servicename) {
		this.servicename = servicename;
	}

	@Override
	public String toString() {
		return "Service [servicereference=" + servicereference + ", servicename=" + servicename + "]";
	}

	
	
	

}
