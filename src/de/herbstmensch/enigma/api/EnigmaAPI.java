package de.herbstmensch.enigma.api;

import java.net.Authenticator;
import java.net.MalformedURLException;
import java.net.PasswordAuthentication;
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

	public EnigmaAPI(boolean useHttps, String host, int port) throws MalformedURLException {
		this(useHttps, host, port, null, null);
	}

	public EnigmaAPI(boolean useHttps, String host, int port, final String user, final String pass)
			throws MalformedURLException {
		this.url = new URL((useHttps ? "https" : "http") + "://" + host + ":" + port);
		if (user != null)
			Authenticator.setDefault(new Authenticator() {
				protected PasswordAuthentication getPasswordAuthentication() {
					return new PasswordAuthentication(user, pass.toCharArray());

				}
			});
	}

	public AboutList about() throws APIException {
		try {

			URLConnection con = new URL(url, "web/about").openConnection();

			return ResultParser.getInstance().parse(con.getInputStream());
		} catch (Exception e) {
			throw new APIException(e);
		}
	}

	public BouquetList getAllServices() throws APIException {
		try {
			URLConnection con = new URL(url, "/web/getallservices").openConnection();
			return ResultParser.getInstance().parse(con.getInputStream());
		} catch (Exception e) {
			throw new APIException(e);
		}
	}

	public TimerList getTimerlist() throws APIException {
		try {
			URLConnection con = new URL(url, "/web/timerlist").openConnection();
			return ResultParser.getInstance().parse(con.getInputStream());
		} catch (Exception e) {
			throw new APIException(e);
		}
	}

	public ServiceList getServices(Bouquet bouquet) throws APIException {
		try {
			URLConnection con = new URL(url, MessageFormat.format("/web/getservices?sRef={0}",
					URLEncoder.encode(bouquet.getServicereference(), "UTF-8"))).openConnection();
			return ResultParser.getInstance().parse(con.getInputStream());
		} catch (Exception e) {
			throw new APIException(e);
		}
	}

	public EventList epg(Bouquet bouquet, Timestamp time) throws APIException {
		try {
			URLConnection con = new URL(url,
					MessageFormat.format("/web/epgbouquet?bRef={0}&time={1,number,#}",
							URLEncoder.encode(bouquet.getServicereference(), "UTF-8"), time.getTime() / 1000))
									.openConnection();
			return ResultParser.getInstance().parse(con.getInputStream());
		} catch (Exception e) {
			throw new APIException(e);
		}

	}

	public EventList epgNow(Bouquet bouquet) throws APIException {
		try {
			URLConnection con = new URL(url, MessageFormat.format("/web/epgnow?bRef={0}",
					URLEncoder.encode(bouquet.getServicereference(), "UTF-8"))).openConnection();
			return ResultParser.getInstance().parse(con.getInputStream());
		} catch (Exception e) {
			throw new APIException(e);
		}
	}

	public EventList epgNext(Bouquet bouquet) throws APIException {
		try {
			URLConnection con = new URL(url, MessageFormat.format("/web/epgnext?bRef={0}",
					URLEncoder.encode(bouquet.getServicereference(), "UTF-8"))).openConnection();
			return ResultParser.getInstance().parse(con.getInputStream());
		} catch (Exception e) {
			throw new APIException(e);
		}
	}

	public SimpleXMLResult zap(Service service) throws APIException {
		try {
			URLConnection con = new URL(url, MessageFormat.format("/web/zap?sRef={0}",
					URLEncoder.encode(service.getServicereference(), "UTF-8"))).openConnection();
			return ResultParser.getInstance().parse(con.getInputStream());
		} catch (Exception e) {
			throw new APIException(e);
		}
	}

	public SimpleXMLResult message(String message, MessageType messageType, MessageDuration duration)
			throws APIException {

		try {
			URLConnection con = new URL(url,
					MessageFormat.format("/web/message?text={0}&type={1}&timeout={2,number,#}",
							URLEncoder.encode(message, "UTF-8"), messageType.value(), duration.value()))
									.openConnection();
			return ResultParser.getInstance().parse(con.getInputStream());
		} catch (Exception e) {
			throw new APIException(e);
		}

	}

	public SimpleXMLResult messageAnswer() throws APIException {
		try {
			URLConnection con = new URL(url, "/web/messageanswer?getanswer=now").openConnection();
			return ResultParser.getInstance().parse(con.getInputStream());
		} catch (Exception e) {
			throw new APIException(e);
		}
	}

}
