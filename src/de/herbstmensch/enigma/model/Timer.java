
package de.herbstmensch.enigma.model;

import com.thoughtworks.xstream.annotations.XStreamAlias;

@XStreamAlias("e2timer")
public class Timer {

	@XStreamAlias("e2afterevent")
	private Integer afterevent;

	@XStreamAlias("e2backoff")
	private Integer backoff;

	@XStreamAlias("e2cancled")
	private String cancled;

	@XStreamAlias("e2description")
	private String description;

	@XStreamAlias("e2descriptionextended")
	private String descriptionextended;

	@XStreamAlias("e2disabled")
	private Integer disabled;

	@XStreamAlias("e2dontsave")
	private Integer dontsave;

	@XStreamAlias("e2duration")
	private String duration;

	@XStreamAlias("e2eit")
	private String eit;

	@XStreamAlias("e2filename")
	private String filename;

	@XStreamAlias("e2firsttryprepare")
	private String firsttryprepare;

	@XStreamAlias("e2justplay")
	private Integer justplay;

	@XStreamAlias("e2e2location")
	private String location;

	@XStreamAlias("e2logentries")
	private String logentries;

	@XStreamAlias("e2name")
	private String name;

	@XStreamAlias("e2nextactivation")
	private String nextactivation;

	@XStreamAlias("e2repeated")
	private Integer repeated;

	@XStreamAlias("e2servicename")
	private String servicename;

	@XStreamAlias("e2servicereference")
	private String servicereference;

	@XStreamAlias("e2startprepare")
	private EnigmaTimestamp startprepare;

	@XStreamAlias("e2state")
	private Integer state;

	@XStreamAlias("e2tags")
	private String tags;

	@XStreamAlias("e2timebegin")
	private EnigmaTimestamp timebegin;

	@XStreamAlias("e2timeend")
	private EnigmaTimestamp timeend;

	@XStreamAlias("e2toggledisabled")
	private String toggledisabled;

	@XStreamAlias("e2toggledisabledimg")
	private String toggledisabledimg;

	public Integer getAfterevent() {
		return afterevent;
	}

	public Integer getBackoff() {
		return backoff;
	}

	public String getCancled() {
		return cancled;
	}

	public String getDescription() {
		return description;
	}
	
	public String getDescriptionextended() {
		return descriptionextended;
	}

	public Integer getDisabled() {
		return disabled;
	}

	public Integer getDontsave() {
		return dontsave;
	}

	public String getDuration() {
		return duration;
	}

	public String getEit() {
		return eit;
	}

	public String getFilename() {
		return filename;
	}

	public String getFirsttryprepare() {
		return firsttryprepare;
	}

	public Integer getJustplay() {
		return justplay;
	}

	public String getLocation() {
		return location;
	}

	public String getLogentries() {
		return logentries;
	}

	public String getName() {
		return name;
	}

	public String getNextactivation() {
		return nextactivation;
	}

	public Integer getRepeated() {
		return repeated;
	}

	public Service getService(){
		return new Service(servicereference, servicename);
	}

	public String getServicename() {
		return servicename;
	}

	public String getServicereference() {
		return servicereference;
	}

	public EnigmaTimestamp getStartprepare() {
		return startprepare;
	}

	public Integer getState() {
		return state;
	}

	public String getTags() {
		return tags;
	}

	public EnigmaTimestamp getTimebegin() {
		return timebegin;
	}

	public EnigmaTimestamp getTimeend() {
		return timeend;
	}

	public String getToggledisabled() {
		return toggledisabled;
	}

	public String getToggledisabledimg() {
		return toggledisabledimg;
	}

	public void setAfterevent(Integer afterevent) {
		this.afterevent = afterevent;
	}

	public void setBackoff(Integer backoff) {
		this.backoff = backoff;
	}

	public void setCancled(String cancled) {
		this.cancled = cancled;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public void setDescriptionextended(String descriptionextended) {
		this.descriptionextended = descriptionextended;
	}

	public void setDisabled(Integer disabled) {
		this.disabled = disabled;
	}

	public void setDontsave(Integer dontsave) {
		this.dontsave = dontsave;
	}

	public void setDuration(String duration) {
		this.duration = duration;
	}

	public void setEit(String eit) {
		this.eit = eit;
	}

	public void setFilename(String filename) {
		this.filename = filename;
	}

	public void setFirsttryprepare(String firsttryprepare) {
		this.firsttryprepare = firsttryprepare;
	}

	public void setJustplay(Integer justplay) {
		this.justplay = justplay;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public void setLogentries(String logentries) {
		this.logentries = logentries;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setNextactivation(String nextactivation) {
		this.nextactivation = nextactivation;
	}

	public void setRepeated(Integer repeated) {
		this.repeated = repeated;
	}

	public void setServicename(String servicename) {
		this.servicename = servicename;
	}

	public void setServicereference(String servicereference) {
		this.servicereference = servicereference;
	}

	public void setStartprepare(EnigmaTimestamp startprepare) {
		this.startprepare = startprepare;
	}

	public void setState(Integer state) {
		this.state = state;
	}

	public void setTags(String tags) {
		this.tags = tags;
	}

	public void setTimebegin(EnigmaTimestamp timebegin) {
		this.timebegin = timebegin;
	}

	public void setTimeend(EnigmaTimestamp timeend) {
		this.timeend = timeend;
	}

	public void setToggledisabled(String toggledisabled) {
		this.toggledisabled = toggledisabled;
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