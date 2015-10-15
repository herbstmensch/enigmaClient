package de.herbstmensch.enigma;

import java.net.MalformedURLException;

import de.herbstmensch.enigma.api.EnigmaAPI;
import de.herbstmensch.enigma.api.exceptions.APIException;
import de.herbstmensch.enigma.model.BouquetList;
import de.herbstmensch.enigma.model.MessageDuration;
import de.herbstmensch.enigma.model.MessageType;

public class Test {

	public static void main(String[] args) throws APIException, InterruptedException, MalformedURLException {
		EnigmaAPI e = new EnigmaAPI(false, "home.timherbst.de", 82, "tim", "dcx2.0dcx2.1");
		System.out.println(e.about());
		BouquetList bl = e.getAllServices();
		System.out.println(bl);
		System.out.println(e.getServices(bl.getBouquets().get(0)));
		System.out.println(e.epgNext(bl.getBouquets().get(0)));
		System.out.println(e.message("Test", MessageType.INFO, MessageDuration.LONG));
		//System.out.println(e.getTimerlist());
		

		//System.out.println(e.getTimerlist());
	}

}