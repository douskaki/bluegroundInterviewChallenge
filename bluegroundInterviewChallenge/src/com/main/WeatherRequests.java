package com.main;

import java.io.InputStreamReader;
import java.io.Reader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.Date;
import com.models.HistoryResponse;

public class WeatherRequests {
	
	//http://api.wunderground.com/api/APIKEY/history_YYYYMMDD/q/NY/New_York.json
	//http://api.wunderground.com/api/APIKEY/almanac/q/CA/San_Francisco.json
	private static String API_KEY = "c97f52c6ed28912d";
	private static String baseUrl = "http://api.wunderground.com/api/" + API_KEY + "/";
	private static boolean loadFromApi = true;
	
	public HistoryResponse fetchHistoryForDateCity(Date date, String city) throws Exception {
		SimpleDateFormat dfApi = new SimpleDateFormat("yyyyMMdd"); 
		return fetchHistoryForDateCity(dfApi.format(date), city);
	}
	
	public HistoryResponse fetchHistoryForDateCity(String dateStr, String city) throws Exception {
		String url = baseUrl + "history_" + dateStr + "/q/" + city + ".json";
		String json = loadFromApi ? executeGetRequest(url) : Helpers.ReadJsonFile("history.json");
		HistoryResponse historyResponse = new HistoryResponse().fromJson(json);
		return historyResponse;
	}

	public String executeGetRequest(String urlStr) throws Exception {
		
		HttpURLConnection urlConnection = null;
		
		try {
			URL url = new URL(urlStr);
			urlConnection = (HttpURLConnection)url.openConnection();
			Reader reader = new InputStreamReader(urlConnection.getInputStream());
			return Helpers.readableJSON(reader);
		} catch (Exception ex) {
			throw ex;
		} finally {
			urlConnection.disconnect();
		}
	}

}
