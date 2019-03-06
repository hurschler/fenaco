package com.fenaco.ua.ibm.weather;

import java.util.Arrays;
import java.util.List;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.http.client.support.BasicAuthenticationInterceptor;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fenaco.ua.ibm.weather.model.Forecast;
import com.fenaco.ua.ibm.weather.model.Weather;

/**
 * 1. Account auf Bluemix einrichten // 2. Weather API analysieren // 3.
 * Credantials beziehen (für User, PW) // 4. Aus dem JSON resultat die Java
 * Model Klassen generieren (http://www.jsonschema2pojo.org/)
 * 
 * Beschreibung
 * https://console.bluemix.net/docs/services/Weather/weather_rest_apis.html
 * 
 **/

@SpringBootApplication
public class WeatherApplication implements CommandLineRunner {

    static final String URL_LOCATION = "https://twcservice.eu-gb.mybluemix.net/rest-api/#!/Daily_Forecast/v1geofcstdaily3";
    static final String URL_WEATHER_API = "https://twcservice.eu-gb.mybluemix.net/api/weather/v1/location/plz:4:CH/forecast/daily/3day.json?language=de-CH&units=m";

    public static void main(String[] args) {
        SpringApplication.run(WeatherApplication.class, args);

    }

    @Override
    public void run(String... args) throws Exception {

        List<String> argumentList = Arrays.asList(args);
        String plz = argumentList.get(0);
        String weatherUrl = URL_WEATHER_API.replace("plz", plz);
        HttpHeaders headers = new HttpHeaders();
        headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
        headers.setContentType(MediaType.APPLICATION_JSON);
        MultiValueMap<String, String> map = new LinkedMultiValueMap<>();
        final HttpEntity<MultiValueMap<String, String>> entity = new HttpEntity<>(map, headers);
        RestTemplate restTemplate = new RestTemplate();
        restTemplate.getInterceptors().add(new BasicAuthenticationInterceptor("4144a6d0-7ed6-4ecc-8134-a7961f17caa2", "7T6bF2un5s"));
        ResponseEntity<String> responseEntity = restTemplate.exchange(weatherUrl, HttpMethod.GET, entity, String.class);
        String authRequest = restTemplate.getForObject(URL_LOCATION, String.class);
        // Read JSON and populate java objects
        ObjectMapper mapper = new ObjectMapper();
        Weather weather = mapper.readValue(responseEntity.getBody(), Weather.class);
        List<Forecast> forecasts = weather.getForecasts();
        printForecasts(forecasts);
    }

    public void printForecasts(List<Forecast> forecasts) {
        for (Forecast forecast : forecasts) {
            System.out.println("Ausblick für: " + forecast.getDay().getLongDaypartName());
            System.out.println("  Beschreibung: " + forecast.getDay().getPhrase32char());
            System.out.println("  Beschreibung: " + forecast.getDay().getNarrative());
            System.out.println("  Temperatur max: " + forecast.getMaxTemp());
            System.out.println("  Temperatur min: " + forecast.getMinTemp());
            System.out.println("  Temperatur min: " + forecast.getMinTemp());

        }
    }

}
