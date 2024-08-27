package com.FacultyManagement.FacultyMgmtAPI.repository;

import com.FacultyManagement.FacultyMgmtAPI.model.Faculty;
import jakarta.persistence.Id;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface FacultyRepository extends JpaRepository<Faculty, Id> {
    Optional<Faculty> findById(int id);


    boolean existsById(int id);

    void deleteById(int id);
}
