package com.example.practiceservice.controllers;

import com.example.practiceservice.models.Subject;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

@RestController
@RequestMapping("/api/practice")
public class PracticeController {
    @GetMapping("/{id}")
    public Subject getSubjectFormPractice(@PathVariable("id") Long id){
        RestTemplate restTemplate = new RestTemplate();
        String url = "http://localhost:8088/api/subject/" + id;
        return  restTemplate.getForObject(url,Subject.class);
    }


}
