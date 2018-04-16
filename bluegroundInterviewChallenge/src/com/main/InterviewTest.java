package com.main;

import java.text.SimpleDateFormat;
import java.util.Date;
import com.models.HistoryResponse;

public class InterviewTest {

	private static String defaultHistoryDateStr = "30/10/2017";
	private static String defaultStateCity = "NY/New_York";
	
	public static void main(String[] args)
	{		
		SimpleDateFormat df = new SimpleDateFormat ("dd/MM/yyyy"); 
		String input = args.length == 0 ? defaultHistoryDateStr : args[0]; 
	
		try {
			Date dateForHistory = df.parse(input); // Parsing Date String to Date Object 
			
			WeatherRequests wr = new WeatherRequests();
			HistoryResponse history = wr.fetchHistoryForDateCity(dateForHistory, defaultStateCity); // Fetching the history for the specifying date
			
			Metrics metrics = new Metrics(history);  			// Calculate Metrics for the given history date
			metrics.toFile();									// Export to file in csv format 
			
			// Print Metrics to console too
			System.out.println("Calculated Metrics for " + df.format(dateForHistory));
			System.out.println("Max percentage humidity : " + metrics.getMaxhumidity());
			System.out.println("Max Temp in C : " + metrics.getMaxtempm());
			System.out.println("Min Temp in C : " + metrics.getMintempm());
			System.out.println("Precipitation in mm : " + metrics.getPrecipm());
			
		} catch (Exception ex) { 
			ex.printStackTrace();
		}
	
	}

}
