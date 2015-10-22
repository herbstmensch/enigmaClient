
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
	private Integer disabled;

	@XStreamAlias("e2timebegin")
	private EnigmaTimestamp timebegin;

	@XStreamAlias("e2timeend")
	private EnigmaTimestamp timeend;

	@XStreamAlias("e2duration")
	private String duration;

	@XStreamAlias("e2startprepare")
	private EnigmaTimestamp startprepare;

	@XStreamAlias("e2justplay")
	private Integer justplay;

	@XStreamAlias("e2afterevent")
	private Integer afterevent;

	@XStreamAlias("e2e2location")
	private String location;

	@XStreamAlias("e2tags")
	private String tags;

	@XStreamAlias("e2logentries")
	private String logentries;

	@XStreamAlias("e2filename")
	private String filename;

	@XStreamAlias("e2backoff")
	private Integer backoff;

	@XStreamAlias("e2nextactivation")
	private String nextactivation;

	@XStreamAlias("e2firsttryprepare")
	private String firsttryprepare;

	@XStreamAlias("e2state")
	private Integer state;

	@XStreamAlias("e2repeated")
	private Integer repeated;

	@XStreamAlias("e2dontsave")
	private Integer dontsave;

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
	
	public Service getService(){
		return new Service(servicereference, servicename);
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

	public Integer getDisabled() {
		return disabled;
	}

	public void setDisabled(Integer disabled) {
		this.disabled = disabled;
	}

	public EnigmaTimestamp getTimebegin() {
		return timebegin;
	}

	public void setTimebegin(EnigmaTimestamp timebegin) {
		this.timebegin = timebegin;
	}

	public EnigmaTimestamp getTimeend() {
		return timeend;
	}

	public void setTimeend(EnigmaTimestamp timeend) {
		this.timeend = timeend;
	}

	public String getDuration() {
		return duration;
	}

	public void setDuration(String duration) {
		this.duration = duration;
	}

	public EnigmaTimestamp getStartprepare() {
		return startprepare;
	}

	public void setStartprepare(EnigmaTimestamp startprepare) {
		this.startprepare = startprepare;
	}

	public Integer getJustplay() {
		return justplay;
	}

	public void setJustplay(Integer justplay) {
		this.justplay = justplay;
	}

	public Integer getAfterevent() {
		return afterevent;
	}

	public void setAfterevent(Integer afterevent) {
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

	public Integer getBackoff() {
		return backoff;
	}

	public void setBackoff(Integer backoff) {
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

	public Integer getState() {
		return state;
	}

	public void setState(Integer state) {
		this.state = state;
	}

	public Integer getRepeated() {
		return repeated;
	}

	public void setRepeated(Integer repeated) {
		this.repeated = repeated;
	}

	public Integer getDontsave() {
		return dontsave;
	}

	public void setDontsave(Integer dontsave) {
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