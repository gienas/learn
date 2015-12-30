package com.tieto.weatherservice;

import javax.ejb.Local;
import javax.ejb.Remote;

@Remote
public interface WeatherServiceRemote {
	
	Weather getWeather(Place place);
}
