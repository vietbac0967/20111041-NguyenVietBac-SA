package com.example.subjectservice.controllers;

import com.example.subjectservice.models.Subject;
import com.example.subjectservice.repositories.SubjectRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/subject")
@RequiredArgsConstructor
public class SubjectController {
    private final SubjectRepository subjectRepository;

    @PostMapping
    public Subject createSubject(@RequestBody Subject subject) {
        return subjectRepository.save(subject);
    }

    @GetMapping("/{id}")
    public Subject getSubjectById(@PathVariable("id") Long id) {
        return subjectRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Not found subject"));
    }
}
