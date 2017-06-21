package readmetars.util;

import java.util.Hashtable;

public class METAR_Processor 
{
    @SuppressWarnings("rawtypes")
	public static Hashtable getCurrentConditions(String station)
    {
        String URL = "http://aviationweather.gov/adds/dataserver_current/httpparam?dataSource=metars&requestType=retrieve&format=xml&stationString=" + station + "&hoursBeforeNow=1";
         
        METAR_Parser weatherReader = new METAR_Parser(URL);
        if (weatherReader.parse())
            return weatherReader.getWeatherInfo(); 
	    else
		    return null; 	
}
}