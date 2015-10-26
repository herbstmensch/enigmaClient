
package de.herbstmensch.enigma.model;

import java.sql.Timestamp;

/**
 * Created by tim on 06.04.15.
 */
public class EnigmaTimestamp extends Timestamp {

	private static final long serialVersionUID = 1120553909076995805L;

	public EnigmaTimestamp(long theTime) {
            super(theTime > 9999999999l?theTime:theTime*1000);
    }

	public static EnigmaTimestamp from(String timeLong) throws NumberFormatException{
        Long l = Long.valueOf(timeLong);

        return new EnigmaTimestamp(l);

    }
	
	public static EnigmaTimestamp from(long theTime) throws NumberFormatException{
        return new EnigmaTimestamp(theTime);

    }
	
	public static EnigmaTimestamp from(Timestamp ts) throws NumberFormatException{
        return new EnigmaTimestamp(ts.getTime());

    }

    public long getEnigmaTime() {
        //Return Enigma time-Long (no Millies)
        return super.getTime()/1000;
    }
    
    public static EnigmaTimestamp addSeconds(EnigmaTimestamp ts, long seconds){
    	return new EnigmaTimestamp(ts.getTime()+seconds*1000);
    }
}
