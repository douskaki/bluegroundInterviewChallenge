package com.main;

import java.io.BufferedWriter;
import java.io.FileOutputStream;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.nio.charset.StandardCharsets;
import com.models.HistoryResponse;
import com.models.Observation;

public class Metrics {
	private double maxhumidity;
	private double maxtempm;
	private double mintempm;
	private double precipm;
	
	public Metrics() {
		super();
		this.maxhumidity = 0.0;
		this.maxtempm = 0.0;
		this.mintempm = 0.0;
		this.precipm = 0.0;
	}
	
	public double getMaxhumidity() {
		return maxhumidity;
	}

	public double getMaxtempm() {
		return maxtempm;
	}

	public double getMintempm() {
		return mintempm;
	}

	public double getPrecipm() {
		return precipm;
	}

	public Metrics(HistoryResponse historyResponse) {
		super();
		for (Observation obs: historyResponse.history.getObservations()) {
			maxhumidity = max(obs.getHum(), maxhumidity);
	    	maxtempm = max(obs.getTempm(), maxtempm);
	    	mintempm = min(obs.getTempm(), mintempm);
	    	precipm += calculatePrecipitation(obs.getPrecipm());
        }
	}

	public static double max(double newValue, double oldValue) {
		return (newValue > oldValue) ? newValue : oldValue;
	}
	
	public static double min(double newValue, double oldValue) {
		return (newValue < oldValue) ? newValue : oldValue;
	}
	
	public static double calculatePrecipitation(double precipm) {
		return (precipm < 0.0) ? 0.0 : precipm;
	}
	
	@Override
	public String toString() {
		return maxhumidity + "," + maxtempm + "," + mintempm + "," + precipm;
	}
	
	public void toFile() throws Exception {
		Writer writer = new BufferedWriter(new OutputStreamWriter(new FileOutputStream("output.csv"), StandardCharsets.UTF_8));
		writer.write("maxhumidity,maxtempm,mintempm,precipm\n");
		writer.write(this.toString());
		writer.close();
	}
	
	
}
