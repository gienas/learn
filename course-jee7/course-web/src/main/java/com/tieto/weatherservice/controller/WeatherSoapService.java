package com.tieto.weatherservice.controller;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.jws.WebService;
import javax.ws.rs.DefaultValue;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.tieto.weatherservice.Place;
import com.tieto.weatherservice.Weather;
import com.tieto.weatherservice.WeatherService;
import com.tieto.weatherservice.WeatherServiceLocal;

import pl.ene.model.rest.Order;
import pl.ene.model.rest.Orders;
import pl.ene.web.controller.OrderEntryService;
import pl.ene.web.controller.OrderEntrySoap;

@Stateless
@WebService
public class WeatherSoapService {

	@Inject
	private WeatherServiceLocal weatherService;

	public Weather getWeather(Long placeId) {
		return weatherService.getWeather(new Place(Long.toString(placeId)));

	}
}