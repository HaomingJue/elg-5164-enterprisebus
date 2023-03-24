package com.cloudtech.enterprisebus.controller;

import com.cloudtech.enterprisebus.dto.OrderRequest;
import org.apache.coyote.Response;
import org.springframework.core.annotation.Order;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;



@RestController
@RequestMapping("/orders")
public class OrderApiController {

    private final String BASE_URL = "http://34.148.161.115/orders";
    private final RestTemplate restTemplate;

    public OrderApiController(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    @GetMapping
    public ResponseEntity<?> getAllOrders() {
        String url = BASE_URL; // replace with the URL of the external API
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        HttpEntity<String> requestEntity = new HttpEntity<>(null, headers);
        ResponseEntity<String> responseEntity = restTemplate.exchange(url, HttpMethod.GET, requestEntity, String.class);
        String responseBody = responseEntity.getBody();

        return new ResponseEntity<>(responseBody, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getOrderById(@PathVariable("id") Long id) {
        String url = BASE_URL + "/" + id;
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        HttpEntity<String> requestEntity = new HttpEntity<>(headers);
        try {
            ResponseEntity<String> responseEntity = restTemplate.exchange(url, HttpMethod.GET, requestEntity, String.class);
            String responseBody = responseEntity.getBody();
            return new ResponseEntity<>(responseBody, HttpStatus.OK);
        }
        catch(Exception e) {
            return new ResponseEntity<>(e.toString(), HttpStatus.NOT_FOUND);
        }

    }

    @PostMapping
    public ResponseEntity<?> createOrder(@RequestBody OrderRequest orderRequest) {
        String url = BASE_URL;
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);

        HttpEntity<OrderRequest> requestEntity = new HttpEntity<>(orderRequest, headers);
        ResponseEntity<String> responseEntity = restTemplate.exchange(url, HttpMethod.POST, requestEntity, String.class);
        String responseBody = responseEntity.getBody();
        HttpStatus statusCode = HttpStatus.valueOf(responseEntity.getStatusCode().value());

        return new ResponseEntity<>(responseBody, statusCode);
    }

    @DeleteMapping
    public ResponseEntity<?> deleteAllOrders() {
        String url = BASE_URL;
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);

        HttpEntity<OrderRequest> requestEntity = new HttpEntity<>(headers);
        ResponseEntity<String> responseEntity = restTemplate.exchange(url, HttpMethod.DELETE, requestEntity, String.class);
        String responseBody = responseEntity.getBody();

        return new ResponseEntity<>(responseBody, HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteOrderById(@PathVariable("id") Long id) {
        String url = BASE_URL + "/" + id;
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);

        HttpEntity<OrderRequest> requestEntity = new HttpEntity<>(headers);
        try {
            ResponseEntity<String> responseEntity = restTemplate.exchange(url, HttpMethod.DELETE, requestEntity, String.class);
            String responseBody = responseEntity.getBody();
            HttpStatus statusCode = HttpStatus.valueOf(responseEntity.getStatusCode().value());
            return new ResponseEntity<>(responseBody, statusCode);
        }
        catch (Exception e) {
            return new ResponseEntity<>(e.toString(), HttpStatus.NOT_FOUND);
        }

    }
}

