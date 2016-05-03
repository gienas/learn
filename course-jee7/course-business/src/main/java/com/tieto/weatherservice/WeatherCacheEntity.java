package com.tieto.weatherservice;

import java.util.Calendar;
import java.util.Date;

import javax.xml.crypto.Data;

public class WeatherCacheEntity {

	public WeatherCacheEntity(Weather weather, Date time) {
		super();
		this.weather = weather;
		this.saveDate = time;
	}


	private Weather weather;
	private Date saveDate;
	
	public Weather getWeather() {
		return weather;
	}
	public void setWeather(Weather weather) {
		this.weather = weather;
	}
	public Date getSaveDate() {
		return saveDate;
	}
	public void setSaveDate(Date saveDate) {
		this.saveDate = saveDate;
	}
	
	
	public Boolean isEntityYoungerThan( Integer minuts )
	{
		if ( saveDate == null)
			return null;
		Calendar calEnt = Calendar.getInstance();
		calEnt.setTime(saveDate);
		calEnt.add(Calendar.MINUTE, minuts);
		Calendar curr = Calendar.getInstance();
		boolean stale = calEnt.getTime().before( curr.getTime());
		System.out.println("Check if stale ("+minuts+") result = " + stale );
		return !stale;
		
	}
	
	@Override
	public String toString() {
		return "WeatherCacheEntity [weather=" + weather + ", saveDate=" + saveDate + "]";
	}
	
	
	
}
