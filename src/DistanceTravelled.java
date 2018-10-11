
//https://codefights.com/challenge/pEkXSbKejtxLzj82y/

package com.codefights.solutions;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class DistanceTravelled {

	public int traveledDistance(String[] travelLog) {
		int result = 0;
		try {
			for (int index = 1; index < travelLog.length; index++) {
				String source = travelLog[index].replaceAll("\\s+", "+");
				String destination = travelLog[index - 1].replaceAll("\\s+", "+");

				String restUrl = String.format(
						"https://maps.googleapis.com/maps/api/distancematrix/json?units=imperial&origins=%s&destinations=%s&key=AIzaSyBvp-tCXtbujffLc9mnGGuF6zxu9DVZ9lk",
						source, destination);

				URL obj = new URL(restUrl);
				HttpURLConnection con = (HttpURLConnection) obj.openConnection();

				con.setRequestMethod("GET");
				con.setRequestProperty("User-Agent", "Mozilla/5.0");

				BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
				String inputLine;
				StringBuffer response = new StringBuffer();
				while ((inputLine = in.readLine()) != null) {
					if (inputLine.contains("value")) {
						result += Integer.parseInt(inputLine.substring(inputLine.indexOf(":") + 2).trim());
						break;
					}
				}
				in.close();
			}
		} catch (Exception exception) {
			System.out.println(exception.getMessage());
		}
		return result;
	}
}
