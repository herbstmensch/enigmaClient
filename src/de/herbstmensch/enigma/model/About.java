package de.herbstmensch.enigma.model;

import java.util.ArrayList;
import java.util.List;

public class About {

	private String enigmaversion;
	private String imageversion;
	private String webifversion;
	private String fpversion;
	private String model;
	private List<LANInfo> lanInfos = new ArrayList<LANInfo>();
	private List<HDDInfo> hddInfos = new ArrayList<HDDInfo>();
	private List<TunerInfo> tunerinfos = new ArrayList<TunerInfo>();
	private String servicename;
	private String servicenamespace;
	private String serviceaspect;
	private String serviceprovider;
	private String videowidth;
	private String videoheight;
	private String servicevideosize;
	private String apid;
	private String vpid;
	private String pcrpid;
	private String pmtpid;
	private String txtpid;
	private String tsid;
	private String onid;
	private String sid;

	public String getEnigmaversion() {
		return enigmaversion;
	}

	public void setEnigmaversion(String enigmaversion) {
		this.enigmaversion = enigmaversion;
	}

	public String getImageversion() {
		return imageversion;
	}

	public void setImageversion(String imageversion) {
		this.imageversion = imageversion;
	}

	public String getWebifversion() {
		return webifversion;
	}

	public void setWebifversion(String webifversion) {
		this.webifversion = webifversion;
	}

	public String getFpversion() {
		return fpversion;
	}

	public void setFpversion(String fpversion) {
		this.fpversion = fpversion;
	}

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public List<LANInfo> getLanInfos() {
		return lanInfos;
	}

	public void setLanInfos(List<LANInfo> lanInfos) {
		this.lanInfos = lanInfos;
	}

	public List<HDDInfo> getHddInfos() {
		return hddInfos;
	}

	public void setHddInfos(List<HDDInfo> hddInfos) {
		this.hddInfos = hddInfos;
	}

	public List<TunerInfo> getTunerinfos() {
		return tunerinfos;
	}

	public void setTunerinfos(List<TunerInfo> tunerinfos) {
		this.tunerinfos = tunerinfos;
	}

	public String getServicename() {
		return servicename;
	}

	public void setServicename(String servicename) {
		this.servicename = servicename;
	}

	public String getServicenamespace() {
		return servicenamespace;
	}

	public void setServicenamespace(String servicenamespace) {
		this.servicenamespace = servicenamespace;
	}

	public String getServiceaspect() {
		return serviceaspect;
	}

	public void setServiceaspect(String serviceaspect) {
		this.serviceaspect = serviceaspect;
	}

	public String getServiceprovider() {
		return serviceprovider;
	}

	public void setServiceprovider(String serviceprovider) {
		this.serviceprovider = serviceprovider;
	}

	public String getVideowidth() {
		return videowidth;
	}

	public void setVideowidth(String videowidth) {
		this.videowidth = videowidth;
	}

	public String getVideoheight() {
		return videoheight;
	}

	public void setVideoheight(String videoheight) {
		this.videoheight = videoheight;
	}

	public String getServicevideosize() {
		return servicevideosize;
	}

	public void setServicevideosize(String servicevideosize) {
		this.servicevideosize = servicevideosize;
	}

	public String getApid() {
		return apid;
	}

	public void setApid(String apid) {
		this.apid = apid;
	}

	public String getVpid() {
		return vpid;
	}

	public void setVpid(String vpid) {
		this.vpid = vpid;
	}

	public String getPcrpid() {
		return pcrpid;
	}

	public void setPcrpid(String pcrpid) {
		this.pcrpid = pcrpid;
	}

	public String getPmtpid() {
		return pmtpid;
	}

	public void setPmtpid(String pmtpid) {
		this.pmtpid = pmtpid;
	}

	public String getTxtpid() {
		return txtpid;
	}

	public void setTxtpid(String txtpid) {
		this.txtpid = txtpid;
	}

	public String getTsid() {
		return tsid;
	}

	public void setTsid(String tsid) {
		this.tsid = tsid;
	}

	public String getOnid() {
		return onid;
	}

	public void setOnid(String onid) {
		this.onid = onid;
	}

	public String getSid() {
		return sid;
	}

	public void setSid(String sid) {
		this.sid = sid;
	}

}
