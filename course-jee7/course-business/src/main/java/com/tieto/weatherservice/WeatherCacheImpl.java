package com.tieto.weatherservice;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.annotation.PostConstruct;
import javax.ejb.DependsOn;
import javax.ejb.Lock;
import javax.ejb.LockType;
import javax.ejb.Schedule;
import javax.ejb.Singleton;
import javax.ejb.Startup;
import javax.tools.DocumentationTool.Location;
import javax.xml.crypto.Data;

@Singleton
@Startup
@DependsOn("WeatherInitializer")
public class WeatherCacheImpl implements WeatherCache {

	private Map<Place, WeatherCacheEntity> cache = new HashMap<>();
	
	@PostConstruct
	public void init() {
		System.out.println("-- Bean " + getClass().getName() + " initialized");
	}
	@Override
	public void putToCache(Place place, Weather weather) {
		putToCache(place, weather, new Date());
	}
	@Override
	public void putToCache(Place place, Weather weather, Date time) {
		cache.put(place, new WeatherCacheEntity(weather, time));
	}
	
	@Lock(LockType.READ)
	@Override
	public Weather getFromCache(Place place, Integer dataThresholdAgeInMinuts) {
		WeatherCacheEntity entity = cache.get(place);
		if (entity != null) {
			System.out.println(" Found in cache entity" + entity);
			if (entity.isEntityYoungerThan(dataThresholdAgeInMinuts))
				return entity.getWeather();
		}
		return null;
	}

	@Override
	@Schedule(dayOfMonth = "*", dayOfWeek = "*", hour = "*", minute = "*", second = "0")
	public void putToCacheWellKnownPlaces() {
		System.out.println("Put to cache periodicly well known places");

	}

}
