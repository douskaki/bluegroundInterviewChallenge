package com.models;

public class Observation {

    public Date date;
    public Utcdate utcdate;
    public String tempm;
    public String tempi;
    public String dewptm;
    public String dewpti;
    public String hum;
    public String wspdm;
    public String wspdi;
    public String wgustm;
    public String wgusti;
    public String wdird;
    public String wdire;
    public String vism;
    public String visi;
    public String pressurem;
    public String pressurei;
    public String windchillm;
    public String windchilli;
    public String heatindexm;
    public String heatindexi;
    public String precipm;
    public String precipi;
    public String conds;
    public String icon;
    public String fog;
    public String rain;
    public String snow;
    public String hail;
    public String thunder;
    public String tornado;
    public String metar;
	
    public Double getHum() {
		return Double.parseDouble(hum);
	}
    
    public double getTempm() {
    	return Double.parseDouble(tempm);
    }
    
    public double getPrecipm() {
    	return Double.parseDouble(precipm);
    }
    
}
