package de.herbstmensch.enigma.model;

import java.util.List;

import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.thoughtworks.xstream.annotations.XStreamImplicit;

@XStreamAlias("e2eventlist")
public class EventList {

	@XStreamImplicit(itemFieldName = "e2event")
	private List<Event> events;

	public List<Event> getEvents() {
		return events;
	}

	public void setEvents(List<Event> events) {
		this.events = events;
	}

	@Override
	public String toString() {
		return "EventList [events=" + events + "]";
	}

}
