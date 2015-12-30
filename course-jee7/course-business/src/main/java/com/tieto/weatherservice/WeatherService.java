package com.tieto.weatherservice;

import javax.ejb.Schedule;
import javax.ejb.Stateless;

@Stateless
public class WeatherService implements WeatherServiceLocal, WeatherServiceRemote{

	@Override
	public Weather getWeather(Place place) {
		// TODO Auto-generated method stub
		return new Weather(10);
	}

	@Schedule(dayOfMonth="*", dayOfWeek="*", hour="*", minute="*", second="5")
	public void pingWeather() {
		System.out.println("-- Ping Weather ----------------------------------");
		
	}
}
