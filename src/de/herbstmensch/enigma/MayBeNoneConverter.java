package de.herbstmensch.enigma;

import com.thoughtworks.xstream.converters.Converter;
import com.thoughtworks.xstream.converters.MarshallingContext;
import com.thoughtworks.xstream.converters.UnmarshallingContext;
import com.thoughtworks.xstream.io.HierarchicalStreamReader;
import com.thoughtworks.xstream.io.HierarchicalStreamWriter;

public class MayBeNoneConverter implements Converter {

	@Override
	public boolean canConvert(@SuppressWarnings("rawtypes") Class object) {
		return object.equals(Integer.class);
	}

	public void marshal(Object value, HierarchicalStreamWriter writer, MarshallingContext context) {
		Integer i = (Integer) value;
		writer.setValue(i.toString());
	}

	public Object unmarshal(HierarchicalStreamReader reader, UnmarshallingContext context) {
		String t = reader.getValue();
		if ("none".equalsIgnoreCase(t))
			return null;
		return Integer.parseInt(t);
	}

}
