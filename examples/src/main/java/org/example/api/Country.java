package org.example.api;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.http.*;
import java.time.Duration;

/**
 * Classe per illustrare come utilizzare le API di
 * https://restcountries.com/#endpoints-name
 */
public class Country {
    private final String countryUrl = "https://restcountries.com/v3.1/name";

    public static void main(String[] args) {
        Country c = new Country();
        try {
            System.out.println(c.requestGet("italy"));
        } catch (URISyntaxException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    public String requestGet(String countryName) throws URISyntaxException, IOException, InterruptedException {
        String url = countryUrl + "/" + countryName;
        System.out.println(url);
        HttpRequest request = HttpRequest.newBuilder()
                .uri(new URI(url ))
                .GET()
                .build();
        HttpResponse<String> response = httpClient.send(request, HttpResponse.BodyHandlers.ofString());
        return response.body();

    }

    private static final HttpClient httpClient = HttpClient.newBuilder()
            .version(HttpClient.Version.HTTP_1_1)
            .connectTimeout(Duration.ofSeconds(10))
            .build();


}
