package pl.ene.weather.business.caching;

import java.time.Duration;

import pl.ene.weather.domain.PlaceDO;
import pl.ene.weather.domain.WeatherDO;

/**
 * Cache for Weather entity
 * @author neugeeug
 *
 */
public interface WeatherCache {

	/**
	 * Put weather to cache.
	 * If for given place entity in cache already exists and is younger - cache is not modified
	 *
	 * @param place
	 * @param weather
	 * @return true if cache was modified otherwise false
	 */
	 boolean put(PlaceDO place, WeatherDO weather);


	/**
	 * Get weather entity from cache.
	 *
	 * @param place key for cache entity
	 * @param dataThresholdAge threshold in minutes. Indicate how old entity should be returned.
	 * @return cache entity. If entity is in cache is older than dataThresholdAgeInMinuts that method return <code>null</code>
	 */
	WeatherDO get( PlaceDO place, Duration dataThresholdAge);



	/**
	 * Get weather entity from cache. Configuration time how old entity should be returned can be checked by calling {@link #getDefaultThresholdAge()} .
	 *
	 * @param place
	 * @return Weather or <code>null</code>;
	 */
	WeatherDO get( PlaceDO place );


	/**
	 *
	 * @return
	 */
	Duration getDefaultThresholdAge();

}

