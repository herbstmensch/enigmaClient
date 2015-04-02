package de.herbstmensch.enigma.model;

import java.text.MessageFormat;

public class SimpleXMLResult {

	String state;
	String text;

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}
	
	@Override
	public String toString() {
		return MessageFormat.format("'{'\n\tState: ''{0}'',\n\tText: ''{1}''\n'}'", getState(), getText());
	}

}
