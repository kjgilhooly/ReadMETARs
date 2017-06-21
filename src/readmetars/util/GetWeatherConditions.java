package readmetars.util;

import java.util.Hashtable;

public class GetWeatherConditions
{

	public static String[] getData()
	{

		String stationsToRequest[] =
		{
				"KDFW", "KUKT", "KHDO", "KDAY"
		};
		String results[] =
		{
				"none", "none", "none", "none", "none", "none", "none", "none"
		};
		try
		{
			int x = 0; 
			for (int stn = 0; stn < stationsToRequest.length; stn++)
			{
				String station = stationsToRequest[stn];
				//
				@SuppressWarnings("rawtypes")
				Hashtable currConditions = METAR_Processor
						.getCurrentConditions(station);
				if (currConditions != null)
				{
					// Enumeration keys = currConditions.keys();
					float temp_c = 0.0f;
					float temp_f = 0.0f;
					temp_c = Float.parseFloat((String) currConditions
							.get("temp_c"));
					temp_f = 9 / 5 * temp_c + 32;
					results[x++] = (currConditions.get("station_id") + " "
							+ String.valueOf(temp_f) + " ("
							+ String.valueOf(temp_c) + ")");
					results[x++] = (String) currConditions.get("raw_text");

				} else
					System.out.println("No readings.");
			}
			//
		} catch (Exception e)
		{
			e.printStackTrace();
		}
		return results; 
	}
}
