package de.herbstmensch.enigma.model;

import com.thoughtworks.xstream.annotations.XStreamAlias;

@XStreamAlias("e2event")
public class Event {

	@XStreamAlias("e2eventid")
	private String id;

	@XStreamAlias("e2eventstart")
	private String start;

	@XStreamAlias("e2eventduration")
	private String duration;

	@XStreamAlias("e2eventcurrenttime")
	private String currenttime;

	@XStreamAlias("e2eventtitle")
	private String title;

	@XStreamAlias("e2eventdescription")
	private String description;

	@XStreamAlias("e2eventdescriptionextended")
	private String descriptionextended;

	@XStreamAlias("e2eventservicereference")
	private String servicereference;

	@XStreamAlias("e2eventservicename")
	private String servicename;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getStart() {
		return start;
	}

	public void setStart(String start) {
		this.start = start;
	}

	public String getDuration() {
		return duration;
	}

	public void setDuration(String duration) {
		this.duration = duration;
	}

	public String getCurrenttime() {
		return currenttime;
	}

	public void setCurrenttime(String currenttime) {
		this.currenttime = currenttime;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
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

	@Override
	public String toString() {
		return "Event [id=" + id + ", start=" + start + ", duration=" + duration + ", currenttime=" + currenttime
				+ ", title=" + title + ", description=" + description + ", descriptionextended=" + descriptionextended
				+ ", servicereference=" + servicereference + ", servicename=" + servicename + "]";
	}

	
}
