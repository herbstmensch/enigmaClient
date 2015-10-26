package de.herbstmensch.enigma.model;

import com.thoughtworks.xstream.annotations.XStreamAlias;

@XStreamAlias("e2movie")
public class Movie {

	@XStreamAlias("e2description")
	private String description;

	@XStreamAlias("e2descriptionextended")
	private String descriptionextended;

	@XStreamAlias("e2filename")
	private String filename;

	@XStreamAlias("e2filesize")
	private long filesize;

	@XStreamAlias("e2length")
	private String length;
	
	@XStreamAlias("e2servicename")
	private String servicename;
	
	@XStreamAlias("e2servicereference")
	private String servicereference;
	
	@XStreamAlias("e2time")
	private EnigmaTimestamp time;
	
	@XStreamAlias("e2title")
	private String title;

	public String getDescription() {
		return description;
	}

	public String getDescriptionextended() {
		return descriptionextended;
	}

	public String getFilename() {
		return filename;
	}

	public long getFilesize() {
		return filesize;
	}

	public String getLength() {
		return length;
	}

	public String getServicename() {
		return servicename;
	}

	public String getServicereference() {
		return servicereference;
	}

	public EnigmaTimestamp getTime() {
		return time;
	}

	public String getTitle() {
		return title;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public void setDescriptionextended(String descriptionextended) {
		this.descriptionextended = descriptionextended;
	}

	public void setFilename(String filename) {
		this.filename = filename;
	}

	public void setFilesize(long filesize) {
		this.filesize = filesize;
	}

	public void setLength(String length) {
		this.length = length;
	}

	public void setServicename(String servicename) {
		this.servicename = servicename;
	}

	public void setServicereference(String servicereference) {
		this.servicereference = servicereference;
	}

	public void setTime(EnigmaTimestamp time) {
		this.time = time;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	@Override
	public String toString() {
		return "Movie [title=" + title + ", description=" + description + ", descriptionextended=" + descriptionextended
				+ ", servicereference=" + servicereference + ", servicename=" + servicename + ", time=" + time
				+ ", length=" + length + ", filename=" + filename + ", filesize=" + filesize + "]";
	}

	
}
