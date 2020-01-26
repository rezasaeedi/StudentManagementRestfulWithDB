package com.example.testdatabase.repository;

import com.example.testdatabase.model.School;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SchoolRepository extends JpaRepository<School , Long> {
}
