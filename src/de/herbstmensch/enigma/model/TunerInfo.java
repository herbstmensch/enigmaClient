package de.herbstmensch.enigma.model;

import com.thoughtworks.xstream.annotations.XStreamAlias;

@XStreamAlias("e2nim")
public class TunerInfo {

	@XStreamAlias("e2name")
	private String name;
	@XStreamAlias("e2type")
	private String type;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	@Override
	public String toString() {
		return "TunerInfo [name=" + name + ", type=" + type + "]";
	}

}
