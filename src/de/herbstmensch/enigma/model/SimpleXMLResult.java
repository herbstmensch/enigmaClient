
package de.herbstmensch.enigma.model;

import com.thoughtworks.xstream.annotations.XStreamAlias;

@XStreamAlias("e2simplexmlresult")
public class SimpleXMLResult {

	@XStreamAlias("e2state")
	private String state;

	@XStreamAlias("e2statetext")
	private String statetext;

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getStatetext() {
		return statetext;
	}

	public void setStatetext(String statetext) {
		this.statetext = statetext;
	}

	@Override
	public String toString() {
		return "SimpleXMLResult [state=" + state + ", statetext=" + statetext + "]";
	}

}