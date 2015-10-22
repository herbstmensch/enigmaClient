
package de.herbstmensch.enigma.api;

import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.Authenticator;
import java.net.InetSocketAddress;
import java.net.MalformedURLException;
import java.net.PasswordAuthentication;
import java.net.Proxy;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLEncoder;
import java.nio.charset.Charset;
import java.text.MessageFormat;

import de.herbstmensch.enigma.api.exceptions.APIException;
import de.herbstmensch.enigma.api.exceptions.EnigmaException;
import de.herbstmensch.enigma.api.parser.ResultParser;
import de.herbstmensch.enigma.model.AboutList;
import de.herbstmensch.enigma.model.Bouquet;
import de.herbstmensch.enigma.model.BouquetList;
import de.herbstmensch.enigma.model.EnigmaTimestamp;
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

	public AboutList about() throws APIException, EnigmaException {
		try {
			String result = getResult("web/about");
			checkError(result);
			return ResultParser.getInstance().parse(result);
		} catch (Exception e) {
			throw new APIException(e);
		}
	}

	public EventList epgBouquet(Bouquet bouquet, EnigmaTimestamp time) throws APIException, EnigmaException {
		if (bouquet == null)
			throw new APIException("Bouquet must not be null");
		String url = MessageFormat.format("/web/epgbouquet?bRef={0}", encode(bouquet.getServicereference()));
		if (time != null)
			url += MessageFormat.format("&time={0,number,#}", time.getEnigmaTime());
		String result = getResult(url);
		checkError(result);
		return ResultParser.getInstance().parse(result);
	}

	public EventList epgMulti(Bouquet bouquet, EnigmaTimestamp time, EnigmaTimestamp endTime) throws APIException, EnigmaException {
		if (bouquet == null)
			throw new APIException("Bouquet must not be null");
		String url = MessageFormat.format("/web/epgbouquet?bRef={0}", encode(bouquet.getServicereference()));
		if (time != null)
			url += MessageFormat.format("&time={0,number,#}", time.getEnigmaTime());
		if (endTime != null)
			url += MessageFormat.format("&endTime={0,number,#}", endTime.getEnigmaTime());

		String result = getResult(url);
		checkError(result);
		return ResultParser.getInstance().parse(result);
	}

	public EventList epgNext(Bouquet bouquet) throws APIException, EnigmaException {
		if (bouquet == null)
			throw new APIException("Bouquet must not be null");
		String result = getResult(MessageFormat.format("/web/epgnext?bRef={0}", encode(bouquet.getServicereference())));
		checkError(result);
		return ResultParser.getInstance().parse(result);
	}

	public EventList epgNow(Bouquet bouquet) throws APIException, EnigmaException {
		if (bouquet == null)
			throw new APIException("Bouquet must not be null");
		String result = getResult(MessageFormat.format("/web/epgnow?bRef={0}", encode(bouquet.getServicereference())));
		checkError(result);
		return ResultParser.getInstance().parse(result);
	}

	public EventList epgNowNext(Bouquet bouquet) throws APIException, EnigmaException {
		if (bouquet == null)
			throw new APIException("Bouquet must not be null");
		String result = getResult(MessageFormat.format("/web/epgnowNext?bRef={0}", encode(bouquet.getServicereference())));
		checkError(result);
		return ResultParser.getInstance().parse(result);
	}

	public EventList epgSearch(String search) throws APIException, EnigmaException {
		if (search == null)
			throw new APIException("Search must not be null");
		String result = getResult(MessageFormat.format("/web/epgsearch?search={0}", encode(search)));
		checkError(result);
		return ResultParser.getInstance().parse(result);
	}

	public EventList epgService(Service service, EnigmaTimestamp time, EnigmaTimestamp endTime) throws APIException, EnigmaException {
		if (service == null)
			throw new APIException("Service must not be null");
		String url = MessageFormat.format("/web/epgservice?sRef={0}", encode(service.getServicereference()));
		if (time != null)
			url += MessageFormat.format("&time={0,number,#}", time.getEnigmaTime());
		if (endTime != null)
			url += MessageFormat.format("&endTime={0,number,#}", endTime.getEnigmaTime());

		String result = getResult(url);
		checkError(result);
		return ResultParser.getInstance().parse(result);
	}

	public EventList epgServiceNext(Service service) throws APIException, EnigmaException {
		if (service == null)
			throw new APIException("Service must not be null");
		String result = getResult(MessageFormat.format("/web/epgservicenext?sRef={0}", encode(service.getServicereference())));
		checkError(result);
		return ResultParser.getInstance().parse(result);
	}

	public EventList epgServiceNow(Service service) throws APIException, EnigmaException {
		if (service == null)
			throw new APIException("Service must not be null");
		String result = getResult(MessageFormat.format("/web/epgservicenow?sRef={0}", encode(service.getServicereference())));
		checkError(result);
		return ResultParser.getInstance().parse(result);
	}

	public BouquetList getAllServices() throws APIException, EnigmaException {
		String result = getResult("/web/getallservices");
		checkError(result);
		return ResultParser.getInstance().parse(result);
	}

	public ServiceList getServices(Bouquet bouquet) throws APIException, EnigmaException {
		if (bouquet == null)
			throw new APIException("Bouquet must not be null");
		String result = getResult(MessageFormat.format("/web/getservices?sRef={0}", encode(bouquet.getServicereference())));
		checkError(result);
		return ResultParser.getInstance().parse(result);
	}

	public TimerList getTimerlist() throws APIException, EnigmaException {
		String result = getResult("/web/timerlist");
		checkError(result);
		return ResultParser.getInstance().parse(result);
	}

	public SimpleXMLResult message(String message, MessageType messageType, MessageDuration duration) throws APIException, EnigmaException {
		if (message == null)
			throw new APIException("Message must not be null");
		if (messageType == null)
			throw new APIException("MessageType must not be null");
		if (duration == null)
			throw new APIException("Duration must not be null");
		String url = MessageFormat.format("/web/message?text={0}&timeout={2,number,#}", encode(message));
		url += MessageFormat.format("&type={0}", messageType.value());
		url += MessageFormat.format("&timeout={0,number,#}", duration.value());
		String result = getResult(url);
		checkError(result);
		return ResultParser.getInstance().parse(result);

	}

	public SimpleXMLResult messageAnswer() throws APIException, EnigmaException {
		String result = getResult("/web/messageanswer?getanswer=now");
		checkError(result);
		return ResultParser.getInstance().parse(result);
	}

	public SimpleXMLResult zap(Service service) throws APIException, EnigmaException {
		if (service == null)
			throw new APIException("Service must not be null");
		String result = getResult(MessageFormat.format("/web/zap?sRef={0}", encode(service.getServicereference())));
		checkError(result);
		return ResultParser.getInstance().parse(result);
	}

	private Object encode(String s) throws APIException {
		try {
			return URLEncoder.encode(s, "UTF-8");
		} catch (IOException e) {
			throw new APIException(e);
		}
	}

	private URLConnection getConnection(String url) throws MalformedURLException, IOException {
		if (proxy == null)
			return new URL(this.url, url).openConnection();
		else
			return new URL(this.url, url).openConnection(proxy);
	}

	private String getResult(String url) throws APIException, EnigmaException {
		InputStream in = null;
		try {

			in = getConnection(url).getInputStream();
			BufferedInputStream bis = new BufferedInputStream(in);
			StringBuffer baf = new StringBuffer(50);
			int read = 0;
			int bufSize = 512;
			byte[] buffer = new byte[bufSize];
			while (true) {
				read = bis.read(buffer);
				if (read == -1) {
					break;
				}
				baf.append(new String(buffer, 0, read, Charset.forName("UTF-8")));
			}
			return baf.toString();
		} catch (Throwable e) {
			throw new APIException(e);
		}
	}

	private void checkError(String result) throws EnigmaException, APIException {
		SimpleXMLResult sr;
		try {
			sr = ResultParser.getInstance().parse(result);
		} catch (ClassCastException e) {
			// Result is no SimpleXMLResult
			return;
		}
		if ("false".equalsIgnoreCase(sr.getState()))
			throw new EnigmaException(sr.getStatetext());
	}

	public static class Builder {
		private boolean useHttps = false;
		private String host = null;
		private int port = 81;
		private String user = null;
		private String pass = null;
		private String proxyHost = null;
		private int proxyPort = 8080;
		private Proxy.Type proxyType = Proxy.Type.HTTP;

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

		public Builder setProxyType(Proxy.Type proxyType) {
			this.proxyType = proxyType;
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