package de.herbstmensch.enigma.model;

import java.util.List;

import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.thoughtworks.xstream.annotations.XStreamImplicit;

@XStreamAlias("e2timerlist")
public class TimerList {
	
	@XStreamImplicit(itemFieldName="e2timer")
	private List<Timer> timers;

	public List<Timer> getTimers() {
		return timers;
	}

	public void setTimers(List<Timer> timers) {
		this.timers = timers;
	}

	@Override
	public String toString() {
		return "TimerList [timers=" + timers + "]";
	}

}
