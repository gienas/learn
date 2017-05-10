package pl.ene.weather.business;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.enterprise.context.Dependent;
import javax.inject.Inject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import pl.ene.weather.business.caching.WeatherCache;
import pl.ene.weather.connectors.WeatherProviderConnector;
import pl.ene.weather.domain.PlaceDO;
import pl.ene.weather.domain.WeatherDO;
import pl.ene.weather.exception.ClientException;
import pl.ene.weather.exception.ServerException;

/**
 * 
 * @author neugeeug
 *
 */
@Dependent
public class WeatherService implements WeatherServiceLocal {

    private final Logger logger = LoggerFactory.getLogger(WeatherService.class);

    @Inject
    private WeatherCache cache;
    @Inject
    private WeatherProviderConnector conector;

	@PostConstruct
	public void init() {
		logger.info(" ---------------- WeatherService constructed ");
	}
	
    @Override
    public List<WeatherDO> getWeather(List<PlaceDO> places) {

        this.logger.info("Call getWeather for place={}, tips={}", places, "have a nice weather");

        final List<WeatherDO> ret = new ArrayList<WeatherDO>();
        for (final PlaceDO place : places) {
            try {
                final WeatherDO weather = this.getWeather(place);

                ret.add(weather);
            }
            catch (final ServerException e) {
                this.logger.error("Server Error", e);
            }
            catch (final ClientException e) {
                this.logger.error("Client Error", e);
            }
        }
        return ret;
    }

    private WeatherDO getWeather(final PlaceDO place) throws ClientException, ServerException {
    	logger.info("Cache provider " + this.cache);
        WeatherDO weather = this.cache.get(place);
        if (weather == null) {
            weather = this.conector.getWeather(place);
            this.cache.put(place, weather);
        }
        return weather;
    }
}
