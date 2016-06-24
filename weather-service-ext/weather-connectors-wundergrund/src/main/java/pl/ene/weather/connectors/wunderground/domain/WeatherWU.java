
package pl.ene.weather.connectors.wunderground.domain;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.Generated;

import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

/**
 * @author Landic
 *
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@Generated("org.jsonschema2pojo")
@JsonPropertyOrder({
    "current_observation"
})
public class WeatherWU {

    @JsonProperty("current_observation")
    private CurrentObservationWU currentObservation;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    /**
     * 
     * @return
     *     The currentObservation
     */
    @JsonProperty("current_observation")
    public CurrentObservationWU getCurrentObservation() {
        return this.currentObservation;
    }

    /**
     * 
     * @param currentObservation
     *     The current_observation
     */
    @JsonProperty("current_observation")
    public void setCurrentObservation(CurrentObservationWU currentObservation) {
        this.currentObservation = currentObservation;
    }

   

    @JsonAnyGetter
    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    @JsonAnySetter
    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

    @Override
    public String toString() {
        return String.format("%s", this.getCurrentObservation());
    }

}
