package com.example.subjectservice.repositories;

import com.example.subjectservice.models.Subject;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SubjectRepository extends JpaRepository<Subject,Long> {
}
