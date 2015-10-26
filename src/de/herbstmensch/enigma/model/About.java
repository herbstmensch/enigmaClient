package de.herbstmensch.enigma.model;

import java.util.ArrayList;
import java.util.List;

import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.thoughtworks.xstream.annotations.XStreamImplicit;

/**
 * @author tim
 *
 */
@XStreamAlias("e2about")
public class About {

	@XStreamAlias("e2apid")
	private String apid;

	@XStreamAlias("e2distroversion")
	private String distroversion;

	@XStreamAlias("e2driverdate")
	private String driverdate;

	@XStreamAlias("e2enigmaversion")
	private String enigmaversion;

	@XStreamAlias("e2fpversion")
	private String fpversion;

	@XStreamImplicit(itemFieldName = "e2hddinfo")
	private List<HDDInfo> hddinfos = new ArrayList<HDDInfo>();

	@XStreamAlias("e2imageversion")
	private String imageversion;

	@XStreamAlias("e2landhcp")
	private String landhcp;

	@XStreamAlias("e2langw")
	private String langw;

	@XStreamAlias("e2lanip")
	private String lanip;

	@XStreamAlias("e2lanmac")
	private String lanmac;

	@XStreamAlias("e2lanmask")
	private String lanmask;

	@XStreamAlias("e2model")
	private String model;

	@XStreamAlias("e2oeversion")
	private String oeversion;

	@XStreamAlias("e2onid")
	private String onid;

	@XStreamAlias("e2pcrpid")
	private String pcrpid;

	@XStreamAlias("e2pmtpid")
	private String pmtpid;

	@XStreamAlias("e2serviceaspect")
	private String serviceaspect;

	@XStreamAlias("e2servicename")
	private String servicename;

	@XStreamAlias("e2servicenamespace")
	private String servicenamespace;

	@XStreamAlias("e2serviceprovider")
	private String serviceprovider;

	@XStreamAlias("e2servicevideosize")
	private String servicevideosize;

	@XStreamAlias("e2sid")
	private String sid;

	@XStreamAlias("e2tsid")
	private String tsid;

	@XStreamAlias("e2tunerinfo")
	private List<TunerInfo> tunerinfos = new ArrayList<TunerInfo>();

	@XStreamAlias("e2txtpid")
	private String txtpid;

	@XStreamAlias("e2videoheight")
	private String videoheight;

	@XStreamAlias("e2videowidth")
	private String videowidth;

	@XStreamAlias("e2vpid")
	private String vpid;

	@XStreamAlias("e2webifversion")
	private String webifversion;

	public String getApid() {
		return apid;
	}

	public String getDistroversion() {
		return distroversion;
	}

	public String getDriverdate() {
		return driverdate;
	}

	public String getEnigmaversion() {
		return enigmaversion;
	}

	public String getFpversion() {
		return fpversion;
	}

	public List<HDDInfo> getHddinfos() {
		return hddinfos;
	}

	public String getImageversion() {
		return imageversion;
	}

	public String getLandhcp() {
		return landhcp;
	}

	public String getLangw() {
		return langw;
	}

	public String getLanip() {
		return lanip;
	}

	public String getLanmac() {
		return lanmac;
	}

	public String getLanmask() {
		return lanmask;
	}

	public String getModel() {
		return model;
	}

	public String getOeversion() {
		return oeversion;
	}

	public String getOnid() {
		return onid;
	}

	public String getPcrpid() {
		return pcrpid;
	}

	public String getPmtpid() {
		return pmtpid;
	}

	public String getServiceaspect() {
		return serviceaspect;
	}

	public String getServicename() {
		return servicename;
	}

	public String getServicenamespace() {
		return servicenamespace;
	}

	public String getServiceprovider() {
		return serviceprovider;
	}

	public String getServicevideosize() {
		return servicevideosize;
	}

	public String getSid() {
		return sid;
	}

	public String getTsid() {
		return tsid;
	}

	public List<TunerInfo> getTunerinfos() {
		return tunerinfos;
	}

	public String getTxtpid() {
		return txtpid;
	}

	public String getVideoheight() {
		return videoheight;
	}

	public String getVideowidth() {
		return videowidth;
	}

	public String getVpid() {
		return vpid;
	}

	public String getWebifversion() {
		return webifversion;
	}

	public void setApid(String apid) {
		this.apid = apid;
	}

	public void setDistroversion(String distroversion) {
		this.distroversion = distroversion;
	}

	public void setDriverdate(String driverdate) {
		this.driverdate = driverdate;
	}

	public void setEnigmaversion(String enigmaversion) {
		this.enigmaversion = enigmaversion;
	}

	public void setFpversion(String fpversion) {
		this.fpversion = fpversion;
	}

	public void setHddinfos(List<HDDInfo> hddinfos) {
		this.hddinfos = hddinfos;
	}

	public void setImageversion(String imageversion) {
		this.imageversion = imageversion;
	}

	public void setLandhcp(String landhcp) {
		this.landhcp = landhcp;
	}

	public void setLangw(String langw) {
		this.langw = langw;
	}

	public void setLanip(String lanip) {
		this.lanip = lanip;
	}

	public void setLanmac(String lanmac) {
		this.lanmac = lanmac;
	}

	public void setLanmask(String lanmask) {
		this.lanmask = lanmask;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public void setOeversion(String oeversion) {
		this.oeversion = oeversion;
	}

	public void setOnid(String onid) {
		this.onid = onid;
	}

	public void setPcrpid(String pcrpid) {
		this.pcrpid = pcrpid;
	}

	public void setPmtpid(String pmtpid) {
		this.pmtpid = pmtpid;
	}

	public void setServiceaspect(String serviceaspect) {
		this.serviceaspect = serviceaspect;
	}

	public void setServicename(String servicename) {
		this.servicename = servicename;
	}

	public void setServicenamespace(String servicenamespace) {
		this.servicenamespace = servicenamespace;
	}

	public void setServiceprovider(String serviceprovider) {
		this.serviceprovider = serviceprovider;
	}

	public void setServicevideosize(String servicevideosize) {
		this.servicevideosize = servicevideosize;
	}

	public void setSid(String sid) {
		this.sid = sid;
	}

	public void setTsid(String tsid) {
		this.tsid = tsid;
	}

	public void setTunerinfos(List<TunerInfo> tunerinfos) {
		this.tunerinfos = tunerinfos;
	}

	public void setTxtpid(String txtpid) {
		this.txtpid = txtpid;
	}

	public void setVideoheight(String videoheight) {
		this.videoheight = videoheight;
	}

	public void setVideowidth(String videowidth) {
		this.videowidth = videowidth;
	}

	public void setVpid(String vpid) {
		this.vpid = vpid;
	}

	public void setWebifversion(String webifversion) {
		this.webifversion = webifversion;
	}

	@Override
	public String toString() {
		return "About [oeversion=" + oeversion + ", enigmaversion=" + enigmaversion + ", distroversion=" + distroversion
				+ ", imageversion=" + imageversion + ", driverdate=" + driverdate + ", webifversion=" + webifversion
				+ ", fpversion=" + fpversion + ", model=" + model + ", lanmac=" + lanmac + ", landhcp=" + landhcp
				+ ", lanip=" + lanip + ", lanmask=" + lanmask + ", langw=" + langw + ", hddinfos=" + hddinfos
				+ ", tunerinfos=" + tunerinfos + ", servicename=" + servicename + ", servicenamespace="
				+ servicenamespace + ", serviceaspect=" + serviceaspect + ", serviceprovider=" + serviceprovider
				+ ", videowidth=" + videowidth + ", videoheight=" + videoheight + ", servicevideosize="
				+ servicevideosize + ", apid=" + apid + ", vpid=" + vpid + ", pcrpid=" + pcrpid + ", pmtpid=" + pmtpid
				+ ", txtpid=" + txtpid + ", tsid=" + tsid + ", onid=" + onid + ", sid=" + sid + "]";
	}

}
