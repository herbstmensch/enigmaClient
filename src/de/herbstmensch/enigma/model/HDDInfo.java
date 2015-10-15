package de.herbstmensch.enigma.model;

import com.thoughtworks.xstream.annotations.XStreamAlias;

@XStreamAlias("e2hddinfo")
public class HDDInfo {

	@XStreamAlias("e2model")
	private String model;
	@XStreamAlias("e2capacity")
	private String capacity;
	@XStreamAlias("e2free")
	private String free;

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public String getCapacity() {
		return capacity;
	}

	public void setCapacity(String capacity) {
		this.capacity = capacity;
	}

	public String getFree() {
		return free;
	}

	public void setFree(String free) {
		this.free = free;
	}

	@Override
	public String toString() {
		return "HDDInfo [model=" + model + ", capacity=" + capacity + ", free=" + free + "]";
	}

}
