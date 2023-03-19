package com.cloudtech.enterprisebus.controller;

import org.springframework.http.*;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;



@RestController
@RequestMapping("/products")
public class ProductApiController {

    private final String BASE_URL = "http://localhost:8080/products";
    private final RestTemplate restTemplate;

    public ProductApiController(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    @GetMapping
    public ResponseEntity<String> getAllProducts() {
        String url = BASE_URL; // replace with the URL of the external API


        HttpEntity<String> requestEntity = new HttpEntity<>(null);
        ResponseEntity<String> responseEntity = restTemplate.exchange(url, HttpMethod.GET, requestEntity, String.class);
        String responseBody = responseEntity.getBody();

        return new ResponseEntity<>(responseBody, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<String> getProductById(@PathVariable("id") Long id) {
        String url = BASE_URL + "/" + id;

        HttpEntity<String> requestEntity = new HttpEntity<>(null);
        ResponseEntity<String> responseEntity = restTemplate.exchange(url, HttpMethod.GET, requestEntity, String.class);
        String responseBody = responseEntity.getBody();

        return new ResponseEntity<>(responseBody, HttpStatus.OK);
    }

}

