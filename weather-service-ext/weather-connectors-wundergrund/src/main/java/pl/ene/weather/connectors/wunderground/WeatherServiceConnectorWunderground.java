package pl.ene.weather.connectors.wunderground;

import javax.enterprise.context.Dependent;
import javax.inject.Inject;

import pl.ene.weather.connectors.WeatherProviderConnector;
import pl.ene.weather.connectors.wunderground.domain.WeatherWU;
import pl.ene.weather.domain.PlaceDO;
import pl.ene.weather.domain.WeatherDO;
import pl.ene.weather.exception.ClientException;
import pl.ene.weather.exception.ServerException;

@Dependent
public class WeatherServiceConnectorWunderground implements WeatherProviderConnector {

    private static final String CONNECTOR_URL_TEMPLATE = "http://api.wunderground.com/api/CHANGEIT/conditions/q/#COUNTRY#/#CITY#.json";

    @Inject
    private WundergroundClient client;

    @Inject
    private MapperFromJson mapper;

    @Override
    public WeatherDO getWeather(PlaceDO place) throws ClientException, ServerException {
        
    	// prepapre URL
        String url = CONNECTOR_URL_TEMPLATE.replace("#COUNTRY#", place.getCountry() == null ? "": place.getCountry()).replace("#CITY#", place.getCity());
        // call client
        WeatherWU weather = this.client.getWeather(url);
        // map to domain
        WeatherDO weatherDomain = this.mapper.mapJson2Domain(weather);

        return weatherDomain;
    }
}
