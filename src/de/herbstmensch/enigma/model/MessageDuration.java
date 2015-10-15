package de.herbstmensch.enigma.model;

public enum MessageDuration {
	
	SHORT(5),MEDIUM(10),LONG(60);
	
	private Integer value;
	
	private MessageDuration(Integer value) {
		this.value = value;
	}
	
	public Integer value(){
		return value;
	}

}
