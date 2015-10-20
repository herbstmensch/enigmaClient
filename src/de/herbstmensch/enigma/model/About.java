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

	@XStreamAlias("e2oeversion")
	private String oeversion;

	@XStreamAlias("e2enigmaversion")
	private String enigmaversion;

	@XStreamAlias("e2distroversion")
	private String distroversion;

	@XStreamAlias("e2imageversion")
	private String imageversion;

	@XStreamAlias("e2driverdate")
	private String driverdate;

	@XStreamAlias("e2webifversion")
	private String webifversion;

	@XStreamAlias("e2fpversion")
	private String fpversion;

	@XStreamAlias("e2model")
	private String model;

	@XStreamAlias("e2lanmac")
	private String lanmac;

	@XStreamAlias("e2landhcp")
	private String landhcp;

	@XStreamAlias("e2lanip")
	private String lanip;

	@XStreamAlias("e2lanmask")
	private String lanmask;

	@XStreamAlias("e2langw")
	private String langw;

	@XStreamImplicit(itemFieldName = "e2hddinfo")
	private List<HDDInfo> hddinfos = new ArrayList<HDDInfo>();

	@XStreamAlias("e2tunerinfo")
	private List<TunerInfo> tunerinfos = new ArrayList<TunerInfo>();

	@XStreamAlias("e2servicename")
	private String servicename;

	@XStreamAlias("e2servicenamespace")
	private String servicenamespace;

	@XStreamAlias("e2serviceaspect")
	private String serviceaspect;

	@XStreamAlias("e2serviceprovider")
	private String serviceprovider;

	@XStreamAlias("e2videowidth")
	private String videowidth;

	@XStreamAlias("e2videoheight")
	private String videoheight;

	@XStreamAlias("e2servicevideosize")
	private String servicevideosize;

	@XStreamAlias("e2apid")
	private String apid;

	@XStreamAlias("e2vpid")
	private String vpid;

	@XStreamAlias("e2pcrpid")
	private String pcrpid;

	@XStreamAlias("e2pmtpid")
	private String pmtpid;

	@XStreamAlias("e2txtpid")
	private String txtpid;

	@XStreamAlias("e2tsid")
	private String tsid;

	@XStreamAlias("e2onid")
	private String onid;

	@XStreamAlias("e2sid")
	private String sid;

	public String getOeversion() {
		return oeversion;
	}

	public void setOeversion(String oeversion) {
		this.oeversion = oeversion;
	}

	public String getEnigmaversion() {
		return enigmaversion;
	}

	public void setEnigmaversion(String enigmaversion) {
		this.enigmaversion = enigmaversion;
	}

	public String getDistroversion() {
		return distroversion;
	}

	public void setDistroversion(String distroversion) {
		this.distroversion = distroversion;
	}

	public String getImageversion() {
		return imageversion;
	}

	public void setImageversion(String imageversion) {
		this.imageversion = imageversion;
	}

	public String getDriverdate() {
		return driverdate;
	}

	public void setDriverdate(String driverdate) {
		this.driverdate = driverdate;
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

	public String getLanmac() {
		return lanmac;
	}

	public void setLanmac(String lanmac) {
		this.lanmac = lanmac;
	}

	public String getLandhcp() {
		return landhcp;
	}

	public void setLandhcp(String landhcp) {
		this.landhcp = landhcp;
	}

	public String getLanip() {
		return lanip;
	}

	public void setLanip(String lanip) {
		this.lanip = lanip;
	}

	public String getLanmask() {
		return lanmask;
	}

	public void setLanmask(String lanmask) {
		this.lanmask = lanmask;
	}

	public String getLangw() {
		return langw;
	}

	public void setLangw(String langw) {
		this.langw = langw;
	}

	public List<HDDInfo> getHddinfos() {
		return hddinfos;
	}

	public void setHddinfos(List<HDDInfo> hddinfos) {
		this.hddinfos = hddinfos;
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
