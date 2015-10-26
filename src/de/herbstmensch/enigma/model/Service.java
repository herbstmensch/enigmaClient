
package de.herbstmensch.enigma.model;

import com.thoughtworks.xstream.annotations.XStreamAlias;

@XStreamAlias("e2service")
public class Service {

	@XStreamAlias("e2servicename")
	String servicename;
	@XStreamAlias("e2servicereference")
	String servicereference;
	
	public Service() {
	}

	public Service(String servicereference, String servicename) {
		super();
		this.servicereference = servicereference;
		this.servicename = servicename;
	}

	public String getServicename() {
		return servicename;
	}

	public String getServicereference() {
		return servicereference;
	}

	public void setServicename(String servicename) {
		this.servicename = servicename;
	}

	public void setServicereference(String servicereference) {
		this.servicereference = servicereference;
	}

	@Override
	public String toString() {
		return "Service [servicereference=" + servicereference + ", servicename=" + servicename + "]";
	}

	
	
	

}