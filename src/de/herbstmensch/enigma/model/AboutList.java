package de.herbstmensch.enigma.model;

import java.util.List;

import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.thoughtworks.xstream.annotations.XStreamImplicit;

@XStreamAlias("e2abouts")
public class AboutList {

	@XStreamImplicit(itemFieldName="e2about")
	private List<About> abouts;

	public List<About> getAbouts() {
		return abouts;
	}

	public void setAbouts(List<About> abouts) {
		this.abouts = abouts;
	}

	@Override
	public String toString() {
		return "AboutList [abouts=" + abouts + "]";
	}

	
}
