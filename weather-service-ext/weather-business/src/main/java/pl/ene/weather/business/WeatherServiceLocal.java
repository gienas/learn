package pl.ene.weather.business;

import java.util.List;

import javax.ejb.Local;

import pl.ene.weather.domain.PlaceDO;
import pl.ene.weather.domain.WeatherDO;


/**
 * Weather service. Provides the main functionality of this application.
 * @author Landic
 *
 */
@Local
public interface WeatherServiceLocal {
    /**
     * Get weather for giving places. In normal situation the weather observation should not be older then two hours.
     * <p>
     * The weather is returned only for supported locations (this is configurable)
     * </p>
     * 
     * @param places List of places. If the list is empty or parameter is <code>null</code>, the weather for all the
     *            supperted locations is returned.
     * @return List of current weather observation for the given places. The result is never <code>null</code>, if no
     *         weather then an empty list is returned.
     */
    List<WeatherDO> getWeather(List<PlaceDO> places);
}
