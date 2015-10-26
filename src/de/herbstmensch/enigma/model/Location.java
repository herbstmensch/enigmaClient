package de.herbstmensch.enigma.model;

import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.thoughtworks.xstream.annotations.XStreamConverter;
import com.thoughtworks.xstream.converters.extended.ToAttributedValueConverter;

@XStreamAlias("e2location")
@XStreamConverter(value=ToAttributedValueConverter.class, strings={"location"})
public class Location {

	@XStreamAlias("e2location")
	String location;

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	@Override
	public String toString() {
		return "Location [location=" + location + "]";
	}
	
	

}
