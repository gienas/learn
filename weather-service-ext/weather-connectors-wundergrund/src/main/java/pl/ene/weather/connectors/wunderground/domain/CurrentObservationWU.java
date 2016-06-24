
package pl.ene.weather.connectors.wunderground.domain;

import javax.annotation.Generated;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
@Generated("org.jsonschema2pojo")
@JsonPropertyOrder({
    "display_location",
    "observation_location",
    "observation_time_rfc822",
    "observation_epoch",
    "temp_c",
    "relative_humidity",
    "wind_dir",
    "wind_degrees",
    "wind_kph",
    "precip_1hr_metric",
    "precip_today_metric"
})
public class CurrentObservationWU {

    @JsonProperty("display_location")
    private DisplayLocationWU displayLocation;
    @JsonProperty("observation_location")
    private ObservationLocationWU observationLocation;
    @JsonProperty("observation_time_rfc822")
    private String observationTimeRfc822;
    @JsonProperty("observation_epoch")
    private String observationEpoch;
    @JsonProperty("temp_c")
    private Double tempC;
    @JsonProperty("relative_humidity")
    private String relativeHumidity;
    @JsonProperty("wind_dir")
    private String windDir;
    @JsonProperty("wind_degrees")
    private Integer windDegrees;
    @JsonProperty("wind_kph")
    private Integer windKph;
    @JsonProperty("precip_1hr_metric")
    private String precip1hrMetric;
    @JsonProperty("precip_today_metric")
    private String precipTodayMetric;
   
    /**
     * 
     * @return
     *     The displayLocation
     */
    @JsonProperty("display_location")
    public DisplayLocationWU getDisplayLocation() {
        return this.displayLocation;
    }

    /**
     * 
     * @param displayLocation
     *     The display_location
     */
    @JsonProperty("display_location")
    public void setDisplayLocation(DisplayLocationWU displayLocation) {
        this.displayLocation = displayLocation;
    }

    /**
     * 
     * @return
     *     The observationLocation
     */
    @JsonProperty("observation_location")
    public ObservationLocationWU getObservationLocation() {
        return this.observationLocation;
    }

    /**
     * 
     * @param observationLocation
     *     The observation_location
     */
    @JsonProperty("observation_location")
    public void setObservationLocation(ObservationLocationWU observationLocation) {
        this.observationLocation = observationLocation;
    }

    /**
     * 
     * @return
     *     The observationTimeRfc822
     */
    @JsonProperty("observation_time_rfc822")
    public String getObservationTimeRfc822() {
        return this.observationTimeRfc822;
    }

    /**
     * 
     * @param observationTimeRfc822
     *     The observation_time_rfc822
     */
    @JsonProperty("observation_time_rfc822")
    public void setObservationTimeRfc822(String observationTimeRfc822) {
        this.observationTimeRfc822 = observationTimeRfc822;
    }

    /**
     * 
     * @return
     *     The observationEpoch
     */
    @JsonProperty("observation_epoch")
    public String getObservationEpoch() {
        return this.observationEpoch;
    }

    /**
     * 
     * @param observationEpoch
     *     The observation_epoch
     */
    @JsonProperty("observation_epoch")
    public void setObservationEpoch(String observationEpoch) {
        this.observationEpoch = observationEpoch;
    }

    /**
     * 
     * @return
     *     The tempC
     */
    @JsonProperty("temp_c")
    public Double getTempC() {
        return this.tempC;
    }

    /**
     * 
     * @param tempC
     *     The temp_c
     */
    @JsonProperty("temp_c")
    public void setTempC(Double tempC) {
        this.tempC = tempC;
    }

    /**
     * 
     * @return
     *     The relativeHumidity
     */
    @JsonProperty("relative_humidity")
    public String getRelativeHumidity() {
        return this.relativeHumidity;
    }

    /**
     * 
     * @param relativeHumidity
     *     The relative_humidity
     */
    @JsonProperty("relative_humidity")
    public void setRelativeHumidity(String relativeHumidity) {
        this.relativeHumidity = relativeHumidity;
    }

    /**
     * 
     * @return
     *     The windDir
     */
    @JsonProperty("wind_dir")
    public String getWindDir() {
        return this.windDir;
    }

    /**
     * 
     * @param windDir
     *     The wind_dir
     */
    @JsonProperty("wind_dir")
    public void setWindDir(String windDir) {
        this.windDir = windDir;
    }

    /**
     * 
     * @return
     *     The windDegrees
     */
    @JsonProperty("wind_degrees")
    public Integer getWindDegrees() {
        return this.windDegrees;
    }

    /**
     * 
     * @param windDegrees
     *     The wind_degrees
     */
    @JsonProperty("wind_degrees")
    public void setWindDegrees(Integer windDegrees) {
        this.windDegrees = windDegrees;
    }

    
    /**
    * 
    * @return
    * The windKph
    */
    @JsonProperty("wind_kph")
    public Integer getWindKph() {
    return this.windKph;
    }

    /**
    * 
    * @param windKph
    * The wind_kph
    */
    @JsonProperty("wind_kph")
    public void setWindKph(Integer windKph) {
    this.windKph = windKph;
    }
    
    /**
     * 
     * @return
     *     The precip1hrMetric
     */
    @JsonProperty("precip_1hr_metric")
    public String getPrecip1hrMetric() {
        return this.precip1hrMetric;
    }

    /**
     * 
     * @param precip1hrMetric
     *     The precip_1hr_metric
     */
    @JsonProperty("precip_1hr_metric")
    public void setPrecip1hrMetric(String precip1hrMetric) {
        this.precip1hrMetric = precip1hrMetric;
    }

    /**
     * 
     * @return
     *     The precipTodayMetric
     */
    @JsonProperty("precip_today_metric")
    public String getPrecipTodayMetric() {
        return this.precipTodayMetric;
    }

    /**
     * 
     * @param precipTodayMetric
     *     The precip_today_metric
     */
    @JsonProperty("precip_today_metric")
    public void setPrecipTodayMetric(String precipTodayMetric) {
        this.precipTodayMetric = precipTodayMetric;
    }

    @Override
    public String toString() {
        return String.format(
                "%s\n,%s\n,%s\n,%s\n,%s\n,%s\n,%s\n,%s\n,%s\n,%s\n,%s\n",
                this.displayLocation, this.observationLocation, this.observationTimeRfc822, this.observationEpoch, this.tempC, this.relativeHumidity,
                this.windDir, this.windDegrees, this.windKph, this.precip1hrMetric, this.precipTodayMetric);
    }

   
//
//    @JsonAnyGetter
//    public Map<String, Object> getAdditionalProperties() {
//        return this.additionalProperties;
//    }
//
//    @JsonAnySetter
//    public void setAdditionalProperty(String name, Object value) {
//        this.additionalProperties.put(name, value);
//    }

}
