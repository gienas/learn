package pl.ene.weather.business.caching;

import java.time.Duration;
import java.util.HashMap;
import java.util.Map;

import javax.ejb.Singleton;

import pl.ene.weather.domain.PlaceDO;
import pl.ene.weather.domain.WeatherDO;

@Singleton
public class WeatherCacheImpl implements WeatherCache{

    private final Map<PlaceDO, WeatherDO> cache = new HashMap<PlaceDO, WeatherDO>();

    private static final Duration DEFAULT_INTERVAL = Duration.ofMinutes(30);

    @Override
    public boolean put(PlaceDO place, WeatherDO weather) {
        if(place == null || weather == null) {
            return false;
        }
        if(this.get(place) != null) {
            this.cache.replace(place, weather);
            return true;
        } else {
            this.cache.put(place, weather);
            return true;
        }
    }

    @Override
    public WeatherDO get(PlaceDO place, Duration dataThresholdAge) {
        if(place == null) {
                return null;
            }
        final WeatherDO weather = this.get(place);

        return weather;
    }

    @Override
    public WeatherDO get(PlaceDO place) {
        if(place == null){
            return null;
        }
        final WeatherDO cachedWeather = this.cache.get(place);
        if(cachedWeather == null){
           return null;
        }
        if (cachedWeather.isOlderThan(DEFAULT_INTERVAL)){
            return null;
        }

        return cachedWeather;

    }

    @Override
    public Duration getDefaultThresholdAge() {
        return this.DEFAULT_INTERVAL;
    }

}
