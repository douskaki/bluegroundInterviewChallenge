package com.models;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class HistoryResponse {

    public Response response;
    public History history;
    
    public HistoryResponse fromJson(String jsonString) {
		Gson gson = new GsonBuilder().create();
		HistoryResponse historyResponse = gson.fromJson(jsonString, HistoryResponse.class);
		return historyResponse;
	}

}
