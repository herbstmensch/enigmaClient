package de.herbstmensch.enigma.api;

import java.io.IOException;
import java.text.MessageFormat;
import java.util.List;

import org.apache.http.HttpEntity;
import org.apache.http.HttpHost;
import org.apache.http.HttpResponse;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;

import de.herbstmensch.enigma.api.exceptions.APIException;
import de.herbstmensch.enigma.api.parser.ResultParser;
import de.herbstmensch.enigma.model.About;
import de.herbstmensch.enigma.model.MessageDuration;
import de.herbstmensch.enigma.model.MessageType;
import de.herbstmensch.enigma.model.SimpleXMLResult;

public class EnigmaAPI {

	private CloseableHttpClient client;
	private HttpHost host;
	private HttpHost proxy = new HttpHost("as-isa", 8080, "http");
	private RequestConfig config = RequestConfig.custom().setProxy(proxy)
			.build();
	private ResultParser parser = new ResultParser();

	public EnigmaAPI() {
		host = new HttpHost("home.timherbst.de", 82, "http");
	}

	public List<About> about() {
		try {
			HttpEntity entity = get("/web/about");
			return parser.parseAbout(entity.getContent());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	public void message(String message, MessageType messageType, MessageDuration duration) throws APIException {
		try {
			HttpEntity entity = get(MessageFormat.format("/web/message?text={0}&type={1}&duration={2,number,integer}", message, messageType.value(), duration.value()) );
			SimpleXMLResult r = parser
					.parseSimpleXMLResult(entity.getContent());
			if("FALSE".equalsIgnoreCase(r.getState())){
				throw new APIException("Send Message failed: " + r.getText());
			} else {
				System.out.println(r.getText());
			}
		} catch (Exception e) {
			throw new APIException(e);
		}
	}

	private HttpEntity get(String uri) throws APIException {
		try {
			HttpGet get = new HttpGet(uri);
			get.setConfig(config);
			HttpResponse r = getClient().execute(host, get);

			if (r.getStatusLine().getStatusCode() != 200)
				throw new APIException("Return code was: "
						+ r.getStatusLine().getStatusCode());

			return r.getEntity();
		} catch (IOException e) {
			throw new APIException(e);
		}
	}

	private CloseableHttpClient getClient() {
		if (client != null)
			return client;
		else
			return client = HttpClientBuilder.create().build();
	}

	public static void main(String[] args) throws APIException {
		About a = new EnigmaAPI().about().get(0);
		System.out.println(a.getImageversion());
		new EnigmaAPI().message("Test",MessageType.INFO, MessageDuration.SHORT);
	}

}
