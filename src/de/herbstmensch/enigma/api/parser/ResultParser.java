package de.herbstmensch.enigma.api.parser;

import java.io.BufferedInputStream;
import java.io.InputStream;
import java.util.List;

import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import de.herbstmensch.enigma.api.exceptions.APIException;
import de.herbstmensch.enigma.model.About;
import de.herbstmensch.enigma.model.SimpleXMLResult;

public class ResultParser {

	public List<About> parseAbout(InputStream content) throws APIException {
		if (content == null)
			return null;
		SAXParserFactory factory = SAXParserFactory.newInstance();
		try {
			SAXParser saxParser = factory.newSAXParser();
			AboutHandler handler = new AboutHandler();
			saxParser.parse(content, handler);
			return handler.abouts;
		} catch (Throwable t) {
			t.printStackTrace();
			throw new APIException(t.getMessage(), t);
		}
	}

	public SimpleXMLResult parseSimpleXMLResult(InputStream content)
			throws APIException {
		if (content == null)
			return null;
		SAXParserFactory factory = SAXParserFactory.newInstance();
		try {
			SAXParser saxParser = factory.newSAXParser();
			SimpleXMLResultHandler handler = new SimpleXMLResultHandler();
			saxParser.parse(content, handler);
			return handler.result;
		} catch (Throwable t) {
			t.printStackTrace();
			throw new APIException(t.getMessage(), t);
		}
	}

	private String recupereStringInputStream(InputStream inputStream)
			throws Exception {
		byte[] buffer = new byte[1024];
		String sFinal = "";
		int bytesRead = 0;
		BufferedInputStream bis = new BufferedInputStream(inputStream);
		while ((bytesRead = bis.read(buffer)) != -1) 
			sFinal = sFinal + new String(buffer, 0, bytesRead);
		return sFinal;
	}

	public String getString(InputStream content) throws APIException {
		if (content == null)
			return null;
		try {
			return recupereStringInputStream(content);
		} catch (Exception e) {
			throw new APIException(e);
		}
	}
}