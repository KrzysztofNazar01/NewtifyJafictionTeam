package sk.best.newtify.web.connector;

import lombok.NonNull;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.util.CastUtils;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import sk.best.newtify.api.dto.WeatherDTO;

import java.util.List;
import java.util.Map;

@Slf4j
@Service
public class WeatherConnectorService {
    private static final String OPENWEATHER_API_URL = "https://api.openweathermap.org/data/2.5/weather?lat={lat}&lon={lon}&appid=ed99cdd859b4f09b011c58071fc62c38";

    private final RestTemplate restTemplate = new RestTemplate();

    public double retrieveWeather(@NonNull Double lat,
                                                      @NonNull Double lon) {
        try {
            RestTemplate restTemplate = new RestTemplate();
            ResponseEntity<Map<String, Object>> weatherResponseEntity = CastUtils.cast(
                    restTemplate.getForEntity("https://api.open-meteo.com/v1/forecast" +
                            "?latitude={lat}&longitude={lon}&hourly=temperature_2m", Map.class, lat, lon)
            );
            Map<String, Object> weatherApiParam2DataMap = weatherResponseEntity.getBody();
            Map<String, Object> hourlyMap = CastUtils.cast(weatherApiParam2DataMap.get("hourly"));
            List<Double> temperatures = CastUtils.cast(hourlyMap.get("temperature_2m"));
            System.out.println("Current temperature is: " + temperatures.get(0));



            return temperatures.get(temperatures.size()-1);
        } catch (Exception e) {
            log.error("ERROR retrieveWeather", e);
            return -100.0;
        }
    }
}
