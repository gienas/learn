package pl.ene.controllers;

import java.util.ArrayList;
import java.util.List;

import javax.enterprise.context.RequestScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;

import pl.ene.weather.business.WeatherServiceLocal;
import pl.ene.weather.domain.PlaceDO;
import pl.ene.weather.domain.WeatherDO;

@RequestScoped
@Named
public class WeatherBean {

	@Inject
	private WeatherServiceLocal service;
	
	private String city;
	private String country;
	private WeatherDO weather;
	
	public void showWeather()
	{
		System.out.println(city);
		System.out.println(country);
		if ( city == null ) return;
		List<PlaceDO> inputList = new ArrayList<>();
		PlaceDO placeDO = new PlaceDO();
		placeDO.setCity(city);
		placeDO.setCountry(country);
		inputList.add(placeDO);
		
		List<WeatherDO> outputList =  service.getWeather(inputList);
		if ( outputList.size() == 0)
		{
			System.out.println("Problems !!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
			FacesContext context = FacesContext.getCurrentInstance();
	        context.addMessage("city", new FacesMessage("Some problems occured, please check city name or try to add country name"));
	        return;
		}	
		weather = outputList.get(0);
		System.out.println(weather);
	}
	
	
	

	public WeatherDO getWeather() {
		return weather;
	}




	public void setWeather(WeatherDO weather) {
		this.weather = weather;
	}




	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	
	
}
