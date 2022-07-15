package sk.best.newtify.api.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.v3.oas.annotations.media.Schema;

import javax.annotation.Generated;
import javax.validation.Valid;
import java.io.Serializable;
import java.util.Objects;

/**
 * WeatherDTO
 */

@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2022-07-15T09:45:25.816511600+03:00[Europe/Athens]")
public class WeatherDTO implements Serializable {

  private static final long serialVersionUID = 1L;

  @JsonProperty("uuid")
  private String uuid;

  @JsonProperty("country")
  private String country;

  @JsonProperty("longtitude")
  private Double longtitude;

  @JsonProperty("latitude")
  private Double latitude;

  @JsonProperty("temperature")
  private Double temperature;

  @JsonProperty("main")
  private String main;


  public WeatherDTO uuid(String uuid) {
    this.uuid = uuid;
    return this;
  }

  /**
   * Get uuid
   *
   * @return uuid
   */

  @Schema(name = "uuid", required = false)
  public String getUuid() {
    return uuid;
  }

  public void setUuid(String uuid) {
    this.uuid = uuid;
  }


  public String getCountry() {
    return country;
  }

  public void setCountry(String country) {
    this.country = country;
  }

  public Double getLongtitude() {
    return longtitude;
  }

  public void setLongtitude(Double longtitude) {
    this.longtitude = longtitude;
  }

  public Double getLatitude() {
    return latitude;
  }

  public void setLatitude(Double latitude) {
    this.latitude = latitude;
  }

  public Double getTemperature() {
    return temperature;
  }

  public void setTemperature(Double temperature) {
    this.temperature = temperature;
  }

  public String getMain() {
    return main;
  }

  public void setMain(String main) {
    this.main = main;
  }

  @Override
  public String toString() {
    return super.toString();
  }
}