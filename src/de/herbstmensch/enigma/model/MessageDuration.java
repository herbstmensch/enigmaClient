package de.herbstmensch.enigma.model;

public class MessageDuration {
	
	public static final MessageDuration SHORT = new MessageDuration(5);
	public static final MessageDuration MEDIUM = new MessageDuration(10);
	public static final MessageDuration LONG = new MessageDuration(60);
	
	private Integer value;
	
	public MessageDuration(Integer value) {
		this.value = value;
	}
	
	public Integer value(){
		return value;
	}

}
