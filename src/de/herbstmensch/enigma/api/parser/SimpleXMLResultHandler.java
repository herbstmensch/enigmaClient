package de.herbstmensch.enigma.api.parser;

import java.util.Stack;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import de.herbstmensch.enigma.model.SimpleXMLResult;

public class SimpleXMLResultHandler extends DefaultHandler {

	public SimpleXMLResult result = null;

	private Stack<String> elementStack = new Stack<String>();

	@Override
	public void startElement(String uri, String localName, String qName,
			Attributes attributes) throws SAXException {

		elementStack.push(qName);

		if ("e2simplexmlresult".equalsIgnoreCase(qName)) {
			result = new SimpleXMLResult();
		}

	}

	@Override
	public void endElement(String uri, String localName, String qName)
			throws SAXException {
		elementStack.pop();
	}

	@Override
	public void characters(char ch[], int start, int length)
			throws SAXException {

		String value = new String(ch, start, length).trim();
		// ignore white space
		if (value.length() == 0)
			return;

		if ("e2state".equals(elementStack.peek())) {
			result.setState(value);
		} else if ("e2statetext".equals(elementStack.peek())) {
			result.setText(value);
		}
	}

}
