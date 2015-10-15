package de.herbstmensch.enigma;

import java.net.MalformedURLException;

import de.herbstmensch.enigma.api.EnigmaAPI;
import de.herbstmensch.enigma.api.exceptions.APIException;
import de.herbstmensch.enigma.model.BouquetList;
import de.herbstmensch.enigma.model.EventList;
import de.herbstmensch.enigma.model.MessageDuration;
import de.herbstmensch.enigma.model.MessageType;
import de.herbstmensch.enigma.model.TimerList;

public class Test {

	public static void main(String[] args) throws APIException, InterruptedException, MalformedURLException {
		EnigmaAPI e = new EnigmaAPI(false, "home.timherbst.de", 82, "tim", "dcx2.0dcx2.1");
		System.out.println(e.about());
		BouquetList bl = e.getAllServices();
		System.out.println(bl);
		System.out.println(e.getServices(bl.getBouquets().get(0)));
		System.out.println(e.epgNext(bl.getBouquets().get(0)));
		System.out.println(e.message("Test", MessageType.INFO, MessageDuration.LONG));
		EventList el = e.epgNext(bl.getBouquets().get(0));
		System.out.println(el);
		System.out.println(e.timerAdd(el.getEvents().get(0), true, "/hdd/movie"));
		TimerList tl = e.getTimerlist();
		System.out.println(tl);
		System.out.println(tl.getTimers().get(0));
	}

}
