
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
import de.herbstmensch.enigma.model.Event;
import de.herbstmensch.enigma.model.EventList;
import de.herbstmensch.enigma.model.Location;
import de.herbstmensch.enigma.model.LocationList;
import de.herbstmensch.enigma.model.MessageDuration;
import de.herbstmensch.enigma.model.MessageType;
import de.herbstmensch.enigma.model.Movie;
import de.herbstmensch.enigma.model.MovieList;
import de.herbstmensch.enigma.model.Service;
import de.herbstmensch.enigma.model.ServiceList;
import de.herbstmensch.enigma.model.SimpleXMLResult;
import de.herbstmensch.enigma.model.TimerList;

public class EnigmaAPI {

	public static class Builder {
		private String host = null;

		private String pass = null;

		private int port = 81;

		private String proxyHost = null;

		private int proxyPort = 8080;

		private Proxy.Type proxyType = Proxy.Type.HTTP;

		private boolean useHttps = false;

		private String user = null;

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

	private Proxy proxy;

	private URL url;

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

	public SimpleXMLResult addTimer(Event event, boolean justPlay, Location location)
			throws APIException, EnigmaException {
		try {
			if (event == null)
				throw new APIException("Event must not be null");
			if (event.getId() == null)
				throw new APIException("Event.id must not be null");
			if (event.getServicereference() == null)
				throw new APIException("Event.serviceReference must not be null");
			if (location == null)
				throw new APIException("Location must not be null");
			if (location.getLocation() == null)
				throw new APIException("Location.location must not be null");
			String url = MessageFormat.format("/web/timeraddbyeventid?sRef={0}", encode(event.getServicereference()));
			url += "&justplay=" + (justPlay ? 1 : 0);
			url += MessageFormat.format("&dirname={0}", encode(location.getLocation()));
			String result = getResult(url);
			checkError(result);
			return ResultParser.getInstance().parse(result);
		} catch (Exception e) {
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

	private String encode(String s) throws APIException {
		try {
			return URLEncoder.encode(s, "UTF-8");
		} catch (IOException e) {
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

	public EventList epgMulti(Bouquet bouquet, EnigmaTimestamp time, EnigmaTimestamp endTime)
			throws APIException, EnigmaException {
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
		String result = getResult(
				MessageFormat.format("/web/epgnowNext?bRef={0}", encode(bouquet.getServicereference())));
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

	public EventList epgService(Service service, EnigmaTimestamp time, EnigmaTimestamp endTime)
			throws APIException, EnigmaException {
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
		String result = getResult(
				MessageFormat.format("/web/epgservicenext?sRef={0}", encode(service.getServicereference())));
		checkError(result);
		return ResultParser.getInstance().parse(result);
	}

	public EventList epgServiceNow(Service service) throws APIException, EnigmaException {
		if (service == null)
			throw new APIException("Service must not be null");
		String result = getResult(
				MessageFormat.format("/web/epgservicenow?sRef={0}", encode(service.getServicereference())));
		checkError(result);
		return ResultParser.getInstance().parse(result);
	}

	public BouquetList getAllBouquets() throws APIException, EnigmaException {
		String result = getResult("/web/getallservices?sRef=" + encode(
				"1:7:1:0:0:0:0:0:0:0:(type == 1) || (type == 17) || (type == 195) || (type == 25) FROM BOUQUET \"bouquets.tv\" ORDER BY bouquet"));
		checkError(result);
		return ResultParser.getInstance().parse(result);
	}

	public ServiceList getAllProviders() throws APIException, EnigmaException {
		String result = getResult("/web/getservices?sRef=" + encode(
				"1:7:1:0:0:0:0:0:0:0:(type == 1) || (type == 17) || (type == 195) || (type == 25) FROM PROVIDERS ORDER BY name"));
		checkError(result);
		return ResultParser.getInstance().parse(result);
	}

	private URLConnection getConnection(String url) throws MalformedURLException, IOException {
		if (proxy == null)
			return new URL(this.url, url).openConnection();
		else
			return new URL(this.url, url).openConnection(proxy);
	}

	public LocationList getCurrentLocation() throws APIException, EnigmaException {
		String result = getResult("/web/getcurrlocation");
		checkError(result);
		return ResultParser.getInstance().parse(result);
	}

	public LocationList getLocations() throws APIException, EnigmaException {
		String result = getResult("/web/getlocations");
		checkError(result);
		return ResultParser.getInstance().parse(result);
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

	public ServiceList getServices(Bouquet bouquet) throws APIException, EnigmaException {
		if (bouquet == null)
			throw new APIException("Bouquet must not be null");
		String result = getResult(
				MessageFormat.format("/web/getservices?sRef={0}", encode(bouquet.getServicereference())));
		checkError(result);
		return ResultParser.getInstance().parse(result);
	}

	public TimerList getTimerlist() throws APIException, EnigmaException {
		String result = getResult("/web/timerlist");
		checkError(result);
		return ResultParser.getInstance().parse(result);
	}

	public SimpleXMLResult message(String message, MessageType messageType, MessageDuration duration)
			throws APIException, EnigmaException {
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

	public MovieList movieList(Location location) throws APIException, EnigmaException {
		String url = "/web/movielist";
		if (location != null && location.getLocation() != null)
			url += MessageFormat.format("?dirname={}", encode(location.getLocation()));
		String result = getResult(url);
		checkError(result);
		return ResultParser.getInstance().parse(result);
	}

	public SimpleXMLResult zap(Movie movie) throws APIException, EnigmaException {
		if (movie == null)
			throw new APIException("Movie must not be null");
		String url = MessageFormat.format("/web/zap?sRef={0}", encode(movie.getServicereference()));
		if(movie.getTitle() != null)
			url += MessageFormat.format("&title={0}", encode(movie.getTitle()));
		String result = getResult(url);
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

}