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
import lombok.NonNull;
import org.springframework.data.util.CastUtils;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.Map;

public class JokeConnectorService {
    private static final String JOKE_API_URL = "https://icanhazdadjoke.com/";

    private final RestTemplate restTemplate = new RestTemplate();

    public String retrieveJoke() {
        try {
            RestTemplate restTemplate = new RestTemplate();

            HttpHeaders httpHeaders = new HttpHeaders();
            httpHeaders.add("Accept", "application/json");

            HttpEntity httpEntity = new HttpEntity(httpHeaders);
            ResponseEntity<Map> responseJoke =
                    restTemplate.exchange(JOKE_API_URL, HttpMethod.GET, httpEntity, Map.class);

            return responseJoke.getBody().get("joke").toString();
        } catch (Exception e) {
            return "Wrong";
        }
    }
}
