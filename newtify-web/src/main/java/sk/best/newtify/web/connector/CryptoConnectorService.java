package sk.best.newtify.web.connector;

import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.Map;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;

public class CryptoConnectorService {
    private static final String CRYPTO_API_URL = "https://api.alternative.me/fng";

    private final RestTemplate restTemplate = new RestTemplate();

    public String retrieveCrypto() {
        try {
            RestTemplate restTemplate = new RestTemplate();
            HttpHeaders httpHeaders = new HttpHeaders();
            httpHeaders.add("Accept", "application/json");
            HttpEntity httpEntity = new HttpEntity(httpHeaders);
            ResponseEntity<Map> responseCrypto =
                    restTemplate.exchange(CRYPTO_API_URL, HttpMethod.GET, httpEntity, Map.class);

            String word = responseCrypto.getBody().get("data").toString();
            word = word.substring(2,word.length()-2);
            word = word.substring(31, word.length()-47);
            return word;
        } catch (Exception e) {
            return "Wrong";
        }
    }
}
