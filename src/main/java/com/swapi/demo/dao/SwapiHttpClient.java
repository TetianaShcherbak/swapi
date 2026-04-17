package com.swapi.demo.dao;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestClient;

import java.net.URI;
import java.rmi.server.ExportException;

@Component
public class SwapiHttpClient {

    private final RestClient restClient;

    public SwapiHttpClient(@Value("${swapi.base-url:https://swapi.info/api}") String baseUrl) {
        this.restClient = RestClient.builder()
                .baseUrl(baseUrl)
                .defaultHeader(HttpHeaders.ACCEPT, MediaType.APPLICATION_JSON_VALUE)
                .build();
    }

    public <T> T get(String path, Class<T> responseType) {
        return restClient.get()
                .uri(path)
                .retrieve()
                .onStatus(HttpStatusCode::is4xxClientError, (req, res) -> {
                    throw new ExportException("Resource not found at: " + path);
                })
                .onStatus(HttpStatusCode::is5xxServerError, (req, res) -> {
                    throw new ExportException("SWAPI returned server error for: " + path);
                })
                .body(responseType);
    }

    public <T> T getByUrl(String fullUrl, Class<T> responseType) {
        return restClient.get()
                .uri(URI.create(fullUrl))   // absolute URL — used when resolving film URLs from a Person
                .retrieve()
                .onStatus(HttpStatusCode::is4xxClientError, (req, res) -> {
                    throw new ExportException("Resource not found: " + fullUrl);
                })
                .body(responseType);
    }
}
