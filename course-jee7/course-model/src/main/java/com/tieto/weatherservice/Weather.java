package com.tieto.weatherservice;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "weather")
public class Weather {
	
	public Weather() {
		super();
		// TODO Auto-generated constructor stub
		temperature=0;
	}

	public Weather(Integer temperature) {
		super();
		this.temperature = temperature;
	}

	private Integer temperature = 0;
	
	public Integer getTemperature() {
		return temperature;
	}
	
	public void setTemperature(Integer temperature) {
		this.temperature = temperature;
	}

	@Override
	public String toString() {
		return "Weather [temperature=" + temperature + "]";
	}
	
	
}
