package pl.ene.weather.endpoint;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.jws.WebService;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import pl.ene.weather.business.WeatherService;
import pl.ene.weather.business.WeatherServiceLocal;
import pl.ene.weather.domain.PlaceDO;
import pl.ene.weather.domain.WeatherDO;
import pl.ene.weather.exception.ClientException;
import pl.ene.weather.service.GetWeatherError;
import pl.ene.weather.service.WeatherPortTypeSOAP;
import pl.ene.weather.service.types.GetWeatherInput;
import pl.ene.weather.service.types.GetWeatherOutput;


@WebService(targetNamespace = "http://ene.pl/wheater/service", name = "WeatherPortTypeSOAP")
public class WeatherPortTypeSOAPImpl implements WeatherPortTypeSOAP {

	private final Logger logger = LoggerFactory.getLogger(WeatherPortTypeSOAPImpl.class);

	@Inject
	private WeatherServiceLocal service;

	@Inject
	private WeatherMapper mapper;

	@PostConstruct
	public void init() {
		logger.info("---------------- WeatherPortTypeSOAPImpl constructed");
	}

	@Override
	public GetWeatherOutput getWeather(final GetWeatherInput getWeatherInput) throws GetWeatherError {
		final List<PlaceDO> placeListDomain = this.mapper.mapXml2Domain(getWeatherInput);
		final List<WeatherDO> weatherListDomain = this.service.getWeather(placeListDomain);
		GetWeatherOutput weatherListXml;
		try {
			weatherListXml = this.mapper.mapDomain2Xml(weatherListDomain);
		} catch (ClientException e) {
			throw new GetWeatherError("Problem with handling the request", e);
		}
		
//		try {
//			Thread.currentThread().sleep(1000*5);
//		} catch (InterruptedException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
		
		return weatherListXml;
	}
}
