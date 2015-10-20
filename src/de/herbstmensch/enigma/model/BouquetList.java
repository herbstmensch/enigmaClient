package de.herbstmensch.enigma.model;

import java.util.List;

import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.thoughtworks.xstream.annotations.XStreamImplicit;

@XStreamAlias("e2servicelistrecursive")
public class BouquetList {

	@XStreamImplicit(itemFieldName = "e2bouquet")
	private List<Bouquet> bouquets;

	public List<Bouquet> getBouquets() {
		return bouquets;
	}

	public void setBouquets(List<Bouquet> bouquets) {
		this.bouquets = bouquets;
	}

	@Override
	public String toString() {
		return "BouquetList [bouquets=" + bouquets + "]";
	}

}
