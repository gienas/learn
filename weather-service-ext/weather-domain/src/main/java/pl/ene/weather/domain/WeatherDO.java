package pl.ene.weather.domain;

import java.time.Duration;
import java.time.Instant;

public class WeatherDO {
    private ObservationDO observation;
    private PrecipitationDO precipitation;
    private WindDO wind;
    private HumidityDO humidity;
    private TemperatureDO temperature;
    private String description;
    private PlaceDO place;
    /**
     * time stamp of when this object was created. This is not the time stamp of observation,
     * the observation might be older as received from weather provider.
     */
    private final Instant timeStamp;

    /**
     * This constructor exists mainly for unit testability of this class. It should not be called otherwise.
     * @param timeStamp
     */
    WeatherDO(Instant timeStamp) {
        this.timeStamp = timeStamp;
    }
    public WeatherDO() {
        this(Instant.now());
    }

    public PlaceDO getPlace() {
        return this.place;
    }

    public void setPlace(final PlaceDO place) {
        this.place = place;
    }

    public ObservationDO getObservation() {
        return this.observation;
    }

    public void setObservation(final ObservationDO observation) {
        this.observation = observation;
    }

    public PrecipitationDO getPrecipitation() {
        return this.precipitation;
    }

    public void setPrecipitation(final PrecipitationDO precipitation) {
        this.precipitation = precipitation;
    }

    public WindDO getWind() {
        return this.wind;
    }

    public void setWind(final WindDO wind) {
        this.wind = wind;
    }

    public HumidityDO getHumidity() {
        return this.humidity;
    }

    public void setHumidity(final HumidityDO humidity) {
        this.humidity = humidity;
    }

    public TemperatureDO getTemperature() {
        return this.temperature;
    }

    public void setTemperature(final TemperatureDO temperature) {
        this.temperature = temperature;
    }

    public String getDescription() {
        return this.description;
    }

    public void setDescription(final String description) {
        this.description = description;
    }

    public boolean isOlderThan(Duration maxAge) {
        if (maxAge == null) {
            throw new IllegalArgumentException("Duration must not be null");
        }

        final Instant currentTime = Instant.now();
        final Duration age = Duration.between(this.timeStamp, currentTime);
        return age.compareTo(maxAge) > 0;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((this.place == null) ? 0 : this.place.hashCode());
        result = prime * result + ((this.timeStamp == null) ? 0 : this.timeStamp.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (this.getClass() != obj.getClass()) {
            return false;
        }
        final WeatherDO other = (WeatherDO) obj;
        if (this.place == null) {
            if (other.place != null) {
                return false;
            }
        }
        else if (!this.place.equals(other.place)) {
            return false;
        }
        if (this.timeStamp == null) {
            if (other.timeStamp != null) {
                return false;
            }
        }
        else if (!this.timeStamp.equals(other.timeStamp)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return String.format(
                "WeatherDO [observation=%s, precipitation=%s, wind=%s, humidity=%s, temperature=%s, description=%s, place=%s]",
                this.observation, this.precipitation, this.wind, this.humidity, this.temperature, this.description,
                this.place);
    }

    public Instant getTimeStamp() {
        return this.timeStamp;
    }
}
