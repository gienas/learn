package pl.ene.weather.connectors.wunderground;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.util.Locale;

import javax.enterprise.context.ApplicationScoped;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import pl.ene.weather.connectors.wunderground.domain.CurrentObservationWU;
import pl.ene.weather.connectors.wunderground.domain.DisplayLocationWU;
import pl.ene.weather.connectors.wunderground.domain.WeatherWU;
import pl.ene.weather.domain.DirectionDO;
import pl.ene.weather.domain.HumidityDO;
import pl.ene.weather.domain.ObservationDO;
import pl.ene.weather.domain.PlaceDO;
import pl.ene.weather.domain.PrecipitationDO;
import pl.ene.weather.domain.TemperatureDO;
import pl.ene.weather.domain.WeatherDO;
import pl.ene.weather.domain.WindDO;

@ApplicationScoped
public class MapperFromJson {
    private final Logger LOG = LoggerFactory.getLogger(this.getClass());
    private final SimpleDateFormat TIME_FORMAT = new SimpleDateFormat("EEE, dd MMM yyyy HH:mm:ss Z", Locale.ENGLISH);;

    public WeatherDO mapJson2Domain(WeatherWU weather) {
        final WeatherDO weatherDO = new WeatherDO();
        final CurrentObservationWU observation = weather.getCurrentObservation();
        System.out.println("observation "  + observation);
        
        weatherDO.setHumidity(this.mapJson2HumidityDO(observation.getRelativeHumidity()));
        weatherDO.setObservation(this.mapJson2ObservationDO(observation));
        weatherDO.setPlace(this.mapJson2PlaceDO(observation.getDisplayLocation()));
        weatherDO.setPrecipitation(this.mapJson2PrecipitationDO(observation));
        weatherDO.setTemperature(this.mapJson2TemperatureDO(observation.getTempC()));
        weatherDO.setWind(this.mapJson2WindDO(observation));

        return weatherDO;
    }

    private WindDO mapJson2WindDO(CurrentObservationWU currentObservation) {
        final WindDO windDO = new WindDO();
        final Integer windKph = currentObservation.getWindKph();
        final String windDir = currentObservation.getWindDir();
        final Integer windDirection = currentObservation.getWindDegrees();
        windDO.setSpeedKmh(windKph);
        windDO.setDescription(this.createWindDescription(windKph, windDir));
        windDO.setDirectionDO(this.mapJson2DirectionDO(windDirection));

        return windDO;
    }

    DirectionDO mapJson2DirectionDO(final Integer windDirection) {
        final DirectionDO direction = new DirectionDO();
        if (windDirection == null) {
            direction.setDirectionValue(0);
            return direction;
        }
        direction.setDirectionValue(windDirection.intValue());

        return direction;
    }

    String createWindDescription(Integer windKph, String windDir) {
        final String description = "Speed of wind " + windKph + " from " + windDir;

        return description;
    }

    private TemperatureDO mapJson2TemperatureDO(Double temperature) {
        final TemperatureDO temperatureDO = new TemperatureDO();
        temperatureDO.setCelsiusValue(temperature.floatValue());

        return temperatureDO;
    }

    private PrecipitationDO mapJson2PrecipitationDO(CurrentObservationWU currentObservation) {
        final PrecipitationDO precipitationDO = new PrecipitationDO();

        precipitationDO.setValueMmHod(this.parseString2Float(currentObservation.getPrecip1hrMetric()));
        precipitationDO.setValueMmToday(this.parseString2Float(currentObservation.getPrecipTodayMetric()));

        return precipitationDO;
    }

    /**
     * convert String represents amount of precipitation to Float from external weather service provider. Like zero
     * precipitation are expected from WU \"--\",\"0\",\"negative number\"
     *
     * @param representing amount of precipitation from provider
     * @return Current precipitation is zero or greater value
     *
     */
    Float parseString2Float(String stringValue) {
        if (stringValue == null) {
            return null;
        }
        if ("--".equals(stringValue)) {
            return 0.0f;
        }
        final Float floatValue;
        try {
            floatValue = Float.parseFloat(stringValue);

            return floatValue;
        }
        catch (final NumberFormatException e) {
            this.LOG.error("Cannot parse String \"{}\" to Float: {} ", stringValue, e);

            return null;
        }
    }

    private PlaceDO mapJson2PlaceDO(DisplayLocationWU displayLocation) {
        final PlaceDO placeDO = new PlaceDO();
        placeDO.setCity(displayLocation.getCity());
        placeDO.setCountry(displayLocation.getCountry());

        return placeDO;
    }

    private ObservationDO mapJson2ObservationDO(CurrentObservationWU currentObservation) {
        final ObservationDO observationDO = new ObservationDO();
        observationDO.setPlace(currentObservation.getObservationLocation().getFull());
        observationDO.setTime(this.parseString2Instant(currentObservation.getObservationTimeRfc822()));

        return observationDO;
    }

    private Instant parseString2Instant(String observationTimeRfc822) {
        final Instant dateInstant = Instant.ofEpochMilli(this.parse2DateInMili(observationTimeRfc822));

        return dateInstant;
    }

    Long parse2DateInMili(String timeInRFC822) {
        if (timeInRFC822 == null) {
            return null;
        }
        try {
            final Long dateInMili = this.TIME_FORMAT.parse(timeInRFC822.trim()).getTime();

            return dateInMili;
        }
        catch (final ParseException e) {
            this.LOG.error("Cannot parse String \"{}\" to long: {} ", timeInRFC822, e);

            return null;
        }
    }

    private HumidityDO mapJson2HumidityDO(String relativeHumidity) {
        final HumidityDO humidityDO = new HumidityDO();
        humidityDO.setHumValue(Float.parseFloat(relativeHumidity.replace("%", "")));

        return humidityDO;
    }

}
