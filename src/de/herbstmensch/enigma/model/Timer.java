package de.herbstmensch.enigma.model;

import com.thoughtworks.xstream.annotations.XStreamAlias;

@XStreamAlias("e2timer")
public class Timer {

	@XStreamAlias("e2servicereference")
	private String servicereference;

	@XStreamAlias("e2servicename")
	private String servicename;

	@XStreamAlias("e2eit")
	private String eit;

	@XStreamAlias("e2name")
	private String name;

	@XStreamAlias("e2description")
	private String description;

	@XStreamAlias("e2descriptionextended")
	private String descriptionextended;

	@XStreamAlias("e2disabled")
	private String disabled;

	@XStreamAlias("e2timebegin")
	private String timebegin;

	@XStreamAlias("e2timeend")
	private String timeend;

	@XStreamAlias("e2duration")
	private String duration;

	@XStreamAlias("e2startprepare")
	private String startprepare;

	@XStreamAlias("e2justplay")
	private String justplay;

	@XStreamAlias("e2afterevent")
	private String afterevent;

	@XStreamAlias("e2e2location")
	private String location;

	@XStreamAlias("e2tags")
	private String tags;

	@XStreamAlias("e2logentries")
	private String logentries;

	@XStreamAlias("e2filename")
	private String filename;

	@XStreamAlias("e2backoff")
	private String backoff;

	@XStreamAlias("e2nextactivation")
	private String nextactivation;

	@XStreamAlias("e2firsttryprepare")
	private String firsttryprepare;

	@XStreamAlias("e2state")
	private String state;

	@XStreamAlias("e2repeated")
	private String repeated;

	@XStreamAlias("e2dontsave")
	private String dontsave;

	@XStreamAlias("e2cancled")
	private String cancled;

	@XStreamAlias("e2toggledisabled")
	private String toggledisabled;

	@XStreamAlias("e2toggledisabledimg")
	private String toggledisabledimg;

	public String getServicereference() {
		return servicereference;
	}

	public void setServicereference(String servicereference) {
		this.servicereference = servicereference;
	}

	public String getServicename() {
		return servicename;
	}

	public void setServicename(String servicename) {
		this.servicename = servicename;
	}

	public String getEit() {
		return eit;
	}

	public void setEit(String eit) {
		this.eit = eit;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getDescriptionextended() {
		return descriptionextended;
	}

	public void setDescriptionextended(String descriptionextended) {
		this.descriptionextended = descriptionextended;
	}

	public String getDisabled() {
		return disabled;
	}

	public void setDisabled(String disabled) {
		this.disabled = disabled;
	}

	public String getTimebegin() {
		return timebegin;
	}

	public void setTimebegin(String timebegin) {
		this.timebegin = timebegin;
	}

	public String getTimeend() {
		return timeend;
	}

	public void setTimeend(String timeend) {
		this.timeend = timeend;
	}

	public String getDuration() {
		return duration;
	}

	public void setDuration(String duration) {
		this.duration = duration;
	}

	public String getStartprepare() {
		return startprepare;
	}

	public void setStartprepare(String startprepare) {
		this.startprepare = startprepare;
	}

	public String getJustplay() {
		return justplay;
	}

	public void setJustplay(String justplay) {
		this.justplay = justplay;
	}

	public String getAfterevent() {
		return afterevent;
	}

	public void setAfterevent(String afterevent) {
		this.afterevent = afterevent;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public String getTags() {
		return tags;
	}

	public void setTags(String tags) {
		this.tags = tags;
	}

	public String getLogentries() {
		return logentries;
	}

	public void setLogentries(String logentries) {
		this.logentries = logentries;
	}

	public String getFilename() {
		return filename;
	}

	public void setFilename(String filename) {
		this.filename = filename;
	}

	public String getBackoff() {
		return backoff;
	}

	public void setBackoff(String backoff) {
		this.backoff = backoff;
	}

	public String getNextactivation() {
		return nextactivation;
	}

	public void setNextactivation(String nextactivation) {
		this.nextactivation = nextactivation;
	}

	public String getFirsttryprepare() {
		return firsttryprepare;
	}

	public void setFirsttryprepare(String firsttryprepare) {
		this.firsttryprepare = firsttryprepare;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getRepeated() {
		return repeated;
	}

	public void setRepeated(String repeated) {
		this.repeated = repeated;
	}

	public String getDontsave() {
		return dontsave;
	}

	public void setDontsave(String dontsave) {
		this.dontsave = dontsave;
	}

	public String getCancled() {
		return cancled;
	}

	public void setCancled(String cancled) {
		this.cancled = cancled;
	}

	public String getToggledisabled() {
		return toggledisabled;
	}

	public void setToggledisabled(String toggledisabled) {
		this.toggledisabled = toggledisabled;
	}

	public String getToggledisabledimg() {
		return toggledisabledimg;
	}

	public void setToggledisabledimg(String toggledisabledimg) {
		this.toggledisabledimg = toggledisabledimg;
	}

	@Override
	public String toString() {
		return "Timer [servicereference=" + servicereference + ", servicename=" + servicename + ", eit=" + eit
				+ ", name=" + name + ", description=" + description + ", descriptionextended=" + descriptionextended
				+ ", disabled=" + disabled + ", timebegin=" + timebegin + ", timeend=" + timeend + ", duration="
				+ duration + ", startprepare=" + startprepare + ", justplay=" + justplay + ", afterevent=" + afterevent
				+ ", location=" + location + ", tags=" + tags + ", logentries=" + logentries + ", filename=" + filename
				+ ", backoff=" + backoff + ", nextactivation=" + nextactivation + ", firsttryprepare=" + firsttryprepare
				+ ", state=" + state + ", repeated=" + repeated + ", dontsave=" + dontsave + ", cancled=" + cancled
				+ ", toggledisabled=" + toggledisabled + ", toggledisabledimg=" + toggledisabledimg + "]";
	}

}
