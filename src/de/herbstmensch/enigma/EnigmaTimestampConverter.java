package de.herbstmensch.enigma;

import com.thoughtworks.xstream.converters.Converter;
import com.thoughtworks.xstream.converters.MarshallingContext;
import com.thoughtworks.xstream.converters.UnmarshallingContext;
import com.thoughtworks.xstream.io.HierarchicalStreamReader;
import com.thoughtworks.xstream.io.HierarchicalStreamWriter;

import de.herbstmensch.enigma.model.EnigmaTimestamp;

public class EnigmaTimestampConverter implements Converter {

	@Override
	public boolean canConvert(Class object) {
	      return object.equals(EnigmaTimestamp.class);
	   }
	   
	   public void marshal(Object value, HierarchicalStreamWriter writer, MarshallingContext context) {
		   EnigmaTimestamp ts = (EnigmaTimestamp) value;
	      writer.setValue(""+ts.getEnigmaTime());
	   }
	   
	   public Object unmarshal(HierarchicalStreamReader reader, UnmarshallingContext context) {
	      String t = reader.getValue();
	      EnigmaTimestamp ts = EnigmaTimestamp.from(t);
	      return ts;
	   }

}
