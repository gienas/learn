package com.tieto.weatherservice;

import java.util.Date;

public interface WeatherCache {

	public void putToCache(Place place, Weather weather);

	
	public void putToCache(Place place, Weather weather, Date time);
	
	/**
	 * 
	 * @param place
	 * @param dataThresholdAgeInMinuts
	 * @return Weather when time to live of data in cache =< dataThresholdAgeInMinuts otherwise null
	 */
	public Weather getFromCache( Place place, Integer dataThresholdAgeInMinuts);
	
	public void putToCacheWellKnownPlaces();
}