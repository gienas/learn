package pl.ene.weather.connectors.wunderground;

import javax.enterprise.context.Dependent;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.fasterxml.jackson.databind.ObjectMapper;

import pl.ene.weather.connectors.client.HttpGetClient;
import pl.ene.weather.connectors.wunderground.domain.WeatherWU;
import pl.ene.weather.exception.ClientException;
import pl.ene.weather.exception.ServerException;
@Dependent
public class WundergroundClient extends HttpGetClient {
    
    private static final String PROBLEMS_DURING_JSON_DESERIALIZATION_WEATHER_OR_OBSERVATION_IS_NULL = "Problems during json deserialization weather or observation is null";
	private final Logger logger = LoggerFactory.getLogger(this.getClass());
    
    public WeatherWU getWeather(String url) throws ServerException, ClientException
    {
        final WeatherWU ret;
        final String json=this.getRESTData(url);
        ObjectMapper mapper=  new ObjectMapper();
        try {
            ret=mapper.readValue(json,WeatherWU.class);
        }
        catch (Exception e) {
            this.logger.error("cannot mapped attributes from JSON format to WeatherWU",e);
            throw new ServerException(e);
        }

        if ( ret == null || ret.getCurrentObservation() == null )
        {
        	this.logger.error(PROBLEMS_DURING_JSON_DESERIALIZATION_WEATHER_OR_OBSERVATION_IS_NULL);
        	throw new ServerException(PROBLEMS_DURING_JSON_DESERIALIZATION_WEATHER_OR_OBSERVATION_IS_NULL);
        }	
        
        return ret;
        
    }

}
