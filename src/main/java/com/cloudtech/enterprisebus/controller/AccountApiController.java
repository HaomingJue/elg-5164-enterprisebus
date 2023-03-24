package com.cloudtech.enterprisebus.controller;

import com.cloudtech.enterprisebus.dto.AccountRequest;
import org.apache.coyote.Response;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;



@RestController
@RequestMapping("/accounts")
public class AccountApiController {

    private final String BASE_URL = "http://34.23.38.111/accounts";
    private final RestTemplate restTemplate;

    public AccountApiController(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    @GetMapping
    public ResponseEntity<?> getAllAccounts() {
        String url = BASE_URL; // replace with the URL of the external API
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        HttpEntity<String> requestEntity = new HttpEntity<>(null, headers);
        ResponseEntity<String> responseEntity = restTemplate.exchange(url, HttpMethod.GET, requestEntity, String.class);
        String responseBody = responseEntity.getBody();

        return new ResponseEntity<>(responseBody, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getAccountById(@PathVariable("id") Long id) {
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
    public ResponseEntity<?> createAccount(@RequestBody AccountRequest accountRequest) {
        String url = BASE_URL;
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);

        HttpEntity<AccountRequest> requestEntity = new HttpEntity<>(accountRequest, headers);
        ResponseEntity<String> responseEntity = restTemplate.exchange(url, HttpMethod.POST, requestEntity, String.class);
        String responseBody = responseEntity.getBody();
        HttpStatus statusCode = HttpStatus.valueOf(responseEntity.getStatusCode().value());

        return new ResponseEntity<>(responseBody, statusCode);
    }

    @DeleteMapping
    public ResponseEntity<?> deleteAllAccounts() {
        String url = BASE_URL;
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);

        HttpEntity<AccountRequest> requestEntity = new HttpEntity<>(headers);
        ResponseEntity<String> responseEntity = restTemplate.exchange(url, HttpMethod.DELETE, requestEntity, String.class);
        String responseBody = responseEntity.getBody();

        return new ResponseEntity<>(responseBody, HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteAccountById(@PathVariable("id") Long id) {
        String url = BASE_URL + "/" + id;
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);

        HttpEntity<AccountRequest> requestEntity = new HttpEntity<>(headers);
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

