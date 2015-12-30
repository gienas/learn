package controller.ws;

import javax.annotation.PostConstruct;
import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.jws.WebService;

import business.WeatherServiceLocal;
import domain.Place;
import domain.Weather;

@Stateless
@WebService
public class WeatherSoapService {

	@Inject
	private WeatherServiceLocal weatherService;
	
	@PostConstruct
	public void init()
	{
		System.out.println("-- Bean " + getClass().getName() + " created");
	}

	public Weather getWeather(String placeName) {
		return weatherService.getWeather(new Place(placeName));
	}
	
	
	
}
