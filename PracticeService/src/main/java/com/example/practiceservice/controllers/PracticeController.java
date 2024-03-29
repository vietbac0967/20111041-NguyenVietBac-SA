package com.example.practiceservice.controllers;

import com.example.practiceservice.models.Subject;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.HttpServerErrorException;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

@RestController
@RequestMapping("/api/practice")
public class PracticeController {

    @PostMapping
    public ResponseEntity<Subject> createSubjectFormPractice(@RequestBody Subject subject) {
        RestTemplate restTemplate = new RestTemplate();
        String url = "http://localhost:8088/api/subject";

        try {
            ResponseEntity<Subject> responseEntity = restTemplate.postForEntity(url, subject, Subject.class);
            return ResponseEntity.status(responseEntity.getStatusCode()).body(responseEntity.getBody());
        } catch (HttpClientErrorException | HttpServerErrorException ex) {
            // Handle client or server errors
            return ResponseEntity.status(ex.getRawStatusCode()).body(null);
        } catch (RestClientException ex) {
            // Handle other REST client exceptions
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }
    }

    @GetMapping("/{id}")
    public Subject getSubjectFormPractice(@PathVariable("id") Long id) {
        RestTemplate restTemplate = new RestTemplate();
        String url = "http://localhost:8088/api/subject/" + id;
        return restTemplate.getForObject(url, Subject.class);
    }


}
