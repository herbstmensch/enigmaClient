package de.herbstmensch.enigma.api;

import java.io.IOException;
import java.net.Authenticator;
import java.net.InetSocketAddress;
import java.net.MalformedURLException;
import java.net.PasswordAuthentication;
import java.net.Proxy;
import java.net.Proxy.Type;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLEncoder;
import java.sql.Timestamp;
import java.text.MessageFormat;

import de.herbstmensch.enigma.api.exceptions.APIException;
import de.herbstmensch.enigma.api.parser.ResultParser;
import de.herbstmensch.enigma.model.AboutList;
import de.herbstmensch.enigma.model.Bouquet;
import de.herbstmensch.enigma.model.BouquetList;
import de.herbstmensch.enigma.model.EventList;
import de.herbstmensch.enigma.model.MessageDuration;
import de.herbstmensch.enigma.model.MessageType;
import de.herbstmensch.enigma.model.Service;
import de.herbstmensch.enigma.model.ServiceList;
import de.herbstmensch.enigma.model.SimpleXMLResult;
import de.herbstmensch.enigma.model.TimerList;

public class EnigmaAPI {

	private URL url;
	private Proxy proxy;

	private EnigmaAPI() {
	}

	public AboutList about() throws APIException {
		try {
			URLConnection con = getConnection("web/about");
			return ResultParser.getInstance().parse(con.getInputStream());
		} catch (Exception e) {
			throw new APIException(e);
		}
	}

	public EventList epgBouquet(Bouquet bouquet, Timestamp time) throws APIException {
		try {
			URLConnection con = getConnection(MessageFormat.format("/web/epgbouquet?bRef={0}&time={1,number,#}", URLEncoder.encode(bouquet.getServicereference(), "UTF-8"), time.getTime() / 1000));
			return ResultParser.getInstance().parse(con.getInputStream());
		} catch (Exception e) {
			throw new APIException(e);
		}
	}
	
	public EventList epgMulti(Bouquet bouquet, Timestamp time, Timestamp endTime) throws APIException {
		try {
			URLConnection con = getConnection(MessageFormat.format("/web/epgbouquet?bRef={0}&time={1,number,#}&endTime={2,number,#}", URLEncoder.encode(bouquet.getServicereference(), "UTF-8"), time.getTime() / 1000, endTime.getTime() / 1000));
			return ResultParser.getInstance().parse(con.getInputStream());
		} catch (Exception e) {
			throw new APIException(e);
		}
	}

	public EventList epgNext(Bouquet bouquet) throws APIException {
		try {
			URLConnection con = getConnection(MessageFormat.format("/web/epgnext?bRef={0}", URLEncoder.encode(bouquet.getServicereference(), "UTF-8")));
			return ResultParser.getInstance().parse(con.getInputStream());
		} catch (Exception e) {
			throw new APIException(e);
		}
	}

	public EventList epgNow(Bouquet bouquet) throws APIException {
		try {
			URLConnection con = getConnection(MessageFormat.format("/web/epgnow?bRef={0}", URLEncoder.encode(bouquet.getServicereference(), "UTF-8")));
			return ResultParser.getInstance().parse(con.getInputStream());
		} catch (Exception e) {
			throw new APIException(e);
		}
	}
	public EventList epgNowNext(Bouquet bouquet) throws APIException {
		try {
			URLConnection con = getConnection(MessageFormat.format("/web/epgnowNext?bRef={0}", URLEncoder.encode(bouquet.getServicereference(), "UTF-8")));
			return ResultParser.getInstance().parse(con.getInputStream());
		} catch (Exception e) {
			throw new APIException(e);
		}
	}
	public EventList epgSearch(String search) throws APIException {
		try {
			URLConnection con = getConnection(MessageFormat.format("/web/epgsearch?search={0}", URLEncoder.encode(search, "UTF-8")));
			return ResultParser.getInstance().parse(con.getInputStream());
		} catch (Exception e) {
			throw new APIException(e);
		}
	}
	
	public EventList epgService(Service service, Timestamp time, Timestamp endTime) throws APIException {
		try {
			URLConnection con = getConnection(MessageFormat.format("/web/epgservice?sRef={0}&time={1,number,#}&endTime={2,number,#}", URLEncoder.encode(service.getServicereference(), "UTF-8"), time.getTime() / 1000, endTime.getTime() / 1000));
			return ResultParser.getInstance().parse(con.getInputStream());
		} catch (Exception e) {
			throw new APIException(e);
		}
	}

	public EventList epgServiceNext(Service service) throws APIException {
		try {
			URLConnection con = getConnection(MessageFormat.format("/web/epgnext?sRef={0}", URLEncoder.encode(service.getServicereference(), "UTF-8")));
			return ResultParser.getInstance().parse(con.getInputStream());
		} catch (Exception e) {
			throw new APIException(e);
		}
	}

	public EventList epgServiceNow(Service service) throws APIException {
		try {
			URLConnection con = getConnection(MessageFormat.format("/web/epgnow?sRef={0}", URLEncoder.encode(service.getServicereference(), "UTF-8")));
			return ResultParser.getInstance().parse(con.getInputStream());
		} catch (Exception e) {
			throw new APIException(e);
		}
	}

	public BouquetList getAllServices() throws APIException {
		try {
			URLConnection con = getConnection("/web/getallservices");
			return ResultParser.getInstance().parse(con.getInputStream());
		} catch (Exception e) {
			throw new APIException(e);
		}
	}

	public ServiceList getServices(Bouquet bouquet) throws APIException {
		try {
			URLConnection con = getConnection(MessageFormat.format("/web/getservices?sRef={0}", URLEncoder.encode(bouquet.getServicereference(), "UTF-8")));
			return ResultParser.getInstance().parse(con.getInputStream());
		} catch (Exception e) {
			throw new APIException(e);
		}
	}

	public TimerList getTimerlist() throws APIException {
		try {
			URLConnection con = getConnection("/web/timerlist");
			return ResultParser.getInstance().parse(con.getInputStream());
		} catch (Exception e) {
			throw new APIException(e);
		}
	}

	public SimpleXMLResult message(String message, MessageType messageType, MessageDuration duration) throws APIException {

		try {
			URLConnection con = getConnection(MessageFormat.format("/web/message?text={0}&type={1}&timeout={2,number,#}", URLEncoder.encode(message, "UTF-8"), messageType.value(), duration.value()));
			return ResultParser.getInstance().parse(con.getInputStream());
		} catch (Exception e) {
			throw new APIException(e);
		}

	}

	public SimpleXMLResult messageAnswer() throws APIException {
		try {
			URLConnection con = getConnection("/web/messageanswer?getanswer=now");
			return ResultParser.getInstance().parse(con.getInputStream());
		} catch (Exception e) {
			throw new APIException(e);
		}
	}

	public SimpleXMLResult zap(Service service) throws APIException {
		try {
			URLConnection con = getConnection(MessageFormat.format("/web/zap?sRef={0}", URLEncoder.encode(service.getServicereference(), "UTF-8")));
			return ResultParser.getInstance().parse(con.getInputStream());
		} catch (Exception e) {
			throw new APIException(e);
		}
	}

	private URLConnection getConnection(String url) throws MalformedURLException, IOException {
		if (proxy == null)
			return new URL(this.url, url).openConnection();
		else
			return new URL(this.url, url).openConnection(proxy);
	}

	public static class Builder {
		private boolean useHttps = false;
		private String host = null;
		private int port = 81;
		private String user = null;
		private String pass = null;
		private String proxyHost = null;
		private int proxyPort = 8080;
		private Type proxyType = Proxy.Type.HTTP;

		public EnigmaAPI build() throws MalformedURLException {
			EnigmaAPI api = new EnigmaAPI();

			api.url = new URL((useHttps ? "https" : "http") + "://" + host + ":" + port);
			if (user != null)
				Authenticator.setDefault(new Authenticator() {
					protected PasswordAuthentication getPasswordAuthentication() {
						return new PasswordAuthentication(user, pass.toCharArray());
					}
				});

			if (proxyHost != null)
				api.proxy = new Proxy(proxyType, new InetSocketAddress(proxyHost, proxyPort));

			return api;
		}

		public Builder setHost(String host) {
			this.host = host;
			return this;
		}

		public Builder setPass(String pass) {
			this.pass = pass;
			return this;
		}

		public Builder setPort(int port) {
			this.port = port;
			return this;
		}

		public Builder setProxyHost(String proxyHost) {
			this.proxyHost = proxyHost;
			return this;
		}

		public Builder setProxyPort(int proxyPort) {
			this.proxyPort = proxyPort;
			return this;
		}

		public Builder setUseHttps(boolean useHttps) {
			this.useHttps = useHttps;
			return this;
		}

		public Builder setUser(String user) {
			this.user = user;
			return this;
		}
	}

}
