package com.models;

import java.util.List;

public class History {

    private Date date;
    private Utcdate utcdate;
    private List<Observation> observations = null;
    private List<Dailysummary> dailysummary = null;

    public Date getDate() {
		return date;
	}

	public Utcdate getUtcdate() {
		return utcdate;
	}

	public List<Observation> getObservations() {
		return observations;
	}

	public List<Dailysummary> getDailysummary() {
		return dailysummary;
	}

}
