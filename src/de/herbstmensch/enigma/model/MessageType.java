package de.herbstmensch.enigma.model;

public enum MessageType {

	QUESTION(0), INFO(1), MESSAGE(2), ATTENTION(3);

	private Integer value;

	private MessageType(Integer value) {
		this.value = value;
	}

	public Integer value() {
		return value;
	}

}
