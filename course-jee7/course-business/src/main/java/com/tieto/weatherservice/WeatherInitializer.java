package com.tieto.weatherservice;

import javax.annotation.PostConstruct;
import javax.ejb.Singleton;
import javax.ejb.Startup;
import javax.ejb.Stateless;

@Singleton
@Startup
public class WeatherInitializer {

	@PostConstruct
	public void init()
	{
		System.out.println( "-- Bean "  + getClass().getName() + " initialized");
	}
	
	
	public void go()
	{
		
	}
}
