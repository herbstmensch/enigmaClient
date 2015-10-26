package de.herbstmensch.enigma.model;

import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.thoughtworks.xstream.annotations.XStreamConverter;

import de.herbstmensch.enigma.MayBeNoneConverter;

@XStreamAlias("e2event")
public class Event {

	@XStreamAlias("e2eventcurrenttime")
	private EnigmaTimestamp currenttime;

	@XStreamAlias("e2eventdescription")
	private String description;

	@XStreamAlias("e2eventdescriptionextended")
	private String descriptionextended;

	@XStreamAlias("e2eventduration")
	@XStreamConverter(MayBeNoneConverter.class)
	private Integer duration;

	@XStreamAlias("e2eventid")
	@XStreamConverter(MayBeNoneConverter.class)
	private Integer id;

	@XStreamAlias("e2eventservicename")
	private String servicename;

	@XStreamAlias("e2eventservicereference")
	private String servicereference;

	@XStreamAlias("e2eventstart")
	private EnigmaTimestamp start;

	@XStreamAlias("e2eventtitle")
	private String title;

	public EnigmaTimestamp getCurrenttime() {
		return currenttime;
	}

	public String getDescription() {
		return description;
	}

	public String getDescriptionextended() {
		return descriptionextended;
	}

	public Integer getDuration() {
		return duration;
	}

	public Integer getId() {
		return id;
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

	public EnigmaTimestamp getStart() {
		return start;
	}

	public String getTitle() {
		return title;
	}

	public void setCurrenttime(EnigmaTimestamp currenttime) {
		this.currenttime = currenttime;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public void setDescriptionextended(String descriptionextended) {
		this.descriptionextended = descriptionextended;
	}

	public void setDuration(Integer duration) {
		this.duration = duration;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public void setServicename(String servicename) {
		this.servicename = servicename;
	}

	public void setServicereference(String servicereference) {
		this.servicereference = servicereference;
	}

	public void setStart(EnigmaTimestamp start) {
		this.start = start;
	}
	
	public void setTitle(String title) {
		this.title = title;
	}

	@Override
	public String toString() {
		return "Event [id=" + id + ", start=" + start + ", duration=" + duration + ", currenttime=" + currenttime
				+ ", title=" + title + ", description=" + description + ", descriptionextended=" + descriptionextended
				+ ", servicereference=" + servicereference + ", servicename=" + servicename + "]";
	}

	
}
