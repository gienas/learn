package com.tieto.weatherservice.controller;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;
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
@Path("/weather")
public class WeatherRestService {

	@Inject
	private WeatherServiceLocal weatherService;

	@GET
	@Path("/xml")
	@Produces("application/xml")
	public Weather getWeather(@QueryParam("placeId") @DefaultValue("12345") Long placeId) {
		return weatherService.getWeather(new Place(Long.toString(placeId)));

	}
}