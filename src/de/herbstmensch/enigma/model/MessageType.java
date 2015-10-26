package de.herbstmensch.enigma.model;

public enum MessageType {

	ATTENTION(3), INFO(1), MESSAGE(2), QUESTION(0);

	private Integer value;

	private MessageType(Integer value) {
		this.value = value;
	}

	public Integer value() {
		return value;
	}

}
