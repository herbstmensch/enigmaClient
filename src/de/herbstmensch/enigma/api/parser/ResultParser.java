package de.herbstmensch.enigma.api.parser;

import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.mapper.MapperWrapper;

import de.herbstmensch.enigma.EnigmaTimestampConverter;
import de.herbstmensch.enigma.api.exceptions.APIException;
import de.herbstmensch.enigma.model.About;
import de.herbstmensch.enigma.model.AboutList;
import de.herbstmensch.enigma.model.Bouquet;
import de.herbstmensch.enigma.model.BouquetList;
import de.herbstmensch.enigma.model.Event;
import de.herbstmensch.enigma.model.EventList;
import de.herbstmensch.enigma.model.Location;
import de.herbstmensch.enigma.model.LocationList;
import de.herbstmensch.enigma.model.Movie;
import de.herbstmensch.enigma.model.MovieList;
import de.herbstmensch.enigma.model.Service;
import de.herbstmensch.enigma.model.ServiceList;
import de.herbstmensch.enigma.model.SimpleXMLResult;
import de.herbstmensch.enigma.model.Timer;
import de.herbstmensch.enigma.model.TimerList;

public class ResultParser {

	private static ResultParser parser;

	private XStream xstream;

	private ResultParser() {
		xstream = new XStream() {
			@Override
			protected MapperWrapper wrapMapper(MapperWrapper next) {
				return new MapperWrapper(next) {
					@Override
					public boolean shouldSerializeMember(@SuppressWarnings("rawtypes") Class definedIn, String fieldName) {
						if (definedIn == Object.class) {
							return false;
						}
						return super.shouldSerializeMember(definedIn, fieldName);
					}
				};
			}
		};
		xstream.registerConverter(new EnigmaTimestampConverter());

		xstream.autodetectAnnotations(true);
		xstream.processAnnotations(About.class);
		xstream.processAnnotations(AboutList.class);
		xstream.processAnnotations(Bouquet.class);
		xstream.processAnnotations(BouquetList.class);
		xstream.processAnnotations(Event.class);
		xstream.processAnnotations(EventList.class);
		xstream.processAnnotations(Location.class);
		xstream.processAnnotations(LocationList.class);
		xstream.processAnnotations(Movie.class);
		xstream.processAnnotations(MovieList.class);
		xstream.processAnnotations(Service.class);
		xstream.processAnnotations(ServiceList.class);
		xstream.processAnnotations(SimpleXMLResult.class);
		xstream.processAnnotations(Timer.class);
		xstream.processAnnotations(TimerList.class);
	}

	public static ResultParser getInstance() {
		if (parser == null)
			parser = new ResultParser();
		return parser;

	}

	@SuppressWarnings("unchecked")
	public <T> T parse(String content) throws APIException {
		if (content == null)
			return null;
		try {
			return (T) xstream.fromXML(content);
		} catch (Throwable t) {
			throw new APIException("Could not parse", t);
		}
	}

}