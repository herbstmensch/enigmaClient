package de.herbstmensch.enigma.api.parser;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import de.herbstmensch.enigma.model.About;
import de.herbstmensch.enigma.model.HDDInfo;
import de.herbstmensch.enigma.model.LANInfo;
import de.herbstmensch.enigma.model.TunerInfo;

public class AboutHandler extends DefaultHandler {

	public List<About> abouts = new ArrayList<About>();

	private Stack<String> elementStack = new Stack<String>();
	private Stack<Object> objectStack = new Stack<Object>();

	@Override
	public void startElement(String uri, String localName, String qName,
			Attributes attributes) throws SAXException {

		elementStack.push(qName);

		if ("e2about".equalsIgnoreCase(qName)) {
			objectStack.push(new About());
		} else if ("e2lanmac".equalsIgnoreCase(qName)) {
			objectStack.push(new LANInfo());
		} else if ("e2hddinfo".equalsIgnoreCase(qName)) {
			objectStack.push(new HDDInfo());
		} else if ("e2nim".equalsIgnoreCase(qName)) {
			objectStack.push(new TunerInfo());
		}

	}

	@Override
	public void endElement(String uri, String localName, String qName)
			throws SAXException {
		elementStack.pop();

		if ("e2about".equalsIgnoreCase(qName)) {
			abouts.add((About) objectStack.pop());
		} else if ("e2langw".equalsIgnoreCase(qName)) {
			LANInfo h = (LANInfo) objectStack.pop();
			((About) objectStack.peek()).getLanInfos().add(h);
		} else if ("e2hddinfo".equalsIgnoreCase(qName)) {
			HDDInfo h = (HDDInfo) objectStack.pop();
			((About) objectStack.peek()).getHddInfos().add(h);
		} else if ("e2nim".equalsIgnoreCase(qName)) {
			TunerInfo h = (TunerInfo) objectStack.pop();
			((About) objectStack.peek()).getTunerinfos().add(h);
		}
	}

	@Override
	public void characters(char ch[], int start, int length)
			throws SAXException {

		String value = new String(ch, start, length).trim();
		// ignore white space
		if (value.length() == 0)
			return;

		if (objectStack.peek() instanceof About) {
			About a = (About) objectStack.peek();
			if ("e2enigmaversion".equals(elementStack.peek())) {
				a.setEnigmaversion(value);
			} else if ("e2imageversion".equals(elementStack.peek())) {
				a.setImageversion(value);
			} else if ("e2webifversion".equals(elementStack.peek())) {
				a.setWebifversion(value);
			} else if ("e2fpversion".equals(elementStack.peek())) {
				a.setFpversion(value);
			} else if ("e2model".equals(elementStack.peek())) {
				a.setModel(value);
			} else if ("e2servicename".equals(elementStack.peek())) {
				a.setServicename(value);
			} else if ("e2servicenamespace".equals(elementStack.peek())) {
				a.setServicenamespace(value);
			} else if ("e2serviceaspect".equals(elementStack.peek())) {
				a.setServiceaspect(value);
			} else if ("e2serviceprovider".equals(elementStack.peek())) {
				a.setServiceprovider(value);
			} else if ("e2videowidth".equals(elementStack.peek())) {
				a.setVideowidth(value);
			} else if ("e2videoheight".equals(elementStack.peek())) {
				a.setVideoheight(value);
			} else if ("e2servicevideosize".equals(elementStack.peek())) {
				a.setServicevideosize(value);
			} else if ("e2apid".equals(elementStack.peek())) {
				a.setApid(value);
			} else if ("e2vpid".equals(elementStack.peek())) {
				a.setVpid(value);
			} else if ("e2pcrpid".equals(elementStack.peek())) {
				a.setPcrpid(value);
			} else if ("e2pmtpid".equals(elementStack.peek())) {
				a.setPmtpid(value);
			} else if ("e2txtpid".equals(elementStack.peek())) {
				a.setTxtpid(value);
			} else if ("e2tsid".equals(elementStack.peek())) {
				a.setTsid(value);
			} else if ("e2onid".equals(elementStack.peek())) {
				a.setOnid(value);
			} else if ("e2sid".equals(elementStack.peek())) {
				a.setSid(value);
			}
		} else if (objectStack.peek() instanceof LANInfo) {
			LANInfo a = (LANInfo) objectStack.peek();
			if ("e2lanmac".equals(elementStack.peek())) {
				a.setLanmac(value);
			} else if ("e2landhcp".equals(elementStack.peek())) {
				a.setLandhcp(value);
			} else if ("e2lanip".equals(elementStack.peek())) {
				a.setLanip(value);
			} else if ("e2lanmask".equals(elementStack.peek())) {
				a.setLanmask(value);
			} else if ("e2langw".equals(elementStack.peek())) {
				a.setLangw(value);
			}
		} else if (objectStack.peek() instanceof HDDInfo) {
			HDDInfo a = (HDDInfo) objectStack.peek();
			if ("model".equals(elementStack.peek())) {
				a.setModel(value);
			} else if ("capacity".equals(elementStack.peek())) {
				a.setCapacity(value);
			} else if ("free".equals(elementStack.peek())) {
				a.setFree(value);
			}
		} else if (objectStack.peek() instanceof TunerInfo) {
			TunerInfo a = (TunerInfo) objectStack.peek();
			if ("name".equals(elementStack.peek())) {
				a.setName(value);
			} else if ("type".equals(elementStack.peek())) {
				a.setType(value);
			}
		}
	}

}
