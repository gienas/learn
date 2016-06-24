package pl.ene.weather.endpoint;

import java.math.BigDecimal;
import java.time.Instant;
import java.util.ArrayList;
import java.util.Collections;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.enterprise.context.ApplicationScoped;
import javax.xml.datatype.DatatypeConfigurationException;
import javax.xml.datatype.DatatypeFactory;
import javax.xml.datatype.XMLGregorianCalendar;

import pl.ene.weather.domain.DirectionNameDO;
import pl.ene.weather.domain.HumidityDO;
import pl.ene.weather.domain.ObservationDO;
import pl.ene.weather.domain.PlaceDO;
import pl.ene.weather.domain.PrecipitationDO;
import pl.ene.weather.domain.TemperatureDO;
import pl.ene.weather.domain.WeatherDO;
import pl.ene.weather.domain.WindDO;
import pl.ene.weather.exception.ClientException;
import pl.ene.weather.service.types.Direction;
import pl.ene.weather.service.types.GetWeatherInput;
import pl.ene.weather.service.types.GetWeatherOutput;
import pl.ene.weather.service.types.Humidity;
import pl.ene.weather.service.types.Location;
import pl.ene.weather.service.types.Observation;
import pl.ene.weather.service.types.Precipitation;
import pl.ene.weather.service.types.Temperature;
import pl.ene.weather.service.types.Weather;
import pl.ene.weather.service.types.Wind;

@ApplicationScoped
public class WeatherMapper {

    private static final Map<DirectionNameDO, Direction> DIRECTIONS_MAP;
    static {
        final Map<DirectionNameDO, Direction> temporaryMap = new HashMap<>();
        temporaryMap.put(DirectionNameDO.E, Direction.EAST);
        temporaryMap.put(DirectionNameDO.ENE, Direction.EAST_NORTHEAST);
        temporaryMap.put(DirectionNameDO.ESE, Direction.EAST_SOUTHEAST);
        temporaryMap.put(DirectionNameDO.N, Direction.NORTH);
        temporaryMap.put(DirectionNameDO.NE, Direction.NORTHEAST);
        temporaryMap.put(DirectionNameDO.NNE, Direction.NORTH_NORTHEAST);
        temporaryMap.put(DirectionNameDO.NNW, Direction.NORTH_NORTHWEST);
        temporaryMap.put(DirectionNameDO.NW, Direction.NORTHWEST);
        temporaryMap.put(DirectionNameDO.S, Direction.SOUTH);
        temporaryMap.put(DirectionNameDO.SE, Direction.SOUTHEAST);
        temporaryMap.put(DirectionNameDO.SSE, Direction.SOUTH_SOUTHEAST);
        temporaryMap.put(DirectionNameDO.SSW, Direction.SOUTH_SOUTHWEST);
        temporaryMap.put(DirectionNameDO.SW, Direction.SOUTHWEST);
        temporaryMap.put(DirectionNameDO.W, Direction.WEST);
        temporaryMap.put(DirectionNameDO.WNW, Direction.WEST_NORTHWEST);
        temporaryMap.put(DirectionNameDO.WSW, Direction.WEST_SOUTHWEST);
        DIRECTIONS_MAP = Collections.unmodifiableMap(temporaryMap);
    }

    public GetWeatherOutput mapDomain2Xml(final List<WeatherDO> weatherListDomain) throws ClientException {
        final GetWeatherOutput weatherListXML = new GetWeatherOutput();
        for (final WeatherDO weatherDomain : weatherListDomain) {
            final Weather weather = this.mapDomain2Xml(weatherDomain);
            weatherListXML.getWeather().add(weather);
        }
        return weatherListXML;
    }

    public List<PlaceDO> mapXml2Domain(final GetWeatherInput getWeatherInput) {
        final List<PlaceDO> placeListDomain = new ArrayList<>();
        for (final Location xmlLocation : getWeatherInput.getLocations().getLocation()) {
            final PlaceDO mapXmlLocation2Domain = this.mapXml2Domain(xmlLocation);
            placeListDomain.add(mapXmlLocation2Domain);
        }
        return placeListDomain;
    }

    private Weather mapDomain2Xml(final WeatherDO domainWeather) throws ClientException {
        final Weather xmlWeather = new Weather();
        xmlWeather.setCityName(domainWeather.getPlace().getCity());
        xmlWeather.setDescription(domainWeather.getDescription());
        xmlWeather.setTemperature(this.mapDomain2Xml(domainWeather.getTemperature()));
        xmlWeather.setHumidity(this.mapDomain2Xml(domainWeather.getHumidity()));
        xmlWeather.setObservation(this.mapDomain2Xml(domainWeather.getObservation()));
        xmlWeather.setPrecipitation(this.mapDomain2Xml(domainWeather.getPrecipitation()));
        xmlWeather.setWind(this.mapDomain2Xml(domainWeather.getWind()));

        return xmlWeather;
    }

    private Wind mapDomain2Xml(WindDO windDO) {
        final Wind wind = new Wind();
        wind.setSpeed(new BigDecimal(windDO.getSpeedKmh()));
        wind.setDescription(windDO.getDescription());
        wind.setDirection(DIRECTIONS_MAP.get(DirectionNameDO.forDegrees(windDO.getDirectionDO().getDirectionValue())));

        return wind;
    }

    private Precipitation mapDomain2Xml(PrecipitationDO precipitationDO) {
        final Precipitation precipitation = new Precipitation();
        final float valueMmHod = precipitationDO.getValueMmHod();
        precipitation.setArePresent(valueMmHod > 0.01);

        return precipitation;
    }

    private Observation mapDomain2Xml(ObservationDO observationDO) throws ClientException {
        final Observation observation = new Observation();
        observation.setPlaceName(observationDO.getPlace());
        observation.setTime(this.convertInstantToXmlGregorianCalendar(observationDO.getTime()));

        return observation;
    }

    private XMLGregorianCalendar convertInstantToXmlGregorianCalendar(Instant time) throws ClientException {
        final DatatypeFactory dataF;
        try {
            dataF = DatatypeFactory.newInstance();
        }
        catch (final DatatypeConfigurationException e) {
            throw new ClientException("Error calling DatatypeFactory.newInstance(). Call system admin. ", e);
        }
        final GregorianCalendar gregorian = new GregorianCalendar();
        gregorian.setTimeInMillis(time.toEpochMilli());
        final XMLGregorianCalendar xmlGregorian = dataF.newXMLGregorianCalendar(gregorian);

        return xmlGregorian;
    }

    private Humidity mapDomain2Xml(HumidityDO humidityDO) {
        final Humidity humidity = new Humidity();
        humidity.setValue(BigDecimal.valueOf(humidityDO.getHumValue()));

        return humidity;
    }

    private Temperature mapDomain2Xml(TemperatureDO temperature) {
        final Temperature xmlTemperature = new Temperature();
        xmlTemperature.setCValue(new BigDecimal(temperature.getCelsiusValue()));

        return xmlTemperature;
    }

    private PlaceDO mapXml2Domain(Location xmlLocation) {
        final PlaceDO placeDO = new PlaceDO();
        placeDO.setCity(xmlLocation.getCityName());

        return placeDO;
    }
}
