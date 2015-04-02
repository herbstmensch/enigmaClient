package de.herbstmensch.enigma.model;

public enum MessageType {

	INFO(0);

	private Integer value;

	private MessageType(Integer value) {
		this.value = value;
	}

	public Integer value() {
		return value;
	}

}
