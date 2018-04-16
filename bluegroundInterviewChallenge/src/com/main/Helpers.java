package com.main;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.Reader;

public class Helpers {

	public static String readableJSON(Reader reader) throws Exception {
		StringBuffer jsonStr = new StringBuffer();
		
		BufferedReader rd = new BufferedReader(reader);
		
		String inputLine;
		while ((inputLine = rd.readLine()) != null) {
			jsonStr.append(inputLine);
		}
		rd.close();
		
		return jsonStr.toString();
	}
	
	public static String ReadJsonFile(String filename) throws Exception {
		try(Reader reader = new InputStreamReader(Helpers.class.getResourceAsStream("/" + filename))){
        	return Helpers.readableJSON(reader);
        }
    }

	
}
