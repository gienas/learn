package com.tieto.weatherservice.controller;

import java.util.Random;

import javax.faces.bean.ManagedBean;
import javax.inject.Inject;

import com.tieto.weatherservice.Place;
import com.tieto.weatherservice.Weather;
import com.tieto.weatherservice.WeatherCache;



@ManagedBean
public class WeatherBean {

	Place place = new Place();
	Weather weather = new Weather();

	@Inject
	WeatherCache cache;
	
	public Place getPlace() {
		return place;
	}

	public void setPlace(Place place) {
		this.place = place;
	}

	public Weather getWeather() {
		return weather;
	}

	public void setWeather(Weather weather) {
		this.weather = weather;
	}
//
	public void call() {
		System.out.println("-----------------------------------");
		if (place == null) {
			System.out.println("Place == null");
			return;
		}
		Weather w = cache.getFromCache(place, 1);
		if (w == null)
		{
			//FIXME random
			System.out.println("Not found in cache for id " + place.getId());
			Random generator = new Random(); 
			int temp = generator.nextInt(10) + 1;
			w =  new Weather(temp);
			System.out.println("Set for place " + place.getId() + " temperature " + temp);
			cache.putToCache(place, w);
		}	
		
		weather = w;
		
	}

}
