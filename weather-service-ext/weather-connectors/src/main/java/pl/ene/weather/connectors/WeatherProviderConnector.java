package pl.ene.weather.connectors;

import pl.ene.weather.domain.PlaceDO;
import pl.ene.weather.domain.WeatherDO;
import pl.ene.weather.exception.ClientException;
import pl.ene.weather.exception.ServerException;

public interface WeatherProviderConnector {


    /**
     * Get current weather conditions in the given  places from external weather provider, such as WUNDERGROUND or YR.NO
     * <p>
     *
     * @param place Place for which we want to get the current weather conditions. Must not be <code>null</code>.
     * @return  Current weather condition in the given place, as returned from the weather provider
     *
     * @throws  ClientException when the request was somehow  invalid and not recognized by the provider
     * @throws  ServerException when the server cannot process the request at the moment
     */
    WeatherDO getWeather(PlaceDO place) throws ClientException, ServerException;
}
