package com.tieto.weatherservice;

import javax.ejb.Local;

@Local
public interface WeatherServiceLocal {
	
	Weather getWeather(Place place);
}
