package de.herbstmensch.enigma.model;

public enum MessageDuration {
	
	LONG(60),MEDIUM(10),SHORT(5);
	
	private Integer value;
	
	private MessageDuration(Integer value) {
		this.value = value;
	}
	
	public Integer value(){
		return value;
	}

}
