package com.ironhack.relationshipsdemo.repository;

import com.ironhack.relationshipsdemo.model.Prefect;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface PrefectRepository extends JpaRepository<Prefect, Long> {
    @Query("SELECT p FROM Prefect p JOIN FETCH p.students WHERE p.id = :id")
    Optional<Prefect> findByIdWithStudents(@Param("id") Long prefectId);
}
